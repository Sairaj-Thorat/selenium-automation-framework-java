package com.listeners;

import com.utils.DataProviderUtils;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class AnnotationTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass,
                          Constructor testConstructor, Method testMethod) {

        annotation.setRetryAnalyzer(RetryFailedTests.class);
        annotation.setDataProviderClass(DataProviderUtils.class);
        annotation.setDataProvider("getData");
    }
}
