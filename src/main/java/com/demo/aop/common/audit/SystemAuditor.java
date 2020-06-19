package com.demo.aop.common.audit;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class SystemAuditor implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("SYSTEM");
    }
}
