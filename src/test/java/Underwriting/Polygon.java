package Underwriting;

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

public class Polygon {

    public static void main(String[] args) {


        //FirefoxDriver driver = new FirefoxDriver();
        //EdgeDriver driver = new EdgeDriver();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://devnet.daybyday.io/");
        System.out.println("Navigated to the right URL");
        driver.findElement(By.xpath("/html/body/app-root/header/nav/div/div[2]/ul/li[10]/button")).click();
        driver.findElement(By.xpath("/html/body/app-root/header/nav/div/div[2]/ul/li[10]/div/button[2]")).click();
        driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/app-poly-connect/div[2]/div[2]/div[1]/button")).click();

        driver.get("chrome-extension://<nkbihfbeogaeaoehlefnkodbefgpgknn>/home.html");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/form/div/div/input")).sendKeys("Tuesday@4140");





    }
}
