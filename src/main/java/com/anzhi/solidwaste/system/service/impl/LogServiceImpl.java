package com.anzhi.solidwaste.system.service.impl;

import com.anzhi.solidwaste.system.entity.Log;
import com.anzhi.solidwaste.system.mapper.LogMapper;
import com.anzhi.solidwaste.system.service.LogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Anzhi
 * @since 2019-09-03
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

}
