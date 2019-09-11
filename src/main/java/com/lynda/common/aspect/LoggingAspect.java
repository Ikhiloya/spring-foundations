package com.lynda.common.aspect;

import com.lynda.common.data.entity.ActivityLog;
import com.lynda.common.service.ActivityLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Autowired
    private ActivityLogService activityLogService;


    @Pointcut("@annotation(Loggable)")
    public void executeLogging() {

    }

//    @AfterReturning(pointcut = "executeLogging()", returning = "returnValue")
//    public void logMethodCall(JoinPoint joinPoint, Object returnValue){
//        StringBuilder message = new StringBuilder("Method: ");
//        message.append(joinPoint.getSignature().getName());
//        Object[] args = joinPoint.getArgs();
//        if(null!=args && args.length>0){
//            message.append(" args=[");
//            Arrays.asList(args).forEach(arg->{
//                message.append("arg=").append(arg).append("|");
//            });
//        }
//        if(returnValue instanceof Collection){
//            message.append(" | returning ").append(((Collection)returnValue).size()).append(" instance(s)");
//        }else{
//            message.append(" | returning ").append(returnValue.toString());
//        }
//        LOGGER.info(message.toString());
//    }

    @Around("executeLogging()")
    public Object logMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object returnValue = joinPoint.proceed();
        long totalTime = System.currentTimeMillis() - startTime;
        StringBuilder message = new StringBuilder("Method: ");
        message.append(joinPoint.getSignature().getName());
        message.append(" totalTime: ").append(totalTime).append("ms ");
        Object[] args = joinPoint.getArgs();
        if (null != args && args.length > 0) {
            message.append(" args=[");
            Arrays.asList(args).forEach(arg -> {
                message.append("arg=").append(arg).append("|");
            });
        }
        if (returnValue instanceof Collection) {
            message.append(" | returning ").append(((Collection) returnValue).size()).append(" instance(s)");
        } else {
            message.append(" | returning ").append(returnValue.toString());
        }
        LOGGER.info(message.toString());

        activityLogService.saveActivityLog("Loya", message.toString());
        return returnValue;
    }
}
