package com.ytrsoft.aspect;

import com.ytrsoft.response.ResponseEntity;
import com.ytrsoft.response.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class RestAspect {

    @Around("execution(public com.ytrsoft.response.ResponseEntity *(..)))")
    public Object handleAspectMethod(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();
        try {
            Object ret = pjp.proceed();
            long elapsedTime = System.currentTimeMillis() - startTime;
            log.info("[{}]use time: {}", pjp.getSignature(), elapsedTime);
            return ret;
        } catch (Throwable e) {
            return ResponseEntity.failed(ResponseStatus.FAILED.code(), e.getMessage());
        }
    }

}
