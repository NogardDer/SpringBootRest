package com.bsbs.services.utils;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * RestBuilder.class is generic class for using rest service by url and parameters.
 *
 * @param <T> is rest response type.
 */
public class RestBuilder<T> {
    private final Class<T> responseType;
    private final UriComponentsBuilder uriComponentsBuilder;

    private RestBuilder(Class<T> responseType, String url) {
        this.responseType = responseType;
        uriComponentsBuilder = UriComponentsBuilder.fromUriString(url);
    }

    /**
     * createBuilder method is creating new RestBuilder with URL and response type.
     *
     * @param responseType is response class.
     * @param url is rest URL String value.
     * @param <T> is type of response.
     * @return new RestBuilder.
     */
    public static <T> RestBuilder<T> createBuilder(Class<T> responseType, String url) {
        return new RestBuilder<>(responseType, url);
    }

    /**
     * with method add parameter to rest request.
     *
     * @param key is parameter name String value.
     * @param value is parameter value.
     * @return current RestBuilder with added parameter.
     */
    public RestBuilder<T> with(String key, Object value) {
        uriComponentsBuilder.queryParam(key, value);
        return this;
    }

    /**
     * call method is calling rest service.
     *
     * @return Result of response from rest call.
     */
    public T call() {
        return new RestTemplate().getForObject(uriComponentsBuilder.toUriString(), responseType);
    }

}
