package com.bsbs.services.utils;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class RestBuilder<T> {
    private final Class<T> responseType;
    private final UriComponentsBuilder uriComponentsBuilder;

    private RestBuilder(Class<T> responseType, String url) {
        this.responseType = responseType;
        uriComponentsBuilder = UriComponentsBuilder.fromUriString(url);
    }

    public static <T> RestBuilder<T> createBuilder(Class<T> responseType, String url) {
        return new RestBuilder<>(responseType, url);
    }

    public RestBuilder<T> with(String key, Object value) {
        uriComponentsBuilder.queryParam(key, value);
        return this;
    }

    public T call() {
        return new RestTemplate().getForObject(uriComponentsBuilder.toUriString(), responseType);
    }

}
