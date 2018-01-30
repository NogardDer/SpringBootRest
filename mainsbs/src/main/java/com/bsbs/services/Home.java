package com.bsbs.services;

import com.bsbs.model.User;
import com.bsbs.services.consumers.RestConnectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Home.class is web service.
 *
 * @author Volodymyr Severenchuk
 * Created on 1/30/2018
 */
@RestController
@RequestMapping("/home")
public class Home {
    private final static Logger LOG = LoggerFactory.getLogger(Home.class);

    private RestConnectorService restConnectorService;

    @Autowired
    public Home(RestConnectorService restConnectorService) {
        this.restConnectorService = restConnectorService;
    }

    /**
     * Home page.
     *
     * @return Home page.
     */
    @GetMapping(path = "/")
    public String homeDef() {
        LOG.info("Call homeDef()");
        return "Welcome to Home";
    }

    /**
     * Request information about user by user name.
     *
     * @param userName is name of user String value.
     * @return User information. {@link RestConnectorService}
     */
    @GetMapping(path = "/home")
    public String home(@RequestParam String userName) {
        LOG.info("Call home with userName: {}", userName);
        User user = restConnectorService.getUserDetails(userName);
        return String.format("Input user name: %s<br/>User details:<br/> UserName: %s<br/> UserDescription: %s", userName,
                user.getUserName(), user.getUserDescription());
    }

}
