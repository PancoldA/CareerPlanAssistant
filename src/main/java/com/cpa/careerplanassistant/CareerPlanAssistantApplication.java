package com.cpa.careerplanassistant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@EnableJpaAuditing
//@ComponentScan("com.cpa.careerplanassistant.repositories")
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
//@RestController
@SpringBootApplication
@EnableJpaAuditing
public class CareerPlanAssistantApplication {

    public static void main(String[] args) {
        SpringApplication.run(CareerPlanAssistantApplication.class, args);
    }
}
