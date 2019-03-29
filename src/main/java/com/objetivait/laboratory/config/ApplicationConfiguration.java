package com.objetivait.laboratory.config;

import com.google.common.collect.Maps;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Map;

public class ApplicationConfiguration {
    
    private String hibernateDialect;

    private String driverClass;

    @NotNull
    private String user = "";

    private String password = "";

    @NotNull
    private String url = "";

    @NotNull
    private Map<String, String> properties = Maps.newHashMap();

    @NotNull
    private Integer maxWaitForConnection = 1;

    @NotNull
    private String validationQuery = "/* Health Check */ SELECT 1";

    @Max(1024)
    @Min(1)
    private int minSize = 1;

    @Max(1024)
    @Min(1)
    private int maxSize = 8;

    private boolean checkConnectionWhileIdle;

    @NotNull
    private Integer checkConnectionHealthWhenIdleFor = 10;

    @NotNull
    private Integer closeConnectionIfIdleFor = 60;

    public String getDriverClass() {
        return driverClass;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public Integer getMaxWaitForConnection() {
        return maxWaitForConnection;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public int getMinSize() {
        return minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public boolean isCheckConnectionWhileIdle() {
        return checkConnectionWhileIdle;
    }

    public Integer getCheckConnectionHealthWhenIdleFor() {
        return checkConnectionHealthWhenIdleFor;
    }

    public Integer getCloseConnectionIfIdleFor() {
        return closeConnectionIfIdleFor;
    }

    
    public String getHibernateDialect() {
        return this.hibernateDialect;
    }

}
