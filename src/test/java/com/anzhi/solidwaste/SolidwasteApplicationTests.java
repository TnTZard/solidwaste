package com.anzhi.solidwaste;

import com.anzhi.solidwaste.enterprise.service.WasteCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SolidwasteApplicationTests {

    @Autowired
    private WasteCategoryService wasteCategoryService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testCategories() {
        this.wasteCategoryService.getAllCategories();
    }

}
