package pages;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;

public class GetinsuranceAlgo {

    private static final Logger log = LoggerFactory.getLogger(GetinsuranceAlgo.class);

    public static void main(String[] args) {

        //FirefoxDriver driver = new FirefoxDriver();
        //EdgeDriver driver = new EdgeDriver();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Step 1: Naviagte to the right URL
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
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Wallet connected successfully");

        //Step 6: Click on "get a quote" button
        driver.findElement(By.xpath("/html/body/app-root/header/nav/div/div[2]/ul/li[3]/a")).click();
        System.out.println("Navigated to the get-protection page ");
        //Step 7: Select asset
        driver.findElement(By.xpath("/html/body/app-root/main/app-get-insurance/div/div[2]/div/div/div/div[5]/div/div[2]/div[1]/div/div/div/div[1]/div")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Step 8: Enter Protect amount
        WebElement inputField = driver.findElement(By.id("insuredAmount05ad4822-1220-48cf-aecb-ee604c6f0cab"));
        inputField.click();
        inputField.clear();
        inputField.sendKeys("50");

        //Scroll to "start date"
        WebElement Scroll1=driver.findElement(By.xpath("/html/body/app-root/main/app-get-insurance/div/div[3]/div/div/div/div[5]/div/div[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(Scroll1);
        actions.perform();

        //Step 9: Enter Start Date
        driver.findElement(By.id("startDate")).sendKeys("18022025");
        //Step 10: Enter Duration
        WebElement inputField1 = driver.findElement(By.xpath("/html/body/app-root/main/app-get-insurance/div/div[3]/div/div/div/div[3]/div/div/ng-select/div/div/div[2]/input"));
        inputField1.click();
        inputField1.sendKeys("30 Days");
        inputField1.sendKeys(Keys.ENTER);

        //Scroll to "Confirm your protection"
        WebElement Scroll2=driver.findElement(By.xpath("/html/body/app-root/main/app-get-insurance/div/div[5]/div/div/div[2]/button"));
        Actions actions2 = new Actions(driver);
        actions.moveToElement(Scroll1);
        actions.perform();







    }
}