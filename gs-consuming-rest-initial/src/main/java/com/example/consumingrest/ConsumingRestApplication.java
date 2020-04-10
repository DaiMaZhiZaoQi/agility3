package com.example.consumingrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
//@RestController
public class ConsumingRestApplication {
	private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return ar->{Object object=restTemplate.getForObject("", Object.class);};
//		return args -> {
//			Greeting greet = restTemplate.getForObject(
//					"http://localhost:8080/greeting/%E5%8F%91%E9%A3%9E%E6%B4%92%E5%8F%91%E7%9A%84", Greeting.class);
//			log.info(greet.toString());
//		};
	}
	
//	@GetMapping("/hello")
//	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
//	return String.format("Hello %s!", name);
//	}
}
