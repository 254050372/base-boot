package com.boot.portal;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class PortalApplication extends SpringBootServletInitializer {
	public final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		logger.info("SPRING VERSION: {}" , SpringVersion.getVersion());
		logger.info("SPRING BOOT VERSION: {}" , SpringBootVersion.getVersion());
//		LoggerContext lc = (LoggerContext)LoggerFactory.getILoggerFactory();
//		StatusPrinter.print(lc);
		return application.sources(PortalApplication.class);
	}


	public static void main(String[] args) {
		SpringApplication.run(PortalApplication.class, args);
	}
}
