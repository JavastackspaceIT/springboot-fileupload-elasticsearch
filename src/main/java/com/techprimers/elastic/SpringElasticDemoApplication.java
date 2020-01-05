package com.techprimers.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class SpringElasticDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringElasticDemoApplication.class, args);
	
	}
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	   final CorsConfiguration config = new CorsConfiguration();
	   config.setAllowCredentials(true);
	   config.addAllowedOrigin("*");
	   config.addAllowedHeader("*");
	   config.addAllowedMethod("OPTIONS");
	   config.addAllowedMethod("PUT");
	   config.addAllowedMethod("POST");
	   config.addAllowedMethod("GET");
	   config.addAllowedMethod("DELETE");
	   source.registerCorsConfiguration("/**", config);
	   return new CorsFilter(source);
	}
}
