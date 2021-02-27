package com.ani.project.anicloudgateway;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;

import java.time.Duration;


@SpringBootApplication
public class AniCloudGatewayApplication {


	@Bean
	public Customizer<ReactiveResilience4JCircuitBreakerFactory> getCircuitBreakerCustomizer() {
		return factory -> factory.configureDefault(id ->
				new Resilience4JConfigBuilder(id)
						.circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
						.timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(5)).build())
						.build()
		);
	}

	public static void main(String[] args) {
		SpringApplication.run(AniCloudGatewayApplication.class, args);
	}

}
