package com.taran.navitex.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RepositoryLogger {
    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryLogger.class);
    private static final String MESSAGE_AT_THE_METHOD_BEGINNING = "The repository method starts to execute.";
    private static final String MESSAGE_AT_THE_METHOD_END = "The repository method is successfully completed the executing.";

    @Pointcut("execution(* com.taran.navitex.repository.*(..))")
    public void repositoryMethods() {
    }

    @Before("repositoryMethods()")
    public void logAtTheBeginningOfMethod() {
        LOGGER.info(MESSAGE_AT_THE_METHOD_BEGINNING);
    }

    @AfterReturning("repositoryMethods()")
    public void logAtTheEndOfMethod() {
        LOGGER.info(MESSAGE_AT_THE_METHOD_END);
    }
}
