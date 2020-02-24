package com.jp.submo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.TimeZone;


@SpringBootApplication
@EntityScan
public class SubscriptionModuleApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
		System.setProperty("server.servlet.context-path", "/jp_submo");
        SpringApplication.run(SubscriptionModuleApplication.class, args);
    }

}
