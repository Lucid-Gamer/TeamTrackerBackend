package com.apptrove.TeamTracker.commons;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class VersionPrinter implements ApplicationRunner {

    @Value("${app.version}")
    private String appVersion;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // System.out.println("Application Version: " + appVersion);
    }

}
