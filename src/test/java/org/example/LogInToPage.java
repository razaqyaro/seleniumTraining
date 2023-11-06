package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class LogInToPage {
    private static String myBrowser = "edge";

    public static WebDriver driver;

    public static void main(String[] args)
    {
        if (myBrowser.equals("chrome")) {

            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();
        }
        else if (myBrowser.equals("firefox")) {

            WebDriverManager.firefoxdriver().setup();

            driver = new FirefoxDriver();

        }
        else if (myBrowser.equals("edge")) {

            WebDriverManager.edgedriver().setup();

            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  // when application in a transition state, you need to wait small Thread.sleep(1000)

        driver.get("https://rahulshettyacademy.com/locatorspractice");

        driver.manage().window().maximize();

        driver.findElement(By.id("inputUsername")).sendKeys("rahul");

        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

        driver.findElement(By.xpath("//div/span[1]/input")).click();

        driver.findElement(By.xpath("//div/span[2]/input")).click();

        driver.findElement(By.className("submit")).click();

        System.out.println(driver.findElement(By.tagName("p")));
    }
}

// //div[@class="forgot-pwd-btn-container"]/button[1]