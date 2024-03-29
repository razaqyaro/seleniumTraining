package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class R_Locators {
    private static String myBrowser = "edge";

    public static WebDriver driver;

    public static void main(String[] args)
    {
        if(myBrowser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(myBrowser.equals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if(myBrowser.equals("edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  // when application in a transition state, you need to wait small Thread.sleep(1000)
        driver.get("https://rahulshettyacademy.com/locatorspractice");
        driver.manage().window().maximize();
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("123345");
        driver.findElement(By.className("submit")).click();
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        //WebElement errorElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.error")));
        WebElement error = driver.findElement(By.cssSelector("p.error"));
        System.out.println(error.getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
        String email = "razaqyaro@gmail.com";
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys(email);
        driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys(email);
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@gmail.com");
       // driver.findElement(By.cssSelector("input[text='text']:nth-child(2)"));
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("Form p")).getText());
        // css selector => tagname[attribute='value'] p[class='error']
        // xpath => tagname[@attribute'value']
    }
    public String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("inputPassword")).sendKeys("123345");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordText = driver.findElement(By.cssSelector("form p")).getText();
        // Please use temporary password 'rahulshettyacademy' to Login.
        String[] passwordArray = passwordText.split("'");
        // 0th index - Please use temporary password
        // 1st index - rahulshettyacademy' to Login.
        String[] newPasswordText = passwordArray[1].split("'");
         //0th index - rahulshettyacademy
        // 1st index - to Login.
        String password = newPasswordText[0];

        return password;

    }
}
