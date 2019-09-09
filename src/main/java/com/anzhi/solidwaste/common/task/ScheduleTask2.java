package com.anzhi.solidwaste.common.task;

import com.anzhi.solidwaste.common.generator.Test;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author anzhi
 * @date 2019/8/27 15:43
 */
@Component
public class ScheduleTask2 {

    //@Async
    //@Scheduled(fixedRate = 60*1000)
    public void test1() {
        System.out.println("开始测试网站");

        if(Test.testUrlWithTimeOut("http://www.szzfcg.cn/home/1/indexca.jsp", 2000)){
            System.out.println("可以");

        } else {
            System.out.println("不可以");
        }
//        Test.testUrlWithTimeOut("http://www.baidu.com", 2000);
//        Test.testUrlWithTimeOut("http://cgzx.sz.gov.cn/", 2000);

    }

//    @Async
//    @Scheduled(fixedRate = 3000)
//    public void test2() {
//        System.out.println("这是测试任务2");
//    }

}
