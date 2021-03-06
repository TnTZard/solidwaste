package com.anzhi.solidwaste.enterprise.service.impl;

import com.anzhi.solidwaste.common.domain.QueryRequest;
import com.anzhi.solidwaste.enterprise.entity.Depot;
import com.anzhi.solidwaste.enterprise.entity.Enterprise;
import com.anzhi.solidwaste.enterprise.entity.HazardousWaste;
import com.anzhi.solidwaste.enterprise.entity.MonitorSystem;
import com.anzhi.solidwaste.enterprise.mapper.DepotMapper;
import com.anzhi.solidwaste.enterprise.mapper.EnterpriseMapper;
import com.anzhi.solidwaste.enterprise.mapper.HazardousWasteMapper;
import com.anzhi.solidwaste.enterprise.mapper.MonitorSystemMapper;
import com.anzhi.solidwaste.enterprise.search.AreaSearch;
import com.anzhi.solidwaste.enterprise.search.MonitorSearch;
import com.anzhi.solidwaste.enterprise.service.MonitorSystemService;
import com.anzhi.solidwaste.enterprise.vo.EnterpriseVo;
import com.anzhi.solidwaste.enterprise.vo.IndexVo;
import com.anzhi.solidwaste.enterprise.vo.MonitorRealTimeVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anzhi
 * @since 2019-09-03
 */
@Service
@Slf4j
public class MonitorSystemServiceImpl extends ServiceImpl<MonitorSystemMapper, MonitorSystem> implements MonitorSystemService {

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Autowired
    private DepotMapper depotMapper;

    @Autowired
    private MonitorSystemMapper monitorSystemMapper;

    @Autowired
    private HazardousWasteMapper hazardousWasteMapper;

    @Override
    public IPage<Enterprise> listAll(QueryRequest queryRequest, MonitorSearch monitorSearch) {

        LambdaQueryWrapper<Enterprise> queryWrapper = new LambdaQueryWrapper<>();

        if(StringUtils.isNotBlank(monitorSearch.getEnterpriseName())) {
            queryWrapper.eq(Enterprise::getName, monitorSearch.getEnterpriseName());
        }

        // 先查出企业
        Page<Enterprise> page = new Page<>(queryRequest.getPageNum(), queryRequest.getPageSize());
        IPage<Enterprise>iPage = this.enterpriseMapper.selectPage(page, queryWrapper);

        iPage.getRecords().stream().forEach( en -> {
            // 查出属于该企业的仓库
            List<Depot> depots = this.depotMapper.selectList(new LambdaQueryWrapper<Depot>()
                    .eq(Depot::getEnterpriseName, en.getName()));

            depots.stream().forEach( d -> {
                // 查出 该仓库的监控系统
                MonitorSystem monitorSystem = this.monitorSystemMapper.selectOne(new LambdaQueryWrapper<MonitorSystem>()
                        .eq(MonitorSystem::getDepotId, d.getDepotId()));
                // 查出 该仓库的危废(没有出库操作的危废)
                List<HazardousWaste> hazardousWastes = this.hazardousWasteMapper.selectList(new LambdaQueryWrapper<HazardousWaste>()
                        .eq(HazardousWaste::getDepotId, d.getDepotId()));
                List<String> wasteCategories = new ArrayList<>();
                for(HazardousWaste h:hazardousWastes){
                    wasteCategories.add(h.getWasteCategory());
                }
                d.setMonitorSystem(monitorSystem);
                d.setHazardousWasteList(hazardousWastes);
                d.setWasteCategories(wasteCategories);
            });

            en.setDepotList(depots);
        });

        return iPage;
    }

    @Override
    public List<MonitorRealTimeVo> listAll1(QueryRequest queryRequest, MonitorSearch monitorSearch) {
        return this.baseMapper.findAllByCondition(queryRequest, monitorSearch);
    }

    /**
     * 查询首页数据
     * @param areaSearch
     * @return
     */
    @Override
    public IndexVo findIndexInfo(AreaSearch areaSearch) {
        IndexVo indexVo = new IndexVo();
        // 得到企业总数和仓库总数
        int countEnterprise = this.baseMapper.getEnterpriseCount(areaSearch);
        int countDepot = this.baseMapper.getDepotCount(areaSearch);
        List<String> wasteCategories = this.baseMapper.getWasteCount(areaSearch);
        List<EnterpriseVo> enterpriseVos = this.baseMapper.getAllEnterpriseByArea(areaSearch);
        wasteCategories.stream().forEach(s -> {
            System.out.println("危废种类 ： " + s);
        });
        int countWasteCategory = wasteCategories.size();
        int wasteAmount = this.baseMapper.getWasteAmount(areaSearch);
        System.out.println("---------------------------------------------------------");
        System.out.println("-----  危废总数 ：  " + wasteAmount + "  kg  ---------");
        System.out.println("---------------------------------------------------------");
        indexVo.setEnterpriseList(enterpriseVos);
        indexVo.setEnterpriseCount(countEnterprise);
        indexVo.setDepotCount(countDepot);
        indexVo.setWasteCategoryCount(countWasteCategory);
        indexVo.setWasteAmount(wasteAmount);
        return indexVo;

    }
}
