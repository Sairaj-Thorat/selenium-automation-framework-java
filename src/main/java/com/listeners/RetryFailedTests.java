package com.listeners;

import com.enums.ConfigProperties;
import com.utils.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public final class RetryFailedTests implements IRetryAnalyzer {

    private int count = 0;
    private final int maxRetries = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        boolean value = false ;
        if (PropertyUtils.getValue(ConfigProperties.RETRY_FAILED_TESTS).equalsIgnoreCase("yes")){
            value = count < maxRetries ;
            count++;
        }
        return value;
    }
}
