package practise;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class CustomListener implements ITestListener {

	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName()+" "+"onTestFailure");
	}
	public void onTestStart(ITestResult result) {

	}
	public void onTestSuccess(ITestResult result) {

	}
	public void onStart(ITestContext context) {
		System.out.println("onStart > Test Tag Name: "+context.getName());
		ITestNGMethod methods[]=context.getAllTestMethods();
		System.out.println("These mthds will be executed befor test tag");
		for(ITestNGMethod met:methods) {
			System.out.println(met.getMethodName());
		}
	}

}
