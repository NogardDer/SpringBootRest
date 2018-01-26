package com.bsbs.services.consumers;

public enum DBServiceConfiguration {
    SEARCH_USER("/rest/searchUser");

    private final String servicePath;

    DBServiceConfiguration(String servicePath) {
        this.servicePath = servicePath;
    }

    public String generateServicePath(String serviceURL) {
        return serviceURL + servicePath;
    }

}
