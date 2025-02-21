package RegressionSuite.Algorand;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import io.qameta.allure.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;


import java.io.File;
import java.io.IOException;

public class UnderwriteAlgorand extends BaseTest {

    @Test
    @Description("Verify functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Underwite")
    @Story("User should be able to underwrite successfully")
    public void UnderwriteAlgorand() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ConfigReader config = new ConfigReader();

        // Step 1: Navigate to Home
        driver.get(ConfigReader.getProperty("baseURL"));
        System.out.println("Navigated to the right URL");
        // Step 2: Accept Cookies
        driver.findElement(By.xpath(ConfigReader.getProperty("acceptCookies"))).click();
        // Step 3: Click on Connect button on the header
        driver.findElement(By.xpath(ConfigReader.getProperty("connectButton"))).click();
        // Step 4: Click on Algorand
        driver.findElement(By.xpath(ConfigReader.getProperty("algorandButton"))).click();
        // Delay for PERA wallet connection
        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("pera.wallet.connect.delay")));
        // Step 5: Click on PERA on the modal
        driver.findElement(By.xpath(ConfigReader.getProperty("peraWalletButton"))).click();
        // Wait for PERA connection

        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("pera.wallet.connect.delay")));
        System.out.println("Algorand wallet connected successfully");

        //Step 6: Click on Underwrite
        driver.findElement(By.xpath(ConfigReader.getProperty("underwritePage"))).click();
        System.out.println("Navigated to https://devnet.daybyday.io/underwrite");

        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("underwrite.load")));
        System.out.println("Page loaded right");
        //Step 7: Click on "Contribute to Under..." button
        driver.findElement(By.xpath(ConfigReader.getProperty("contribute"))).click();
        //Step 8: Enter Amount
        driver.findElement(By.xpath(ConfigReader.getProperty("amountInput"))).sendKeys("50");
        System.out.println("Amount validation passed");

        WebElement scrollElement = driver.findElement(By.xpath(ConfigReader.getProperty("liquidityButton")));
        Actions actions = new Actions(driver);
        actions.moveToElement(scrollElement);
        actions.perform();

        //Step 9: Click on +Liquidity button
        driver.findElement(By.xpath(ConfigReader.getProperty("liquidityButton"))).click();

        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("underwrite.processing")));

        System.out.println("Underwriting was successfull");

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            File destination = new File("C:\\Eclipce-workplace\\DBD\\DayByDay\\Screenshots/Algorand/Underwrite.jpg");
            FileUtils.copyFile(screenshot, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Result captured");
    }

}


