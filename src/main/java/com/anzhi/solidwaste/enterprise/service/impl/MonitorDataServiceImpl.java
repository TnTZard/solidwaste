package com.anzhi.solidwaste.enterprise.service.impl;

import com.anzhi.solidwaste.common.domain.QueryRequest;
import com.anzhi.solidwaste.enterprise.entity.MonitorData;
import com.anzhi.solidwaste.enterprise.mapper.MonitorDataMapper;
import com.anzhi.solidwaste.enterprise.search.DataSearch;
import com.anzhi.solidwaste.enterprise.service.MonitorDataService;
import com.anzhi.solidwaste.enterprise.vo.HistoryDataVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Anzhi
 * @since 2019-09-04
 */
@Service
public class MonitorDataServiceImpl extends ServiceImpl<MonitorDataMapper, MonitorData> implements MonitorDataService {


    @Override
    public List<HistoryDataVo> listHistoryData(QueryRequest queryRequest, DataSearch dataSearch) {

        int num = queryRequest.getPageNum();
        int size = queryRequest.getPageSize();
        queryRequest.setPageNum((num-1)*size);


        return this.baseMapper.findHistoryDatas(queryRequest, dataSearch);
    }



}
