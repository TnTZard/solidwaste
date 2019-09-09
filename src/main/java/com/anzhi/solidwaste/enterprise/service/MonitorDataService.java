package com.anzhi.solidwaste.enterprise.service;

import com.anzhi.solidwaste.common.domain.QueryRequest;
import com.anzhi.solidwaste.enterprise.entity.MonitorData;
import com.anzhi.solidwaste.enterprise.search.DataSearch;
import com.anzhi.solidwaste.enterprise.vo.HistoryDataVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Anzhi
 * @since 2019-09-04
 */
public interface MonitorDataService extends IService<MonitorData> {


    List<HistoryDataVo> listHistoryData(QueryRequest queryRequest, DataSearch dataSearch);

}
