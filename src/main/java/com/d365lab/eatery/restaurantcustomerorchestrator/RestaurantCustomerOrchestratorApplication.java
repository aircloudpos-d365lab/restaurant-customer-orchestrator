package com.d365lab.eatery.restaurantcustomerorchestrator;

import com.d365lab.eatery.restaurantcustomerorchestrator.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaAuditing
@EnableConfigurationProperties({
		FileStorageProperties.class
})
@ComponentScan("com.d365lab.eatery.restaurantcustomerorchestrator")
@EntityScan("com.d365lab.eatery.restaurantcustomerorchestrator.dao")
@EnableJpaRepositories("com.d365lab.eatery.restaurantcustomerorchestrator.repositories")
public class RestaurantCustomerOrchestratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantCustomerOrchestratorApplication.class, args);
	}

}
