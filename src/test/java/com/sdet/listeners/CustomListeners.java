package com.sdet.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.sdet.utilities.Screenshot;

public class CustomListeners implements ITestListener {

public void onTestStart(ITestContext arg0) {
		
	}

	public void onTestSuccess(ITestResult arg0) {
		
	}

	public void onTestFailure(ITestResult arg0) {
		
		try {
			Screenshot.takeScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult arg0) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}
}
