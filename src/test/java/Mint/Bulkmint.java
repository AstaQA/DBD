package Mint;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


import javax.swing.*;
import java.io.File;
import java.io.IOException;


public class Bulkmint {

    public static void main(String[] args) {

        //FirefoxDriver driver = new FirefoxDriver();
        //EdgeDriver driver = new EdgeDriver();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://testnet.daybyday.io/");
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

        driver.get("https://testnet.daybyday.io/");
        System.out.println("Navigated to mint page");

        driver.findElement(By.xpath("/html/body/app-root/header/nav/div/div[2]/ul/li[1]/button/span")).click();
        driver.findElement(By.xpath("/html/body/app-root/header/nav/div/div[2]/ul/li[1]/div/a[1]")).click();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/app-root/main/app-bulk-mint-policies/div/div/div[2]/div/div/div[1]/div/div[1]/div/div/button[2]")).click();

        WebElement Scroll1=driver.findElement(By.xpath("/html/body/app-root/main/app-bulk-mint-policies/div/div/div[2]/div/div/div[2]/div[1]/div/button"));
        Actions actions = new Actions(driver);
        actions.moveToElement(Scroll1);
        actions.perform();

        driver.findElement(By.xpath("/html/body/app-root/main/app-bulk-mint-policies/div/div/div[2]/div/div/div[2]/div[1]/div/button")).click();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/app-root/main/app-bulk-mint-policies/div/div/div[2]/div/div/div[1]/div/div[2]/div/div[4]/div/div/label")).click();

        WebElement Scroll2=driver.findElement(By.xpath("/html/body/app-root/main/app-bulk-mint-policies/div/p/a"));
        actions.moveToElement(Scroll2);
        actions.perform();

        driver.findElement(By.xpath("/html/body/app-root/main/app-bulk-mint-policies/div/div/div[2]/div/div/div[2]/div[2]/button")).click();


        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Transaction signed on PERA wallet");
        System.out.println("Bulk mint was successfull");

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            File destination = new File("C:\\Eclipce-workplace\\DBD\\DayByDay\\Screenshots/Bulkmint/Testnet1.png");
            FileUtils.copyFile(screenshot, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Result captured");

        driver.close();

    }
}
