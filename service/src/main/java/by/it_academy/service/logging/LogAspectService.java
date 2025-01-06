package by.it_academy.service.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAspectService {

    @Pointcut("@within(org.springframework.stereotype.Service)")
    public void isServiceLayer() {
    }

    @Pointcut("isServiceLayer() && execution(public * *(..))")
    public void isLoggingServiceMethod() {
    }


    @Before("isLoggingServiceMethod()")
    public void addLoggingBefore(JoinPoint joinPoint) {

        log.info("BEFORE - invoke method for class: '{}', name of method: '{}'",
                getDeclaringTypeName(joinPoint), getMethodName(joinPoint));
    }

    @After("isLoggingServiceMethod()")
    public void logAfterMethodCall(JoinPoint joinPoint) {

        log.info("AFTER - method completed for class: '{}', name of method: '{}'",
                getDeclaringTypeName(joinPoint), getMethodName(joinPoint));
    }

    @AfterReturning(value = "isLoggingServiceMethod() && !execution(* findAll*(..))",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {

        if (log.isDebugEnabled()) {
            log.debug("AFTER RETURNING - method completed for class: '{}', name of method: '{}', returned value: {}",
                    getDeclaringTypeName(joinPoint), getMethodName(joinPoint), result);
        }
    }

    @AfterThrowing(pointcut = "isLoggingServiceMethod()", throwing = "ex")
    public void logAfterThrowingMethodCall(JoinPoint joinPoint, Throwable ex) {

        log.error("AFTER THROWING - exception in class: '{}', method: '{}', exception: '{}'",
                getDeclaringTypeName(joinPoint), getMethodName(joinPoint), ex.getMessage());
    }


    private String getDeclaringTypeName(JoinPoint joinPoint) {
        return joinPoint.getSignature().getDeclaringTypeName();
    }

    private String getMethodName(JoinPoint joinPoint) {
        return joinPoint.getSignature().getName();
    }

}
