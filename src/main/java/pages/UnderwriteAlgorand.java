package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;

public class UnderwriteAlgorand {

    public static void main(String[] args) throws InterruptedException {

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
            Thread.sleep(6000);
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

        try {
            Thread.sleep(14000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Step 6: Click on Underwrite
        driver.findElement(By.xpath("/html/body/app-root/header/nav/div/div[2]/ul/li[2]/a")).click();
        System.out.println("Navigates to https://devnet.daybyday.io/underwrite");

        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Step 7: Click on "Contribute to Under..." button
        driver.findElement(By.xpath("/html/body/app-root/main/app-underwrite/div[1]/div/div/div/div/div/div[1]/button")).click();
        //Step 8: Enter Amount
        driver.findElement(By.xpath("/html/body/app-root/main/app-underwrite/app-underwrite-details-algo/div[1]/div/div/div/div/div/div[1]/div/div[2]/div/form/div/div/div/div[1]/div/input")).sendKeys("50");
        //Step 9: Click on +Liquidity button
        driver.findElement(By.xpath("/html/body/app-root/main/app-underwrite/app-underwrite-details-algo/div[1]/div/div/div/div/div/div[1]/div/div[2]/div/form/div/div/div/div[1]/div/button")).click();

        try {
            Thread.sleep(18000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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