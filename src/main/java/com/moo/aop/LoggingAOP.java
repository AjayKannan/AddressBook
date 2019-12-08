package com.moo.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAOP {

	Logger logger = LogManager.getLogger(LoggingAOP.class);

	@Before("execution(* com.moo.*.*.*(..))")
	public void before(JoinPoint joinPoint) {

		String className = joinPoint.getSignature().getDeclaringTypeName();
		String methodName = joinPoint.getSignature().getName();
		logger.debug("Entering Method " + className + "." + methodName + " with arguments  ");
		Object[] signatureArgs = joinPoint.getArgs();
		for (Object signatureArg : signatureArgs) {
			logger.debug("Arg: " + signatureArg);
		}
	}

	@AfterReturning(pointcut = "execution(* com.moo.*.*.*(..))", returning = "result")
	public void after(JoinPoint joinPoint, Object result) {

		String className = joinPoint.getSignature().getDeclaringTypeName();
		String methodName = joinPoint.getSignature().getName();

		logger.debug("Exiting Method " + className + "." + methodName + " with arguments  ");

		if (result != null) {
			logger.debug(" return value : "+ result.toString());
		} else {
			logger.debug(" return value is null ");
		}
	}

}
