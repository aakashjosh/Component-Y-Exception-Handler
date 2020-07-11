package com.my.exceptionhandler;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
public @interface ExceptionCatchList {
	public ExceptionCatch[] exceptioncatchers();
}
