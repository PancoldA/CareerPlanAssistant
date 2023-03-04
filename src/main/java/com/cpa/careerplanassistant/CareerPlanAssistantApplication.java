package com.cpa.careerplanassistant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@RestController
public class CareerPlanAssistantApplication {

    public static void main(String[] args) {
        SpringApplication.run(CareerPlanAssistantApplication.class, args);
    }
}
