package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utils.ConfigReader;


import java.io.File;
import java.io.IOException;

public class Advancemint {
    public static void main(String[] args) {

        //FirefoxDriver driver = new FirefoxDriver();
        //EdgeDriver driver = new EdgeDriver();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Step 1: Navigate to Home
        driver.get(ConfigReader.getProperty("baseURL"));
        //driver.get("https://Devnet.daybyday.io/");
        System.out.println("Navigated to the right URL");

        //Step 2: Accept Cookies
        driver.findElement(By.xpath("/html/body/app-root/div/div/div/div[1]/a")).click();
        //Step 3: Click on Connect button on the header
        driver.findElement(By.xpath("/html/body/app-root/header/nav/div/div[2]/ul/li[10]/button/span")).click();
        //Step 4: Click on Alogorand
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

        System.out.println("Algorand wallet connected successfully");

        //Step 6: Hover on NFTs dropdown on header
        driver.findElement(By.xpath("/html/body/app-root/header/nav/div/div[2]/ul/li[1]/button/span")).click();
        //Step 7: Click on Mint option
        driver.findElement(By.xpath("/html/body/app-root/header/nav/div/div[2]/ul/li[1]/div/a[1]")).click();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Scroll to Advance Mint option
        WebElement Scroll1=driver.findElement(By.xpath("/html/body/app-root/main/app-bulk-mint-policies/div/p/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(Scroll1);
        actions.perform();

        //Step 8: Click on "Advance Mint" option
        driver.findElement(By.xpath("/html/body/app-root/main/app-bulk-mint-policies/div/p/a")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Advance mint opted by the user");

        //Step 9: Select Asset Type
        driver.findElement(By.id("btn23")).click(); //Electronics
        driver.findElement(By.id("btn3")).click(); //Appliances
        driver.findElement(By.id("btn2")).click(); // Jewellery
        //driver.findElement(By.id("btn4")).click(); // Art
        driver.findElement(By.id("btn5")).click(); // Tools
        driver.findElement(By.id("btn11")).click(); // Furniture

        //Step 10: Select Event types
        driver.findElement(By.id("btn8")).click(); //Theft
        driver.findElement(By.id("btn6")).click(); //Water
        driver.findElement(By.id("btn7")).click(); //Fire
        driver.findElement(By.id("btn9")).click(); //Vehicle Impact

        //Scroll to "PAY" button
        WebElement Scroll2=driver.findElement(By.xpath("/html/body/app-root/main/app-mint-policy-nft/div/div[2]/div/div/div[2]/button[2]"));
        actions.moveToElement(Scroll2);
        actions.perform();

        //Step 11: Select Duration from the dropdown
        driver.findElement(By.xpath("/html/body/app-root/main/app-mint-policy-nft/div/div[2]/div/div/div[1]/div[1]/div[3]/div/div[2]/div[2]/ng-select/div/div/div[2]/input")).sendKeys("21",Keys.ENTER);
        //Step 12: Click on "PAY" button
        driver.findElement(By.xpath("/html/body/app-root/main/app-mint-policy-nft/div/div[2]/div/div/div[2]/button[2]")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Step 13: Click on "Unlock 20% Discount" button
        driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/app-bulk-mint-policies/div/div/div[2]/div/div/div[2]/div[1]/div/button")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Step 14: Accept conditiond by clicking the checkbox button
        driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/app-bulk-mint-policies/div/div/div[2]/div/div/div[1]/div/div/div/div[3]/div/div/label")).click();
        //Step 15: Click on "Create NFT" button
        driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/app-bulk-mint-policies/div/div/div[2]/div/div/div[2]/div[2]/button")).click();

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Transaction signed on PERA wallet");
        System.out.println("Advance mint was successfull");

        //Click on Claim NFTs button on the modal
        driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div/div/div/div[2]/div/button")).click();

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ASA Transfered successfully");
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
