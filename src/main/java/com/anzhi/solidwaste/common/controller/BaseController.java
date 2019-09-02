package com.anzhi.solidwaste.common.controller;

import com.anzhi.solidwaste.common.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author anzhi
 * @date 2019/8/27 11:43
 */
@Controller
public class BaseController {

    @Autowired
    private WebConfiguration webConfig;

    @RequestMapping("hello")
    public String Hello(Model model) {
        model.addAttribute("port", webConfig.port);
        return "hello";
    }

}
