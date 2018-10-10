package com.revature.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

/**
 * This is a Class where a Spring Aop advice executes before or after the methods 
 * in the services and controller is called/executed. 
 * @author Obosa Nosa-Igiebor | 1806-spark |Steven Kelsey
 */

@Aspect
@Configuration
public class BatchLogging {

private Logger logger = Logger.getLogger(this.getClass());
	
	// This executes after the methods in the service class
	@After("execution( * com.revature.services.*.*(..))")
	public void logExecutionTime(JoinPoint joinPoint) throws Throwable {
		logger.info("Used  services " + joinPoint);
		logger.error("Error!");
		logger.debug("Now Debugging...");
	}
	
	//This executed before the methods in the batch controller
		@Before("execution( * com.revature.controllers.BatchController.*(..))")
		public void logCurriculum(JoinPoint joinPoint) throws Throwable{
			logger.info("Batch endpoints hit" + joinPoint);
			logger.error("Error!");
			logger.debug("Now Debugging...");
	}
}
