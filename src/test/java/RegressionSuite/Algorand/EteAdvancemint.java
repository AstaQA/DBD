package RegressionSuite.Algorand;

import base.BaseTest;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;


import java.io.File;
import java.io.IOException;

public class EteAdvancemint extends BaseTest{

/*{ private WebDriver driver;
    @BeforeMethod
    public void setUp() {
        //FirefoxDriver driver = new FirefoxDriver();
        //EdgeDriver driver = new EdgeDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }*/


    @Test
    @Feature("Advance Mint")
    @Story("User should be able to mint NFT successfully")
    public void EteAdvancemint() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Step 1: Navigate to Home
        driver.get(ConfigReader.getProperty("baseURL"));
        System.out.println("Navigated to the right URL");
        // Step 2: Accept Cookies
        driver.findElement(By.xpath(ConfigReader.getProperty("acceptCookies"))).click();
        // Step 3: Click on Connect button on the header
        driver.findElement(By.xpath(ConfigReader.getProperty("connectButton"))).click();
        // Step 4: Click on Algorand
        driver.findElement(By.xpath(ConfigReader.getProperty("algorandButton"))).click();
        //Conecting wallet....
        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("pera.wallet.connect.delay")));

        // Step 5: Click on PERA on the modal
        driver.findElement(By.xpath(ConfigReader.getProperty("peraWalletButton"))).click();

        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("pera.wallet.connect.delay")));
        System.out.println("Algorand wallet connected successfully");

        // Step 6: Hover on NFTs dropdown on header
        driver.findElement(By.xpath(ConfigReader.getProperty("nftDropdown"))).click();
        // Step 7: Click on Mint option
        driver.findElement(By.xpath(ConfigReader.getProperty("mintOption"))).click();

        //Page Load
        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("page.load")));

        // Scroll to Advance Mint option
        WebElement scrollElement = driver.findElement(By.xpath(ConfigReader.getProperty("advanceMintScroll")));
        Actions actions = new Actions(driver);
        actions.moveToElement(scrollElement);
        actions.perform();

        // Step 8: Click on "Advance Mint" option
        driver.findElement(By.xpath(ConfigReader.getProperty("advanceMintButton"))).click();

        //Mint Page Load
        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("mint.page.delay")));
        System.out.println("Advance mint opted by the user");

        // Step 9: Select Asset Type
        driver.findElement(By.id(ConfigReader.getProperty("electronics"))).click(); // Electronics
        //driver.findElement(By.id(ConfigReader.getProperty("appliances"))).click(); // Appliances
        driver.findElement(By.id(ConfigReader.getProperty("jewellery"))).click(); // Jewellery
        //driver.findElement(By.id(ConfigReader.getProperty("art"))).click(); // Art
        //driver.findElement(By.id(ConfigReader.getProperty("tools"))).click(); // Tools
        driver.findElement(By.id(ConfigReader.getProperty("furniture"))).click(); // Furniture

        // Step 10: Select Event types
        driver.findElement(By.id(ConfigReader.getProperty("theft"))).click(); // Theft
        driver.findElement(By.id(ConfigReader.getProperty("water"))).click(); // Water
        //river.findElement(By.id(ConfigReader.getProperty("fire"))).click(); // Fire
        //driver.findElement(By.id(ConfigReader.getProperty("vehicleImpact"))).click(); // Vehicle Impact

        // Scroll to "PAY" button
        WebElement scrollPay = driver.findElement(By.xpath(ConfigReader.getProperty("payButtonScroll")));
        actions.moveToElement(scrollPay);
        actions.perform();

        // Step 11: Select Duration from the dropdown
        driver.findElement(By.xpath(ConfigReader.getProperty("durationDropdown")))
                .sendKeys(ConfigReader.getProperty("mintDuration"), Keys.ENTER);
        // Step 12: Click on "PAY" button
        driver.findElement(By.xpath(ConfigReader.getProperty("payButton"))).click();

        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("mint.page.delay")));

        // Step 13: Click on "Unlock 20% Discount" button
        driver.findElement(By.xpath(ConfigReader.getProperty("unlockDiscountButton"))).click();

        //Dicount load
        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("unlockdiscount.load")));

        // Step 14: Accept conditions by clicking the checkbox button
        driver.findElement(By.xpath(ConfigReader.getProperty("acceptConditions"))).click();
        // Step 15: Click on "Create NFT" button
        driver.findElement(By.xpath(ConfigReader.getProperty("createNFT"))).click();

        // Wait for transaction to complete
        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("transaction.load")));
        System.out.println("Transaction signed on PERA wallet");
        System.out.println("Advance mint was successful");

        // Step 16: Click on Claim NFTs button on the modal
        driver.findElement(By.xpath(ConfigReader.getProperty("claimASA"))).click();

        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("peraTRX.load")));
        System.out.println("ASA Transferred successfully");

        // Capture Screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            File destination = new File("C:\\Eclipce-workplace\\DBD\\DayByDay\\Screenshots/Algorand/AdvanceMint.jpg");
            FileUtils.copyFile(screenshot, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Result captured");

    }
}