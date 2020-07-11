package com.my.exceptionhandler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Evaluator {
	 public static void methodEvaluator(Caller callerObj)
		      throws Exception {
		    Method method = callerObj.getClass().getMethod("callMethod");
		    Annotation annotations[] = method.getAnnotations();
		    ExceptionCatch[] catchlist = null;
		    for (Annotation annotation : annotations) {
		      if (annotation.annotationType().equals(ExceptionCatchList.class)) {
		        catchlist = ((ExceptionCatchList) annotation).exceptioncatchers();
		        
		      }
		   
		    }
		    try {
		      callerObj.callMethod();
		    } catch (Exception e) {		    	
		    	StringWriter errors = new StringWriter();
		    	e.printStackTrace(new PrintWriter(errors));
		    	StackTraceElement[] s=  e.getStackTrace();
		      Class<?> ec = e.getClass();
		      if (catchlist == null) {
		        return;
		      }
		      for (ExceptionCatch cx : catchlist) {
		        if (cx.targetExceptions().equals(ec)) {
		          ExceptionHandler h = cx.targetExceptionCatchHandler().newInstance();
		          h.handleException(errors.toString());
		          break;
		        }
		      }
		    }
		  }
}
