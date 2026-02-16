package com.telecomw.telecom_usage_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class TelecomUsageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelecomUsageServiceApplication.class, args);
	}

}
