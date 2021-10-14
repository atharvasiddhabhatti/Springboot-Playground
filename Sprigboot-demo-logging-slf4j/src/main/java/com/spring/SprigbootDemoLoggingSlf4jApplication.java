package com.spring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class SprigbootDemoLoggingSlf4jApplication {
	private static final Logger log = LoggerFactory.getLogger(SprigbootDemoLoggingSlf4jApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SprigbootDemoLoggingSlf4jApplication.class, args);
		log.error("Error Message");
		log.warn("Warning Message");
		log.info("Info Message");
		log.debug("Debug Message");
		log.trace("Trace Message");
	}
	

}
