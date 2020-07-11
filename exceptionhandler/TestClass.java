package com.my.exceptionhandler;

import java.util.ArrayList;

public class TestClass implements Caller{

	@Override
	@ExceptionCatchList(exceptioncatchers={@ExceptionCatch(targetExceptionCatchHandler=DaoInsertClass.class,
	targetExceptions=Exception.class)})
	public void callMethod() throws Exception {
		try {
		ArrayList<Integer> a = null;
		a.size();		
		String aa= "aakash";
		/*int a = 1/0;*/
		}
		catch(Exception e) {
			throw new Exception(e);
		}
	}
	 public static void main(String[] args) throws Exception {
		    TestClass obj=new TestClass();
		    try {
				Evaluator.methodEvaluator(obj);
			} catch (Exception e) {

			}
		  }

}
