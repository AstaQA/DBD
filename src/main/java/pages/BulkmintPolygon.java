package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BulkmintPolygon {

    public static void main(String[] args) throws InterruptedException {


        //FirefoxDriver driver = new FirefoxDriver();
        //EdgeDriver driver = new EdgeDriver();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Step 1: Navigate to Home page
        driver.get("https://devnet.daybyday.io/");
        //driver.get("https://testnet.daybyday.io/");
        System.out.println("Navigated to the right URL");
        //Step 2: Accept Cookies
        driver.findElement(By.xpath("/html/body/app-root/div/div/div/div[1]/a")).click();
        //Step 3: Click on Wallet button
        driver.findElement(By.xpath("/html/body/app-root/header/nav/div/div[2]/ul/li[10]/button")).click();
        //Step 4: Click on UnderwritePolygon
        driver.findElement(By.xpath("/html/body/app-root/header/nav/div/div[2]/ul/li[10]/div/button[2]")).click();
        //Step 5: Click on MetaMask
        driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/app-poly-connect/div[2]/div[2]/div[1]/button")).click();

        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("UnderwritePolygon wallet connected successfully");

        //Step 6: Click on NFT dropdown
        driver.findElement(By.xpath("/html/body/app-root/header/nav/div/div[2]/ul/li[1]/button/span")).click();
        //Step 7: Click on Mint
        driver.findElement(By.xpath("/html/body/app-root/header/nav/div/div[2]/ul/li[1]/div/a[1]")).click();
        System.out.println("Navigated to mint page");

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Step 8: Select number of NFTs
        driver.findElement(By.xpath("/html/body/app-root/main/app-bulk-mint-policies/div/div/div[2]/div/div/div[1]/div/div[1]/div/div/button[2]")).click();

        WebElement Scroll1=driver.findElement(By.xpath("/html/body/app-root/main/app-bulk-mint-policies/div/div/div[2]/div/div/div[2]/div[1]/div/button"));
        Actions actions = new Actions(driver);
        actions.moveToElement(Scroll1);
        actions.perform();

        //Step 9: Click on Unlock 20% discount
        driver.findElement(By.xpath("/html/body/app-root/main/app-bulk-mint-policies/div/div/div[2]/div/div/div[2]/div[1]/div/button")).click();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Step 10: Accept Terms by clicking the checkbox
        driver.findElement(By.id("agreement")).click();

        WebElement Scroll2=driver.findElement(By.xpath("/html/body/app-root/main/app-bulk-mint-policies/div/p/a"));
        actions.moveToElement(Scroll2);
        actions.perform();


        //Step 11 Click on "Create NFTs" button
        driver.findElement(By.xpath("/html/body/app-root/main/app-bulk-mint-policies/div/div/div[2]/div/div/div[2]/div[2]/button")).click();


        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Transaction signed on META wallet");
        System.out.println("Bulk mint was successfull");

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            File destination = new File("C:\\Eclipce-workplace\\DBD\\DayByDay\\Screenshots/UnderwritePolygon/Bulkmint.png");
            FileUtils.copyFile(screenshot, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Result captured");
    }
}