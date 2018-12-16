package com.manoj.training.springcachestatistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.manoj.training")
@EnableCaching
@EnableAutoConfiguration
public class SpringCacheStatisticsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCacheStatisticsApplication.class, args);
	}

}

