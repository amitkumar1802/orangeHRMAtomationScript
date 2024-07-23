package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import utilities.ExtentReporting;

public class Listeners extends Base implements ITestListener {

	ExtentReports extentReports = ExtentReporting.getReports();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extentThreadLocal = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		String testname = result.getName();
		extentTest = extentReports.createTest(testname);
		extentThreadLocal.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentThreadLocal.get().log(Status.PASS, "Test case passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String testname = result.getName();

		// extentTest.fail(result.getThrowable());
		extentThreadLocal.get().fail(result.getThrowable());
		try {
			Object testClass = result.getInstance();
			WebDriver driver = ((Base) testClass).getDriver();
			String screenshotFilePath = takeScreenShot(driver, testname);
			extentThreadLocal.get().addScreenCaptureFromPath(screenshotFilePath, testname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		if (extentReports != null) {
			extentReports.flush();
		}
	}

}
