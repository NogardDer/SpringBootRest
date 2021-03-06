package com.bsbs.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The main entry point to DB Application
 *
 * @author Volodymyr Severenchuk
 * Created on 1/30/2018
 */
@SpringBootApplication
@ComponentScan({"com.bsbs.app","com.bsbs.dbservices"})
public class Application {
	private final static Logger LOG = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		LOG.info("Start DB SpringBoot services application");
		SpringApplication.run(Application.class, args);
	}
}
