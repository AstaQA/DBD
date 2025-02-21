package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import java.io.File;
import java.io.IOException;


public class Bulkmint {

    public static void main(String[] args) {

        //FirefoxDriver driver = new FirefoxDriver();
        //EdgeDriver driver = new EdgeDriver();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Step 1: Navigate to Homepage
        driver.get("https://devnet.daybyday.io/");
        System.out.println("Navigated to the right URL");
        //Step 2: Accept Cookies
        driver.findElement(By.xpath("/html/body/app-root/div/div/div/div[1]/a")).click();
        //Step 3: Click on Connect button on the header
        driver.findElement(By.xpath("/html/body/app-root/header/nav/div/div[2]/ul/li[10]/button/span")).click();
        //Step 4: Click on UnderwriteAlgorand
        driver.findElement(By.xpath("/html/body/app-root/header/nav/div/div[2]/ul/li[10]/div/button[3]/span")).click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Step 5: Click on PERA on the modal
        driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/app-algo-connect/div[2]/div[2]/div[1]/button/img")).click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("UnderwriteAlgorand wallet connected successfully");

        //Step 6: Hover on NFTs dropdown on header
        driver.findElement(By.xpath("/html/body/app-root/header/nav/div/div[2]/ul/li[1]/button/span")).click();
        //Step 7: Click on Mint option
        driver.findElement(By.xpath("/html/body/app-root/header/nav/div/div[2]/ul/li[1]/div/a[1]")).click();
        System.out.println("Navigated to mint page");

        try {
            Thread.sleep(6000);
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
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Step 10: Accept Terms by clicking the checkbox
        driver.findElement(By.xpath("/html/body/app-root/main/app-bulk-mint-policies/div/div/div[2]/div/div/div[1]/div/div[2]/div/div[4]/div/div/label")).click();

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

        System.out.println("Transaction signed on PERA wallet");
        System.out.println("Bulk mint was successfull");

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            File destination = new File("C:\\Eclipce-workplace\\DBD\\DayByDay\\Screenshots/Algorand/BulkMInts.jpg");
            FileUtils.copyFile(screenshot, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Result captured");

    }
}
