package com.irostub.webhook.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    private Discord discord;
    @Data
    public static class Discord {
        String url;
    }
}
