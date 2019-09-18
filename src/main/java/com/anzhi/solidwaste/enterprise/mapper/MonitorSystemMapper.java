package com.anzhi.solidwaste.enterprise.mapper;

import com.anzhi.solidwaste.common.domain.QueryRequest;
import com.anzhi.solidwaste.enterprise.entity.Enterprise;
import com.anzhi.solidwaste.enterprise.entity.MonitorSystem;
import com.anzhi.solidwaste.enterprise.search.AreaSearch;
import com.anzhi.solidwaste.enterprise.search.MonitorSearch;
import com.anzhi.solidwaste.enterprise.vo.EnterpriseVo;
import com.anzhi.solidwaste.enterprise.vo.IndexVo;
import com.anzhi.solidwaste.enterprise.vo.MonitorRealTimeVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author Anzhi
* @since 2019-09-03
*/
@Repository
public interface MonitorSystemMapper extends BaseMapper<MonitorSystem> {

    /**
     *
     * @param queryRequest
     * @param monitorSearch
     * @return
     */
    List<MonitorRealTimeVo> findAllByCondition(QueryRequest queryRequest, MonitorSearch monitorSearch);


    IndexVo findIndecVo(AreaSearch areaSearch);

    /**
     * 根据区域街道获取企业数量
     * @param areaSearch
     * @return
     */
    int getEnterpriseCount(AreaSearch areaSearch);

    /**
     * 根据区域街道获取仓库数量
     * @param areaSearch
     * @return
     */
    int getDepotCount(AreaSearch areaSearch);


    /**
     * 根据区域街道获取危废类别数
     * @param areaSearch
     * @return
     */
    List<String> getWasteCount(AreaSearch areaSearch);

    /**
     * 根据区域街道获取危废总数（t）
     * @param areaSearch
     * @return
     */
    Integer getWasteAmount(AreaSearch areaSearch);


    List<EnterpriseVo> getAllEnterpriseByArea(AreaSearch areaSearch);

}
