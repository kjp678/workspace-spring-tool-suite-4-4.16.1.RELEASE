package com.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients    

public class FeignClientDemoApplication { //server.port = 8086

	public static void main(String[] args) {
		
		SpringApplication.run(FeignClientDemoApplication.class, args);
	}

}
