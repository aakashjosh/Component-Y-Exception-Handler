package com.my.exceptionhandler;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(ANNOTATION_TYPE)
public @interface ExceptionCatch {
	public Class<? extends ExceptionHandler> targetExceptionCatchHandler();
	public Class<? extends Exception> targetExceptions() default Exception.class;
	  
}
