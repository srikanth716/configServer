package com.example.configclient;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class PrintConfigProperties {

    @Autowired
    private Environment env;

    @PostConstruct
    public void printProperties() {
        // Print active profiles
        Arrays.stream(env.getActiveProfiles()).forEach(profile -> {
            System.out.println("Active profile: " + profile);
        });

        // Print the value of mosip.kernel.syncdata.url
        System.out.println("language: " + env.getProperty("mosip.template-language"));
    }
}
