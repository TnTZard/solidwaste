package com.anzhi.solidwaste.sys.service.impl;

import com.anzhi.solidwaste.sys.entity.Test;
import com.anzhi.solidwaste.sys.mapper.TestMapper;
import com.anzhi.solidwaste.sys.service.TestService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Anzhi
 * @since 2019-08-29
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {


    public IPage<Test> selectPageVo(Page page, Integer state) {
        return this.baseMapper.selectPageVo(page,state);
    }

    @Override
    public IPage<Test> findByPage(Page<Test> page) {
        return this.baseMapper.selectPage(page,null);
    }
}
