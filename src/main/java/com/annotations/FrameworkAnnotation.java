package com.annotations;

import com.enums.CategoryType;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(METHOD)

public @interface FrameworkAnnotation {

    String[] author() default {"QA"};
    CategoryType[] category() default {CategoryType.REGRESSION};

}
