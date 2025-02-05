package Underwriting;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.time.Duration;

public class Polygon {

    public static void main(String[] args) throws InterruptedException {


        //FirefoxDriver driver = new FirefoxDriver();
        //EdgeDriver driver = new EdgeDriver();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://devnet.daybyday.io/");
        //driver.get("https://testnet.daybyday.io/");
        System.out.println("Navigated to the right URL");
        driver.findElement(By.xpath("/html/body/app-root/div/div/div/div[1]/a")).click(); //Accept Cookies
        driver.findElement(By.xpath("/html/body/app-root/header/nav/div/div[2]/ul/li[10]/button")).click(); //Click on Wallet button
        driver.findElement(By.xpath("/html/body/app-root/header/nav/div/div[2]/ul/li[10]/div/button[2]")).click(); //Click on Polygon
        driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/app-poly-connect/div[2]/div[2]/div[1]/button")).click(); //Click on MetaMask

        try {
            Thread.sleep(14000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/app-root/header/nav/div/div[2]/ul/li[2]/a")).click(); //Click on Underwrite
        System.out.println("Navigates to https://devnet.daybyday.io/underwrite");

        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/app-root/main/app-underwrite/div[1]/div/div/div/div/div/div[1]/button")).click(); //Click on "Contribute to Under..."
        driver.findElement(By.xpath("/html/body/app-root/main/app-underwrite/app-underwrite-details-poly/div/div/div/div/div/div/div[1]/div/div[2]/div[1]/form/div/div/div/div[1]/div/input")).sendKeys("50"); //Enter Amount
        driver.findElement(By.xpath("/html/body/app-root/main/app-underwrite/app-underwrite-details-poly/div/div/div/div/div/div/div[1]/div/div[2]/div[1]/form/div/div/div/div[1]/div/button")).click(); //Click on +Liquidity

        try {
            Thread.sleep(18000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Underwriting was successfull");

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            File destination = new File("C:\\Eclipce-workplace\\DBD\\DayByDay\\Screenshots/Underwrite/Devtnet1.jpg");
            FileUtils.copyFile(screenshot, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

