package com.bsbs.dbservices;

import com.bsbs.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * DB rest service.
 *
 * @author Volodymyr Severenchuk
 * Created on 1/30/2018
 */
@RestController
@RequestMapping("/rest")
public class DBService {
    private final static Logger LOG = LoggerFactory.getLogger(DBService.class);

    /**
     * Get user information by user name.
     *
     * @param userName is user name String value.
     * @return user details. {@link User}
     */
    @GetMapping(path = "/searchUser")
    public User getUserByName(@RequestParam String userName) {
        LOG.info("Call getUserByName with userName: {}", userName);
        return new User(userName, userName + " Description");
    }

}
