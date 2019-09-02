package com.anzhi.solidwaste.sys.mapper;

import com.anzhi.solidwaste.sys.dto.User;
import com.anzhi.solidwaste.sys.entity.Test;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author Anzhi
* @since 2019-08-29
*/
public interface TestMapper extends BaseMapper<Test> {
    IPage<Test> selectPageVo(Page page, @Param("state") Integer state);

    @Select("selct * from test")
    List<User> selectTestList(IPage<Test> page);
}
