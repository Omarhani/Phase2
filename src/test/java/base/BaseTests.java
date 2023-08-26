package base;

import com.aventstack.extentreports.ExtentReports;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.JsonDataReader;
import utils.ScreenRecorderUtil;
import utils.UtilsTests;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseTests {

    public WebDriver driver;
    public HomePage homePage;
    public static ExtentReports extent;
    protected UtilsTests utilsTests;

    private final String FILENAME ="testData.json";

    private void setUpBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void goHome(Method method) throws Exception {
        ScreenRecorderUtil.startRecord(method.getName());

        JsonDataReader jsonDataReader = new JsonDataReader(FILENAME);
        String URL = jsonDataReader.jsonReader("URL");
        driver.get(URL);
    }

    @BeforeClass
    public void setUp() {
        setUpBrowser();
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void afterMethod(Method method,ITestResult result) throws Exception {
        utilsTests = new UtilsTests(driver);
        utilsTests.statusOfTestCases(result,method);

        utilsTests.takeScreenShot(method);
        ScreenRecorderUtil.stopRecord();


    }

    @AfterClass
    public void tearDown()  {
        driver.quit();
    }


    @BeforeSuite
    public void start(){
        utilsTests = new UtilsTests(driver);
        utilsTests.createReport();
    }
    @AfterSuite
    public void afterSuite(){
        utilsTests = new UtilsTests(driver);
        utilsTests.flushReport();
    }
}
