package com.anzhi.solidwaste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * @author anzhi
 * @date 2019-09-01
 */

@EnableAsync
@EnableScheduling
@EnableConfigurationProperties
@SpringBootApplication
public class SolidWasteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SolidWasteApplication.class, args);
    }

}
