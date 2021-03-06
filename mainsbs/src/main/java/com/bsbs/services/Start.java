package com.bsbs.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Start.class is web service.
 *
 * @author Volodymyr Severenchuk
 * Created on 1/30/2018
 */
@Controller
public class Start {
    private final static Logger LOG = LoggerFactory.getLogger(Start.class);

    /**
     * Strat page.
     *
     * @return Start page.
     */
    @RequestMapping("/")
    @ResponseBody
    public String start() {
        LOG.info("Call start");
        return "Start page";
    }
}
