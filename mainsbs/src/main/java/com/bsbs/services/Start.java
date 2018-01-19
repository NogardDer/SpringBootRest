package com.bsbs.services;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Start {

    @RequestMapping("/")
    @ResponseBody
    public String start() {
        return "Start page";
    }
}
