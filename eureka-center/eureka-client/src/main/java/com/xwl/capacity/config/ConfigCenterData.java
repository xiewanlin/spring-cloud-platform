package com.xwl.capacity.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class ConfigCenterData {

    @Value("${user.name}")
    private String name;

    public String getName() {
        return name;
    }
}
