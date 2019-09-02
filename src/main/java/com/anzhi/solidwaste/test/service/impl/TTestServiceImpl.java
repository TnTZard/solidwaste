package com.anzhi.solidwaste.test.service.impl;

import com.anzhi.solidwaste.test.entity.TTest;
import com.anzhi.solidwaste.test.mapper.TTestMapper;
import com.anzhi.solidwaste.test.service.ITTestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Anzhi
 */
@Service
public class TTestServiceImpl extends ServiceImpl<TTestMapper, TTest> implements ITTestService {

}
