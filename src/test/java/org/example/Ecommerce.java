package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.stream;

public class Ecommerce
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String[] productTypes = {"Cucumber", "Brocolli", "Beetroot"};
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        addItems(productTypes, driver);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.cssSelector("button[type='button']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("input[placeholder='Enter promo code']")))).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("promoBtn")).click();
        Assert.assertEquals(driver.findElement(By.className("promoInfo")).getText(), "Code applied ..!");
        System.out.println(driver.findElement(By.className("promoInfo")).getText());
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();



    }
    public static void addItems(String[] items, WebDriver driver)
    {
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        int j = 0;
        for(int i = 0; i < products.size(); i++)
        {
            String productName = products.get(i).getText().split("-")[0].trim();
            List veggies = Arrays.asList(items);
            if(veggies.contains(productName))
            {
                j++;
                System.out.println(productName);
                driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
                if(j == items.length) break;
            }
        }
    }
}
/*Synchronization in Selenium*/
/*
 Implicit wait: wait for a number of seconds before you an exception.
 driver.manage().timeouts().implicitWait(Duration.ofSeconds(5))
 The specified time is the maximum time limit the code will be waited.

 Explicit wait:
   1. WebDriverWait class and FluentWait class

*/
//