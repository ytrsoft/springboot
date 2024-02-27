package com.ytrsoft.aspect;

import com.ytrsoft.response.ResponseEntity;
import com.ytrsoft.response.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class RestAspect {

    @Pointcut("execution(public com.ytrsoft.response.ResponseEntity *(..))")
    public void responseEntityMethods() {}

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *) || " +
            "within(@org.springframework.data.rest.webmvc.RepositoryRestController *) || " +
            "within(@org.springframework.stereotype.Controller *)")
    public void controllerMethods() {}

    @Around("responseEntityMethods() || controllerMethods()")
    public Object handleAspectMethod(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();
        log.info("Starting method: {} with arguments: {}", pjp.getSignature(), Arrays.toString(pjp.getArgs()));
        try {
            Object ret = pjp.proceed();
            long elapsedTime = System.currentTimeMillis() - startTime;
            log.info("Method [{}] executed successfully in [{}] ms with result: {}", pjp.getSignature(), elapsedTime, ret);
            return ret;
        } catch (Throwable e) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            log.error("Exception in method [{}] after [{}] ms. Exception: {}", pjp.getSignature(), elapsedTime, e.getMessage(), e);
            return ResponseEntity.failed(ResponseStatus.FAILED.code(), e.getMessage());
        }
    }

}
