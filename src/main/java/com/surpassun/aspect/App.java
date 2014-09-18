package com.surpassun.aspect;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.EnableLoadTimeWeaving.AspectJWeaving;

import com.surpassun.aspect.business.Shout;

@EnableAutoConfiguration
@EnableAspectJAutoProxy
@ComponentScan
@Configuration
@EnableLoadTimeWeaving(aspectjWeaving = AspectJWeaving.ENABLED)
public class App {
	
	Logger logger = LoggerFactory.getLogger(App.class);

	public App() {
		logger.info("Constructor called");
	}
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(App.class);
		app.run(args);
		
		String newString = StringUtils.replace("my name is xun", "xun", "ren");
		
		Shout shout = new Shout();
		shout.miao(newString);
	}

}
