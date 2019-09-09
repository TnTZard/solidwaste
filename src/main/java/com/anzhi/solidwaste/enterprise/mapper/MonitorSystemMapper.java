package com.anzhi.solidwaste.enterprise.mapper;

import com.anzhi.solidwaste.common.domain.QueryRequest;
import com.anzhi.solidwaste.enterprise.entity.MonitorSystem;
import com.anzhi.solidwaste.enterprise.search.MonitorSearch;
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


    List<MonitorRealTimeVo> findAllByCondition(QueryRequest queryRequest, MonitorSearch monitorSearch);

}
