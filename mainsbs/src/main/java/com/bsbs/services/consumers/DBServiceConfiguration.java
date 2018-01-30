package com.bsbs.services.consumers;

/**
 * DBServiceConfiguration.class is enum which contain configuration of external service.
 * This enum has part of rest url to DB service.
 *
 * @author Volodymyr Severenchuk
 * Created on 1/30/2018
 */
public enum DBServiceConfiguration {
    SEARCH_USER("/rest/searchUser");

    private final String servicePath;

    DBServiceConfiguration(String servicePath) {
        this.servicePath = servicePath;
    }

    /**
     * generateServicePath method generate full URL by serviceURL and servicePath.
     * servicePath is enum data.
     *
     * @param serviceURL - is URL to DBService.
     * @return String value of connection URL to service.
     */
    public String generateServicePath(String serviceURL) {
        return serviceURL + servicePath;
    }

}
