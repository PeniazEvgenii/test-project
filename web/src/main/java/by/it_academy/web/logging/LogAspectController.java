package by.it_academy.web.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAspectController {

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void isControllerLayer() {
    }

    @Pointcut("isControllerLayer() && execution(public * *(..))")
    public void isLoggingControllerMethod() {
    }


    @Before("isLoggingControllerMethod()")
    public void addLoggingBefore(JoinPoint joinPoint) {

        log.info("BEFORE - invoke method for class: '{}', name of method: '{}'",
                getDeclaringTypeName(joinPoint), getMethodName(joinPoint));
    }

    @After("isLoggingControllerMethod()")
    public void logAfterMethodCall(JoinPoint joinPoint) {

        if (log.isDebugEnabled()) {
            log.debug("AFTER - method completed for class: '{}', name of method: '{}'",
                    getDeclaringTypeName(joinPoint), getMethodName(joinPoint));
        }
    }

    @AfterReturning(value = "isLoggingControllerMethod() && !execution(* findAll*(..))",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {

        if (log.isDebugEnabled()) {
            log.debug("AFTER RETURNING - method completed for class: '{}', name of method: '{}', returned value: {}",
                    getDeclaringTypeName(joinPoint), getMethodName(joinPoint), result);
        }
    }


    private String getDeclaringTypeName(JoinPoint joinPoint) {
        return joinPoint.getSignature().getDeclaringTypeName();
    }

    private String getMethodName(JoinPoint joinPoint) {
        return joinPoint.getSignature().getName();
    }

}
