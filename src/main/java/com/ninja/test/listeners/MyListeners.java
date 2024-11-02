package com.ninja.test.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Execution of Project Tests Started");
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getName(); 
		System.out.println(testName + " Start Executing ");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName(); 
		System.out.println(testName + " Got Succesfully Executed ");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName(); 
		System.out.println(testName + " Got Failed ");
		System.out.println(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName(); 
		System.out.println(testName + "Got Skipped ");
		System.out.println(result.getThrowable());
	
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(" Finished Executing Project Tests ");
	}

}
