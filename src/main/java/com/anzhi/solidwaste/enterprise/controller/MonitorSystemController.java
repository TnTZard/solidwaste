package com.anzhi.solidwaste.enterprise.controller;

import com.anzhi.solidwaste.common.domain.QueryRequest;
import com.anzhi.solidwaste.common.response.*;

import com.anzhi.solidwaste.enterprise.entity.Enterprise;
import com.anzhi.solidwaste.enterprise.entity.MonitorData;
import com.anzhi.solidwaste.enterprise.search.DataSearch;
import com.anzhi.solidwaste.enterprise.search.MonitorSearch;
import com.anzhi.solidwaste.enterprise.service.MonitorDataService;
import com.anzhi.solidwaste.enterprise.service.MonitorSystemService;
import com.anzhi.solidwaste.enterprise.vo.HistoryDataVo;
import com.anzhi.solidwaste.enterprise.vo.MonitorRealTimeVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Anzhi
 * @since 2019-09-03
 */
@Api(tags = "监测系统")
@RestController
@RequestMapping("/enterprise/monitor-system")
public class MonitorSystemController {



    @Autowired
    private MonitorSystemService monitorSystemService;

    @Autowired
    private MonitorDataService monitorDataService;

    @PostMapping("/")
    public AzResponse add(@Validated @RequestBody Object vo){

        return null;
    }

    @GetMapping("/")
    public AzResponse get(@ApiParam(name = "id", value = "id") @RequestParam String id){

        return null;
    }

    @ApiOperation("监控列表(监控概览)")
    @GetMapping("/page")
    public AzResponse page(QueryRequest queryRequest, MonitorSearch monitorSearch){
        IPage<Enterprise> result = this.monitorSystemService.listAll(queryRequest, monitorSearch);
        return new AzResponse(true, result, 200, "查询成功");
    }

    @ApiOperation("监控列表(环境治理)")
    @GetMapping("/page1")
    public AzResponse<Page1Vo> page1(QueryRequest queryRequest, MonitorSearch monitorSearch){
        Page1Vo page1Vo = new Page1Vo();
        List<MonitorRealTimeVo> realTimeVoList = this.monitorSystemService.listAll1(queryRequest, monitorSearch);
        page1Vo.setRealTimeVoList(realTimeVoList);
        return new AzResponse(true, page1Vo, 200, "查询成功");
    }

    @ApiOperation("历史数据")
    @GetMapping("/history")
    public AzResponse<HistoryDataListVo> getHistoryData(QueryRequest queryRequest, DataSearch dataSearch){
        HistoryDataListVo result = new HistoryDataListVo();
        List<HistoryDataVo> historyDataVos = this.monitorDataService.listHistoryData(queryRequest, dataSearch);
        result.setHistoryDataVoList(historyDataVos);
        return new AzResponse(true, result, 200, "查询成功");
    }


    @PutMapping("/")
    public AzResponse update(@Validated @RequestBody Object vo){
        return null;
    }

    @DeleteMapping("/")
    public AzResponse delete(@ApiParam(name = "id", value = "id") @RequestParam String id){
        return null;
    }
}


/**
 *  用于API文档显示 封装类
 */
class Page1Vo{

    @ApiModelProperty(value = "监控列表(环境治理)")
    private List<MonitorRealTimeVo> realTimeVoList;

    public List<MonitorRealTimeVo> getRealTimeVoList() {
        return realTimeVoList;
    }

    public void setRealTimeVoList(List<MonitorRealTimeVo> realTimeVoList) {
        this.realTimeVoList = realTimeVoList;
    }
}
class HistoryDataListVo{
    private List<HistoryDataVo> historyDataVoList;

    public List<HistoryDataVo> getHistoryDataVoList() {
        return historyDataVoList;
    }

    public void setHistoryDataVoList(List<HistoryDataVo> historyDataVoList) {
        this.historyDataVoList = historyDataVoList;
    }
}