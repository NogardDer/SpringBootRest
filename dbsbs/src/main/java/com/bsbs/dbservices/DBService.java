package com.bsbs.dbservices;

import com.bsbs.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class DBService {

    @GetMapping(path = "/searchUser", params = "userName")
    public User getUserByName(@RequestParam String userName) {
        return new User(userName, userName + " Description");
    }

}
