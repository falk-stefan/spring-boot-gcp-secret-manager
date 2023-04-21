package com.example.gcpsm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.lang.NonNull;

@SpringBootApplication
public class Application implements ApplicationListener<ApplicationContextEvent> {

    private final static Logger LOGGER = LogManager.getLogger(Application.class);

    @Value("${some-secret}")
    private String someSecret;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void onApplicationEvent(@NonNull ApplicationContextEvent event) {
        LOGGER.info("###############################################################");
        LOGGER.info(String.format("# Secret: \"%s\"", this.someSecret));
        LOGGER.info("###############################################################");
    }
}
