package com.gejodigital.necesitocr.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = {"com.gejodigital.necesitocr"})
@EnableAutoConfiguration
@EnableTransactionManagement

public class MainApplication{
	
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
    
}
