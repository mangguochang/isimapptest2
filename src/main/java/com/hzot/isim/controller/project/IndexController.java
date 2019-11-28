package com.hzot.isim.controller.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class IndexController {


    @GetMapping("welcome")
    public String welcome(HttpServletRequest request) {

        return "welcome";
    }

}
