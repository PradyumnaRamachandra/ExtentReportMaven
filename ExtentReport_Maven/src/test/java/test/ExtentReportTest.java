package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utility.BaseTest;
import utility.UtilityMethods;

public class ExtentReportTest extends BaseTest {
	
	
	ExtentReports reports;
	ExtentTest test;
	
	@Test
	public void reportDemo() {
		ExtentSparkReporter reporter=new ExtentSparkReporter("./Reports/TestReport.html");
		reports=new ExtentReports();
		reports.attachReporter(reporter);
		test=reports.createTest("DWS Test");
		
		UtilityMethods obj=new UtilityMethods();
		test.log(Status.PASS, "Application launched successfully");
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(obj.captureScreenShot("Launch Application")).build());
		driver.findElement(By.linkText("Register")).click();
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(obj.captureScreenShot("RegisterLink"), "Register Link Clicked Successfully").build());
		reports.flush();
	}
	
}
