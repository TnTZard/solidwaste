package com.anzhi.solidwaste.enterprise.service.impl;

import com.anzhi.solidwaste.common.domain.QueryRequest;
import com.anzhi.solidwaste.enterprise.entity.AccessLog;
import com.anzhi.solidwaste.enterprise.mapper.AccessLogMapper;
import com.anzhi.solidwaste.enterprise.search.AccessSearch;
import com.anzhi.solidwaste.enterprise.service.AccessLogService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author Anzhi
 * @since 2019-09-03
 */
@Service
public class AccessLogServiceImpl extends ServiceImpl<AccessLogMapper, AccessLog> implements AccessLogService {

    @Override
    public IPage<AccessLog> listAll(QueryRequest queryRequest, AccessSearch accessSearch) {
        LambdaQueryWrapper<AccessLog> queryWrapper = new LambdaQueryWrapper<>();

        if(StringUtils.isNotBlank(accessSearch.getEnterpriseName())){
            queryWrapper.eq(AccessLog::getEnterprise, accessSearch.getEnterpriseName());
        }
        if(StringUtils.isNotBlank(accessSearch.getPerson())){
            queryWrapper.eq(AccessLog::getPerson, accessSearch.getPerson());
        }
        if(StringUtils.isNotBlank(accessSearch.getStartTime() ) && StringUtils.isNotBlank(accessSearch.getEndTime())){
            queryWrapper
                    .ge(AccessLog::getGmtEnter, accessSearch.getStartTime())
                    .lt(AccessLog::getGmtEnter, accessSearch.getEndTime());
        }

        Page<AccessLog> page = new Page<>(queryRequest.getPageNum(), queryRequest.getPageSize());
        page.setAsc("id");

        return this.baseMapper.selectPage(page, queryWrapper);
    }
}
