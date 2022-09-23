package com.store.ram.util;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import com.store.ram.exception.RamStoreException;

@Component
@Aspect
public class LoggingAspect {
	
	@Autowired
	private Environment environment;
	
	private Logger logger=LoggerFactory.getLogger(LoggingAspect.class);
	
	//log all the exception related to service layer into a log file
	
	@AfterThrowing(pointcut = "execution(* com.store.ram.service.*Impl.*(..))", 
			throwing = "eventRegistrationException")
	public void loggingServiceLayerExceptions(RamStoreException eventRegistrationException) {
		
		logger.error("DETAILS_NOT_FOUND");
		String message= environment.getProperty( eventRegistrationException.getMessage());
		System.out.println(message);
	}
}





