package com.mhm.Spring.Aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.mhm.Spring.Aop.service.JobService.getJob(..))&& args(postId)")
    public Object validateandUpdate(ProceedingJoinPoint jp, int postId) throws Throwable {

        if(postId<0){
            postId=-postId;
            LOGGER.info("PostId is updated to :"+postId);
        }
        Object obj=jp.proceed(new Object[]{postId});
        return obj;
    }
}
