package com.ani.project.aniserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AniServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(AniServiceRegistryApplication.class, args);
	}

}
