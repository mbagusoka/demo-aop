package com.demo.aop.common.aspect;

import com.demo.aop.common.annotation.ApiRequestLogger;
import com.demo.aop.model.entity.ApiRequestLog;
import com.demo.aop.model.enums.ApiRequestLogStatus;
import com.demo.aop.repository.ApiRequestLogRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@RequiredArgsConstructor
public class ApiRequestLogAspect {

    private final ApiRequestLogRepository requestLogRepository;

    /**
     * If we want to use JoinPoint, it must be on first argument.
     * If not the advice will error and the application cannot be started.
     */
    @AfterReturning(value = "@annotation(apiRequestLogger)")
    public void logSuccess(JoinPoint joinPoint, ApiRequestLogger apiRequestLogger) {
        String url = apiRequestLogger.url();
        String payload = (String) joinPoint.getArgs()[0];
        ApiRequestLog requestLog = new ApiRequestLog(url, payload, ApiRequestLogStatus.SUCCESS, "");
        requestLogRepository.save(requestLog);
    }

    @AfterThrowing(
            value = "@annotation(apiRequestLogger) && args(payload)",
            throwing = "e",
            argNames = "apiRequestLogger,payload,e"
    )
    public void logError(ApiRequestLogger apiRequestLogger, String payload, Throwable e) {
        String url = apiRequestLogger.url();
        ApiRequestLog requestLog = new ApiRequestLog(url, payload, ApiRequestLogStatus.FAILED, e.getMessage());
        requestLogRepository.save(requestLog);
    }
}
