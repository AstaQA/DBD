package RegressionSuite.Polygon;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.qameta.allure.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class AdvancemintPoly extends BaseTest {


    @Test (priority = 2)
    @Feature("Advance Mint")
    @Story("User should be able to mint NFT successfully")
    public void AdvancemintPoly() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Load config properties
        ConfigReader config = new ConfigReader();

        // Step 1: Navigate to the right URL
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
        System.out.println("UnderwritePolygon wallet connected successfully");

        // Step 6: Hover on NFTs dropdown on header
        driver.findElement(By.xpath(ConfigReader.getProperty("nftDropdown"))).click();

        // Step 7: Click on Mint option
        driver.findElement(By.xpath(ConfigReader.getProperty("mintOption"))).click();
        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("mintpage.load")));

        // Step 8: Scroll to Advance Mint option
        WebElement scrollElement = driver.findElement(By.xpath(ConfigReader.getProperty("advanceMintButton")));
        new Actions(driver).moveToElement(scrollElement).perform();

        // Step 9: Click on "Advance Mint" option
        driver.findElement(By.xpath(ConfigReader.getProperty("advanceMintButton"))).click();
        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("advancemint.load")));
        System.out.println("Advance mint opted by the user");

        //Step 10: Select Asset Type
        //driver.findElement(By.id("btn23")).click(); //Electronics
        //driver.findElement(By.id("btn3")).click(); //Appliances
        //driver.findElement(By.id("btn2")).click(); // Jewellery
        //driver.findElement(By.id("btn4")).click(); // Art
        driver.findElement(By.id("btn5")).click(); // Tools
        driver.findElement(By.id("btn11")).click(); // Furniture

        //Step 11: Select Event types
        driver.findElement(By.id("btn8")).click(); //Theft
        //driver.findElement(By.id("btn6")).click(); //Water
        driver.findElement(By.id("btn7")).click(); //Fire
        driver.findElement(By.id("btn9")).click(); //Vehicle Impact

        // Step 12: Scroll to "PAY" button
        WebElement scrollPay = driver.findElement(By.xpath(ConfigReader.getProperty("payButtonScroll")));
        new Actions(driver).moveToElement(scrollPay).perform();

        // Step 13: Select Duration from the dropdown
        driver.findElement(By.xpath(ConfigReader.getProperty("durationDropdown")))
                .sendKeys(ConfigReader.getProperty("mintDuration"), Keys.ENTER);

        // Step 14: Click on "PAY" button
        driver.findElement(By.xpath(ConfigReader.getProperty("payButtonScroll"))).click();
        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("sleep.pay")));

        // Step 15: Select Token
        driver.findElement(By.xpath(ConfigReader.getProperty("stwTokenAdvance"))).click();

        // Step 16: Click on "Unlock 20% Discount" button
        driver.findElement(By.xpath(ConfigReader.getProperty("unlockDiscountButton"))).click();
        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("unlockdiscount.load")));

        // Step 17: Accept conditions by clicking the checkbox button
        driver.findElement(By.xpath(ConfigReader.getProperty("acceptConditions"))).click();
        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("nftButton.load")));

        // Step 18: Click on "Create NFT" button
        driver.findElement(By.xpath(ConfigReader.getProperty("createNFT"))).click();
        System.out.println("Processing the Transaction");
        //Thread.sleep(Integer.parseInt(ConfigReader.getProperty("transaction.load")));

        // Wait for the toast message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("toast-message")));

        // Capture the toast message text
        String actualMessage = toastMessage.getText();
        String expectedMessage = "Transaction Submitted - pending blockchain confirmation";
        
        // Assert toast message
        Assert.assertEquals(actualMessage, expectedMessage, "Toast message did not match!");
        
        System.out.println("Test Passed: Toast message displayed correctly.");
        System.out.println("Transaction Status: " + actualMessage);

        System.out.println("Transaction signed on Meta wallet");
        System.out.println("Advance mint was successful");

        }
    }