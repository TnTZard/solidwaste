package com.anzhi.solidwaste.web;

import com.anzhi.solidwaste.common.response.AzResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author anzhi
 * @date 2019/8/30 16:34
 */

@RestController
@RequestMapping("/v1")
public class LoginController {


    /**
     *  固废项目注册接口  分为人员注册 和 企业注册
     *
     *
     * @return
     */
    @GetMapping("/register")
    public AzResponse register() {

        // 注册分为三种
        // 1.环保
        // 2.有企业
        // 3.无企业


        return null;
    }






}
