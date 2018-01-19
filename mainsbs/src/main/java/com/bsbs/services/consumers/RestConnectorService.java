package com.bsbs.services.consumers;

import com.bsbs.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class RestConnectorService {

    public User getUserDetails(String userName) {
        String url = "http://localhost:8881/rest/searchUser";
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(url)
                .queryParam("userName",userName);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uriComponentsBuilder.toUriString(), User.class);
    }

}
