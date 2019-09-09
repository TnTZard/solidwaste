package com.anzhi.solidwaste.enterprise.service;

import com.anzhi.solidwaste.common.domain.QueryRequest;
import com.anzhi.solidwaste.enterprise.entity.AccessLog;
import com.anzhi.solidwaste.enterprise.search.AccessSearch;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Anzhi
 * @since 2019-09-03
 */
public interface AccessLogService extends IService<AccessLog> {

    IPage<AccessLog> listAll(QueryRequest queryRequest, AccessSearch accessSearch);

}
