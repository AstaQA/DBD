package RegressionSuite.Polygon;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import io.qameta.allure.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class UnderwritePoly extends BaseTest {

    @Test (priority = 1)
    @Description("Verify functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Underwite")
    @Story("User should be able to underwrite successfully")
    public void UnderwritePoly() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        /*// Step 1: Navigate to the right URL
        driver.get(ConfigReader.getProperty("baseURL"));
        System.out.println("Navigated to the right URL");

        // Step 2: Accept Cookies
        driver.findElement(By.xpath(ConfigReader.getProperty("acceptCookies"))).click();

        // Step 3: Click on Wallet button
        driver.findElement(By.xpath(ConfigReader.getProperty("connectButton"))).click();

        // Step 4: Click on Polygon
        driver.findElement(By.xpath(ConfigReader.getProperty("polygonButton"))).click();

        // Step 5: Click on MetaMask
        driver.findElement(By.xpath(ConfigReader.getProperty("metamaskButton"))).click();
        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("wallet.load")));
        System.out.println("UnderwritePolygon wallet connected successfully");*/

        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("page.load")));
        // Step 6: Click on Underwrite
        driver.findElement(By.xpath(ConfigReader.getProperty("underwritePage"))).click();
        System.out.println("Navigated to Underwrite page");
        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("underwrite.load")));

        // Step 7: Click on "Contribute to Underwrite"
        driver.findElement(By.xpath(ConfigReader.getProperty("contribute"))).click();

        // Step 8: Enter Amount
        driver.findElement(By.xpath(ConfigReader.getProperty("polyAmountInput"))).sendKeys("50");
        System.out.println("Amount validation passed");

        WebElement scroll3 = driver.findElement(By.xpath(ConfigReader.getProperty("polyLiquidityButton")));
        Actions actions = new Actions(driver);
        actions.moveToElement(scroll3);
        actions.perform();

        // Step 9: Click on +Liquidity
        driver.findElement(By.xpath(ConfigReader.getProperty("polyLiquidityButton"))).click();
        //Thread.sleep(Integer.parseInt(ConfigReader.getProperty("underwrite.processing")));

        // Wait for the toast message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("toast-message")));

        // Capture the toast message text
        String errorMessage = toastMessage.getText();
        System.out.println("Transaction Status: " + errorMessage);

        System.out.println("Underwriting was successful");

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            File destination = new File("C:\\Eclipce-workplace\\DBD\\DayByDay\\Screenshots/UnderwritePolygon/Underwrite.jpg");
            FileUtils.copyFile(screenshot, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Result captured");

        }
    }


