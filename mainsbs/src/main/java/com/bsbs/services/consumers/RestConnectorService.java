package com.bsbs.services.consumers;

import com.bsbs.model.User;
import com.bsbs.services.utils.RestBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.bsbs.services.consumers.DBServiceConfiguration.*;

/**
 * RestConnectorService.class is a service. This class connects to external rest service.
 * Connection details use from Spring application context and DBServiceConfiguration.class {@link DBServiceConfiguration}
 *
 * @author Volodymyr Severenchuk
 * Created on 1/30/2018
 */
@Component
public class RestConnectorService {
    private final static Logger LOG = LoggerFactory.getLogger(RestConnectorService.class);

    private @Value("${db.service.url}") String dbServiceURL;

    /**
     * getUserDetails method is getting information about user by user name.
     *
     * @param userName is user name String value.
     * @return User details. {@link User}
     */
    public User getUserDetails(String userName) {
        LOG.info("Call getUserDetails with userName: {}", userName);
        return RestBuilder.createBuilder(User.class, generateURL(SEARCH_USER))
                .with("userName", userName)
                .call();
    }

    private String generateURL(DBServiceConfiguration dbServiceConfiguration) {
        return dbServiceConfiguration.generateServicePath(dbServiceURL);
    }

}
