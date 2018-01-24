package com.bsbs.services.consumers;

import com.bsbs.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class RestConnectorService {
    private final static Logger LOG = LoggerFactory.getLogger(RestConnectorService.class);

    public User getUserDetails(String userName) {
        LOG.info("Call getUserDetails with userName: {}", userName);
        String url = "http://localhost:8881/rest/searchUser";
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(url)
                .queryParam("userName",userName);
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject(uriComponentsBuilder.toUriString(), User.class);
        } catch (RestClientException ex) {
            LOG.error(ex.getMessage(), ex);
            throw ex;
        }
    }

}
