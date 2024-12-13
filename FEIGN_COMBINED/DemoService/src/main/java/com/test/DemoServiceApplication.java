package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoServiceApplication { //8084 PORT

	public static void main(String[] args) {
		System.out.println("Number of active threads: " + Thread.activeCount());
		System.out.println("Number of active threads: " + Thread.activeCount());

		int maxThreads = Runtime.getRuntime().availableProcessors();
		System.out.println("Maximum number of available threads: " + maxThreads);

		SpringApplication.run(DemoServiceApplication.class, args);
	}

}
