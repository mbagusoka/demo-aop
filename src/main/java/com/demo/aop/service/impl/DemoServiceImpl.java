package com.demo.aop.service.impl;

import com.demo.aop.common.annotation.ApiRequestLogger;
import com.demo.aop.service.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Override
    @ApiRequestLogger(url = "My dream..")
    public void doSuccess(String payload) {
        // do nothing
    }

    @Override
    @ApiRequestLogger(url = "My ex..")
    public void doFailed(String payload) {
        throw new RuntimeException("is such a b*tch");
    }
}
