package com.anzhi.solidwaste.enterprise.mapper;

import com.anzhi.solidwaste.enterprise.entity.MonitorData;
import com.anzhi.solidwaste.enterprise.search.DataSearch;
import com.anzhi.solidwaste.enterprise.vo.HistoryDataVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author Anzhi
* @since 2019-09-04
*/
public interface MonitorDataMapper extends BaseMapper<MonitorData> {
    /**
     * 查找监控历史数据
     * @param dataSearch
     * @return
     */
    List<HistoryDataVo> findHistoryDatas(DataSearch dataSearch);
}
