package api.utilities;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentUtilityManager implements ITestListener {

	public ExtentSparkReporter sparkExtentReport;
	public ExtentReports extentReport;
	public ExtentTest extentTest;
	String reportName;

	public void onStart(ITestContext context) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(0));
		reportName = "TestReport" + timeStamp + ".html";
		sparkExtentReport = new ExtentSparkReporter("./testReport/"+reportName);
		sparkExtentReport.config().setDocumentTitle(reportName);
		sparkExtentReport.config().setReportName("ReqRes project report");

		extentReport = new ExtentReports();
		extentReport.attachReporter(sparkExtentReport);
		extentReport.setSystemInfo("operating system", System.getProperty("os.name"));
		extentReport.setSystemInfo("User Name", System.getProperty("user.name"));
		extentReport.setSystemInfo("Appliction", "Reqres");

	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		extentTest = extentReport.createTest(result.getName());
		extentTest.log(Status.PASS, "Tests passed");
	}

	public void onTestFailure(ITestResult result) {
		extentTest = extentReport.createTest(result.getName());
		extentTest.log(Status.FAIL, "Test failed");

	}

	public void onTestSkipped(ITestResult result) {
		extentTest = extentReport.createTest(result.getName());
		extentTest.log(Status.SKIP, "Test Skipped");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		extentReport.flush();

	}

}
