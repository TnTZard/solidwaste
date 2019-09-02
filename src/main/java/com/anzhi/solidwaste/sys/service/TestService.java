package com.anzhi.solidwaste.sys.service;

import com.anzhi.solidwaste.sys.entity.Test;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * @author Anzhi
 * @since 2019-08-29
 */
public interface TestService extends IService<Test> {


    /**
     *
     * @param page
     * @return
     */
    IPage<Test> findByPage(Page<Test> page);



}
