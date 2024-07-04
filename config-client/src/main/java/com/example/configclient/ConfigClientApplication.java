package com.example.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

	@Value("${mosip.kernel.crypto.hash-algorithm-name:default_value}")
    private String syncdataUrl;

    @GetMapping("/config")
    public String getConfig() {
        System.out.println("syncdataUrl: " + syncdataUrl);
        return "syncdataUrl: " + syncdataUrl;
    }
}
