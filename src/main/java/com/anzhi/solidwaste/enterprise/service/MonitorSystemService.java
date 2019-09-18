package com.anzhi.solidwaste.enterprise.service;

import com.anzhi.solidwaste.common.domain.QueryRequest;
import com.anzhi.solidwaste.enterprise.entity.Enterprise;
import com.anzhi.solidwaste.enterprise.entity.MonitorSystem;
import com.anzhi.solidwaste.enterprise.search.AreaSearch;
import com.anzhi.solidwaste.enterprise.search.MonitorSearch;
import com.anzhi.solidwaste.enterprise.vo.IndexVo;
import com.anzhi.solidwaste.enterprise.vo.MonitorRealTimeVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Anzhi
 * @since 2019-09-03
 */
public interface MonitorSystemService extends IService<MonitorSystem> {

    /**
     * 一个企业下的所有 监控系统 = 所有仓库
     * @param queryRequest
     * @param monitorSearch
     * @return
     */
    IPage<Enterprise> listAll(QueryRequest queryRequest, MonitorSearch monitorSearch);

    List<MonitorRealTimeVo> listAll1(QueryRequest queryRequest, MonitorSearch monitorSearch);


    /**
     * 查找首页监控概览所需数据
     * @param areaSearch
     * @return
     */
    IndexVo findIndexInfo(AreaSearch areaSearch);


}
