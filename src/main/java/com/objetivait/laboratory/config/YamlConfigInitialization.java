package com.objetivait.laboratory.config;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class YamlConfigInitialization {
    @Inject
    private Environment springEnvironment;
    private static final Logger LOGGER = LoggerFactory.getLogger(YamlConfigInitialization.class);

    @Bean
    public ApplicationConfiguration getApplicationConfig() throws IOException {
        String environmentName = springEnvironment.getActiveProfiles().length > 0 ? springEnvironment.getActiveProfiles()[0] : "application";
        LOGGER.info("Loading environment: " + environmentName);

        try (InputStream inputStream = YamlConfigInitialization.class.getResourceAsStream("/config/" + environmentName + ".yaml")) {
            if (inputStream == null) {
                throw new IOException("Profile not found: " + environmentName);
            }

            return new ApplicationConfigurationParser().parse(environmentName, inputStream);
        }
    }
}
