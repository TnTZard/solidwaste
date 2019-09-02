package com.anzhi.solidwaste.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;

/**
 * @author anzhi
 * @date 2019/8/27 10:36
 */
@SpringBootConfiguration
public class WebConfiguration {

    @Value("${server.port}")
    public String port;

}
