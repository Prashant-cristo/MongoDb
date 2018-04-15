package com.test.spring.MongoDb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author prkumar
 */

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@EnablePrometheusEndpoint
@EnableSpringBootMetricsCollector
public class MongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbApplication.class, args);
	}
//Swagger 2 is enabled through the @EnableSwagger2 annotation.
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()    // select() method returns an instance of ApiSelectorBuilder,
				//which provides a way to control the endpoints exposed by Swagger.
				.apis(RequestHandlerSelectors.basePackage("com.test.spring.MongoDb.Controller"))//Predicates for selection of RequestHandlers can be configured
				//with the help of RequestHandlerSelectors and PathSelectors. 
				//Using any() for both will make documentation for your entire API available through Swagger.
				.paths(PathSelectors.any()).build();
	}
}
