package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import utils.ScreenshotUtil;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeSuite
    public void setup() {
        System.out.println("Initializing WebDriver...");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            ScreenshotUtil.takeScreenshot(driver, "TestFailureScreenshot");
            System.out.println("Closing WebDriver...");
            driver.quit();
        }
    }
}
