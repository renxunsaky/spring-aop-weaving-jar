package com.surpassun.aspect.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class BcoLogging {

	Logger logger = LoggerFactory.getLogger(BcoLogging.class);
	
	public BcoLogging() {
		logger.info("constructor of logging called");
	}
	
	@Pointcut("execution(* com.surpassun.aspect.business.Shout.miao(..)) && args(name)")
	public void loggingPoincut(String name) {}
	
	@Pointcut("execution(* org.apache.commons.lang.StringUtils.replace(..))")
	public void jarIntercepter() {}
	
	@Before("loggingPoincut(name)")
	public void logCall(String name) {
		logger.info("Name passed as parameter is : " + name);
	}
	
	@Before("jarIntercepter()")
	public void logStringReplace(JoinPoint joinPoint) {
		if (joinPoint.getArgs() != null && joinPoint.getArgs().length == 3) {
			String originalString = (String)joinPoint.getArgs()[0];
			String oldString = (String)joinPoint.getArgs()[1];
			String newString = (String)joinPoint.getArgs()[2];
			
			logger.info("originalString is {}", originalString);
			logger.info("oldString is {}", oldString);
			logger.info("newString is {}", newString);
		}
	}
	
}
