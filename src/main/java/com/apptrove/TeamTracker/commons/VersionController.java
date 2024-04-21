package com.apptrove.TeamTracker.commons;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class VersionController implements ApplicationRunner {

    @Value("${app.version}")
    private String appVersion;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Application Version : " + this.appVersion);
    }

}
