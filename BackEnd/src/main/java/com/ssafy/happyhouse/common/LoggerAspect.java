package com.ssafy.happyhouse.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
// aspect -> private method에 접근하지 못한다
public class LoggerAspect {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* com.ssafy.happyhouse..*.*(..))")
	public void beforeLog(JoinPoint joinPoint) {
	    logger.info("LoggerAspect : Before " + joinPoint.getTarget().getClass() + "." + joinPoint.getSignature().getName() + "()");
	    logger.debug("LoggerAspect : Before Debug " + joinPoint.getTarget().getClass() + "." + joinPoint.getSignature().getName() + "()");
	}

	@After("execution(* com.ssafy.happyhouse..*.*(..))")
	public void afterLog(JoinPoint joinPoint) {
	    logger.info("LoggerAspect : After " + joinPoint.getTarget().getClass() + "." + joinPoint.getSignature().getName() + "()");
	    logger.debug("LoggerAspect : After Debug " + joinPoint.getTarget().getClass() + "." + joinPoint.getSignature().getName() + "()");
	}
}
