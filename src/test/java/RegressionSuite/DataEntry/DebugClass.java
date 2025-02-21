package RegressionSuite.DataEntry;

import base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class DebugClass extends BaseTest{

    @Test

    public void WalletTEst () throws InterruptedException {
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
        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("underwrite.processing")));

        System.out.println("Underwriting was successful");
    }
}