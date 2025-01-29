package com.mhm.Spring.Aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect     //aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //@advice("point-cut")
                        //return typa class-name.mathos-name(args)
    @Before("execution(* com.mhm.Spring.Aop.service.JobService.getJob(..)) || execution(* com.mhm.Spring.Aop.service.JobService.getAllJobs(..))")
    public void logMethodCalled(JoinPoint jp){
        LOGGER.info("Method called " +jp.getSignature().getName());
    }

    @After("execution(* com.mhm.Spring.Aop.service.JobService.getJob(..)) || execution(* com.mhm.Spring.Aop.service.JobService.getAllJobs(..))")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method " +jp.getSignature().getName()+"Executed");
    }

    @AfterReturning("execution(* com.mhm.Spring.Aop.service.JobService.getJob(..)) || execution(* com.mhm.Spring.Aop.service.JobService.getAllJobs(..))")
    public void logMethodExecutedSuccess(JoinPoint jp){
        LOGGER.info("Method " +jp.getSignature().getName()+"Executed Successfully");
    }

    @AfterThrowing("execution(* com.mhm.Spring.Aop.service.JobService.getJob(..)) || execution(* com.mhm.Spring.Aop.service.JobService.getAllJobs(..))")
    public void logMethodCrash(JoinPoint jp){
        LOGGER.info("Method " +jp.getSignature().getName()+"Throws Exception");
    }
}
