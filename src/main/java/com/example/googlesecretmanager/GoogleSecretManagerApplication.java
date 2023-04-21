package com.example.googlesecretmanager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class GoogleSecretManagerApplication implements ApplicationListener<ApplicationStartedEvent> {

    private final static Logger LOGGER = LogManager.getLogger(GoogleSecretManagerApplication.class);

    @Value("${some-secret}")
    private String someSecret;

    public static void main(String[] args) {
        SpringApplication.run(GoogleSecretManagerApplication.class, args);
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        LOGGER.info("###############################################################");
        LOGGER.info(String.format("# Secret value: %s", this.someSecret));
        LOGGER.info("###############################################################");
    }
}
