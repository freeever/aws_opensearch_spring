package com.aws.opensearch.spring;

import com.aws.opensearch.spring.utility.DateUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class AwsOpensearchSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwsOpensearchSpringApplication.class, args);
    }

    // Regardless the app server and DB server time zone settings, the application
    // always use UTC as the default time zone
    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone(DateUtils.DEFAULT_ZONE_ID));
    }

}
