package Mint;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Advancemint {
    public static void main(String[] args) {

        //FirefoxDriver driver = new FirefoxDriver();
        //EdgeDriver driver = new EdgeDriver();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://devnet.daybyday.io/");
        System.out.println("Navigated to the right URL");
        driver.findElement(By.xpath("/html/body/app-root/div/div/div/div[1]/a")).click();
        driver.findElement(By.xpath("/html/body/app-root/header/nav/div/div[2]/ul/li[10]/button/span")).click();
        driver.findElement(By.xpath("/html/body/app-root/header/nav/div/div[2]/ul/li[10]/div/button[3]/span")).click();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/app-algo-connect/div[2]/div[2]/div[1]/button/img")).click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Algorand wallet connected successfully");

        driver.get("https://devnet.daybyday.io/");

        driver.findElement(By.xpath("/html/body/app-root/header/nav/div/div[2]/ul/li[1]/button/span")).click();
        driver.findElement(By.xpath("/html/body/app-root/header/nav/div/div[2]/ul/li[1]/div/a[1]")).click();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement Scroll1=driver.findElement(By.xpath("/html/body/app-root/main/app-bulk-mint-policies/div/p/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(Scroll1);
        actions.perform();

        driver.findElement(By.xpath("/html/body/app-root/main/app-bulk-mint-policies/div/p/a")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Advance mint opted by the user");

        driver.findElement(By.id("btn23")).click(); //Electronics
        //driver.findElement(By.id("btn3")).click(); //Appliances
        driver.findElement(By.id("btn2")).click(); // Jewellery
        //driver.findElement(By.id("btn4")).click(); // Art
        //driver.findElement(By.id("btn5")).click(); // Tools
        driver.findElement(By.id("btn11")).click(); // Furniture

        driver.findElement(By.id("btn8")).click(); //Theft
        driver.findElement(By.id("btn6")).click(); //Water
        //driver.findElement(By.id("btn7")).click(); //Fire
        //driver.findElement(By.id("btn9")).click(); //Vehicle Impact

        WebElement Scroll2=driver.findElement(By.xpath("/html/body/app-root/main/app-mint-policy-nft/div/div[2]/div/div/div[2]/button[2]"));
        actions.moveToElement(Scroll2);
        actions.perform();

        driver.findElement(By.xpath("/html/body/app-root/main/app-mint-policy-nft/div/div[2]/div/div/div[1]/div[1]/div[3]/div/div[2]/div[2]/ng-select/div/div/div[2]/input")).sendKeys("3",Keys.ENTER);
        driver.findElement(By.xpath("/html/body/app-root/main/app-mint-policy-nft/div/div[2]/div/div/div[2]/button[2]")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/app-bulk-mint-policies/div/div/div[2]/div/div/div[2]/div[1]/div/button")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/app-bulk-mint-policies/div/div/div[2]/div/div/div[1]/div/div/div/div[3]/div/div/label")).click();
        driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/app-bulk-mint-policies/div/div/div[2]/div/div/div[2]/div[2]/button")).click();

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Transaction signed on PERA wallet");
        System.out.println("Advance mint was successfull");

        driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div/div/div/div[2]/div/button")).click();

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ASA Transfered successfully");
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            File destination = new File("C:\\Eclipce-workplace\\DBD\\DayByDay\\Screenshots/Advancemint/Testnet1.jpg");
            FileUtils.copyFile(screenshot, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Result captured");
        driver.quit();
    }
}
