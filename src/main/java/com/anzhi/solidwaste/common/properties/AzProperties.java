package com.anzhi.solidwaste.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author andy
 * @date 2019/7/1 9:45
 */
@Data
@Configuration
@Component
@ConfigurationProperties(prefix = "az")
public class AzProperties {

    private ShiroProperties shiro = new ShiroProperties();

    private boolean openAopLpg = true;


}
