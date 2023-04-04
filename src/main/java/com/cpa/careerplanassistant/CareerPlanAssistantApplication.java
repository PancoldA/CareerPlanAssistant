package com.cpa.careerplanassistant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

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
