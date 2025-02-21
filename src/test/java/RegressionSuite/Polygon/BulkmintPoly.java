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

public class BulkmintPoly extends BaseTest {


    @Test
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
        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("page.load")));
        driver.findElement(By.xpath(ConfigReader.getProperty("nftDropdown"))).click();

        // Step 7: Click on Mint option
        driver.findElement(By.xpath(ConfigReader.getProperty("mintOption"))).click();
        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("mintpage.load")));

        // Step 8: Select number of NFTs
        driver.findElement(By.xpath(ConfigReader.getProperty("selectNFT"))).click();

        WebElement scroll1 = driver.findElement(By.xpath(ConfigReader.getProperty("unlockDiscount")));
        Actions actions = new Actions(driver);
        actions.moveToElement(scroll1).perform();

        // Step 9: Select Token
        driver.findElement(By.xpath(ConfigReader.getProperty("stwToken"))).click();

        // Step 10: Click on "Unlock 20% Discount" button
        driver.findElement(By.xpath(ConfigReader.getProperty("unlockDiscount"))).click();
        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("unlockdiscount.load")));

        // Step 11: Accept conditions by clicking the checkbox button
        driver.findElement(By.xpath(ConfigReader.getProperty("acceptTerms"))).click();
        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("nftButton.load")));

        WebElement scroll2 = driver.findElement(By.xpath(ConfigReader.getProperty("advanceMintScroll")));
        actions.moveToElement(scroll2).perform();

        // Step 12: Click on "Create NFT" button
        driver.findElement(By.xpath(ConfigReader.getProperty("createBulkNFT"))).click();
        System.out.println("Processing the Transaction");

        /*//Thread.sleep(Integer.parseInt(ConfigReader.getProperty("transaction.load")));

        // Wait for the toast message
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        //WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("toast-message")));

        // Capture the toast message text
        //String errorMessage = toastMessage.getText();
        //System.out.println("Transaction Status: " + errorMessage);*/
        //Wait for toast
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

        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("sleep.pay")));

    }
}


