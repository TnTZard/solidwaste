package com.anzhi.solidwaste;

import com.anzhi.solidwaste.sys.service.TestService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SolidwasteApplicationTests {

    @Autowired
    private TestService testService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void page(){

        System.out.println("helloworld");
        Page<Test> page = new Page<>(1, 10);
//        page.setRecords(testService.list(new QueryWrapper<Test>()));
    }

}
