package com.bsbs.services;

import com.bsbs.model.User;
import com.bsbs.services.consumers.RestConnectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class Home {

    RestConnectorService restConnectorService;

    @Autowired
    public Home(RestConnectorService restConnectorService) {
        this.restConnectorService = restConnectorService;
    }

    @GetMapping(path = "/")
    public String homeDef() {
        return "Welcome to Home";
    }

    @GetMapping(path = "/home", params = "userName")
    public String home(@RequestParam String userName) {
        User user = restConnectorService.getUserDetails(userName);
        return String.format("Input user name: %s\r\nUser details:\r\n UserName: %s\r\n UserDescription: %s", userName,
                user.getUserName(), user.getUserDescription());
    }

}
