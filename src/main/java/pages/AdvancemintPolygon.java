package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class AdvancemintPolygon {

    public static void main(String[] args) throws InterruptedException {


        //FirefoxDriver driver = new FirefoxDriver();
        //EdgeDriver driver = new EdgeDriver();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Step 1: Navigate to the riight URL
        driver.get("https://devnet.daybyday.io/");
        //driver.get("https://testnet.daybyday.io/");
        System.out.println("Navigated to the right URL");

        //Step 2: Accept Cookies
        driver.findElement(By.xpath("/html/body/app-root/div/div/div/div[1]/a")).click();
        //Step 3: Click on Wallet button
        driver.findElement(By.xpath("/html/body/app-root/header/nav/div/div[2]/ul/li[10]/button")).click();
        //Step 4: Click on Polygon
        driver.findElement(By.xpath("/html/body/app-root/header/nav/div/div[2]/ul/li[10]/div/button[2]")).click();
        //Step 5: Click on MetaMask
        driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/app-poly-connect/div[2]/div[2]/div[1]/button")).click();

        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("UnderwritePolygon wallet connected successfully");


        //Step 6: Hover on NFTs dropdown on header
        driver.findElement(By.xpath("/html/body/app-root/header/nav/div/div[2]/ul/li[1]/button/span")).click();
        //Step 7: Click on Mint option
        driver.findElement(By.xpath("/html/body/app-root/header/nav/div/div[2]/ul/li[1]/div/a[1]")).click();


        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Scroll to Advance Mint option
        WebElement Scroll1 = driver.findElement(By.xpath("/html/body/app-root/main/app-bulk-mint-policies/div/p/a"));
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
        //driver.findElement(By.id("btn2")).click(); // Jewellery
        driver.findElement(By.id("btn4")).click(); // Art
        //driver.findElement(By.id("btn5")).click(); // Tools
        driver.findElement(By.id("btn11")).click(); // Furniture

        //Step 10: Select Event types
        driver.findElement(By.id("btn8")).click(); //Theft
        driver.findElement(By.id("btn6")).click(); //Water
        //driver.findElement(By.id("btn7")).click(); //Fire
        driver.findElement(By.id("btn9")).click(); //Vehicle Impact

        //Scroll to "PAY" button
        WebElement Scroll2 = driver.findElement(By.xpath("/html/body/app-root/main/app-mint-policy-nft/div/div[2]/div/div/div[2]/button[2]"));
        actions.moveToElement(Scroll2);
        actions.perform();

        //Step 11: Select Duration from the dropdown
        driver.findElement(By.xpath("/html/body/app-root/main/app-mint-policy-nft/div/div[2]/div/div/div[1]/div[1]/div[3]/div/div[2]/div[2]/ng-select/div/div/div[2]/input")).sendKeys("3", Keys.ENTER);
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
        System.out.println("Processing the Transaction");

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Transaction signed on Meta wallet");
        System.out.println("Advance mint was successfull");

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            File destination = new File("C:\\Eclipce-workplace\\DBD\\DayByDay\\Screenshots/UnderwritePolygon/Advance.jpg");
            FileUtils.copyFile(screenshot, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Result captured");
    }
}
