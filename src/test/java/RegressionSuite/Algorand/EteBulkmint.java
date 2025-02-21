package RegressionSuite.Algorand;

import base.BaseTest;
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

public class EteBulkmint extends BaseTest{

    @Test
    @Feature("Bulk Mint")
    @Story("User should able to Bulk mint sucessfully")
    public void EteBulkmint() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Load config properties
        ConfigReader config = new ConfigReader();

        /*/ Step 1: Navigate to Home
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

        System.out.println("Algorand wallet connected successfully");*/

        // Step 6: Hover on NFTs dropdown on header
        driver.findElement(By.xpath(ConfigReader.getProperty("nftDropdown"))).click();
        // Step 7: Click on Mint option
        driver.findElement(By.xpath(ConfigReader.getProperty("mintOption"))).click();
        // Wait for mint page
        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("mint.page.delay")));
        // Step 8: Select number of NFTs
        driver.findElement(By.xpath(ConfigReader.getProperty("selectNFT"))).click();

        WebElement Scroll1=driver.findElement(By.xpath(ConfigReader.getProperty("unlockDiscount")));
        Actions actions = new Actions(driver);
        actions.moveToElement(Scroll1);
        actions.perform();

        // Step 9: Click on Unlock 20% discount
        driver.findElement(By.xpath(ConfigReader.getProperty("unlockDiscount"))).click();
        // Wait for discount unlock
        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("discount.unlock.delay")));
        // Step 10: Accept Terms by clicking the checkbox
        driver.findElement(By.xpath(ConfigReader.getProperty("acceptTerms"))).click();

        WebElement Scroll2=driver.findElement(By.xpath(ConfigReader.getProperty("advanceMintScroll")));
        actions.moveToElement(Scroll2);
        actions.perform();

        // Step 11: Click on "Create NFTs" button
        driver.findElement(By.xpath(ConfigReader.getProperty("createBulkNFT"))).click();
        // Wait for transaction to complete
        Thread.sleep(Integer.parseInt(ConfigReader.getProperty("create.nft.delay")));

        System.out.println("Transaction signed on PERA wallet");
        System.out.println("Bulk mint was successful");

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
