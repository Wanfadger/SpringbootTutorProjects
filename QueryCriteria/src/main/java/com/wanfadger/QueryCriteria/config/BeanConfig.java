package com.wanfadger.QueryCriteria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.datafaker.Faker;

@Configuration
public class BeanConfig {
 
    @Bean
    public Faker faker(){
        return new Faker();
    }

}
