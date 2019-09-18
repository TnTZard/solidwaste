package com.anzhi.solidwaste.enterprise.mapper;

import com.anzhi.solidwaste.common.domain.QueryRequest;
import com.anzhi.solidwaste.enterprise.entity.MonitorData;
import com.anzhi.solidwaste.enterprise.search.DataSearch;
import com.anzhi.solidwaste.enterprise.vo.HistoryDataVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

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
    List<HistoryDataVo> findHistoryDatas(@Param("queryRequest") QueryRequest queryRequest, @Param("dataSearch") DataSearch dataSearch);
}
