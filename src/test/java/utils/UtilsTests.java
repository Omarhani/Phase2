package utils;

import base.BaseTests;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class UtilsTests extends BaseTests{

    WebDriver driver;
    ExtentTest test;
    public UtilsTests(WebDriver driver){
        this.driver = driver;
    }
    private void setScreenShotOnReport(ITestResult result){
        test.addScreenCaptureFromPath(result.getName()+".png");
    }
    private void setVideoOnReport(ITestResult result){
        test.info("<a href='"+ result.getName() +".avi"+"'><span class='label info'>Download Video</span></a>");

    }
    public void tackScreenShot(String name) throws IOException {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,new File("report/"+name+".png"));
    }


    public void statusOfTestCases(ITestResult result,Method method){
        test = extent.createTest(method.getName());
        if (result.getStatus()==ITestResult.SUCCESS){
            test.pass("Test Pass");
        } else if (result.getStatus() ==ITestResult.FAILURE){
            test.fail("Test Fail");
        }else {
            test.skip("Test Skipped");
        }
        test.addScreenCaptureFromPath(method.getName()+".png");
        test.log(Status.INFO," <a href='"+method.getName()+".avi'>Download video</a>");

    }

    public void createReport(){
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("report/report.html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("MyReport");
        extent.attachReporter(spark);

    }
    public void flushReport(){
        extent.flush();
    }
    public void takeScreenShot(Method method) throws IOException {
        UtilsTests utilsTests = new UtilsTests(driver);
        utilsTests.tackScreenShot(method.getName());
    }


}
