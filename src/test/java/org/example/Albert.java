package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Albert
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowf.aspnetawesome.com/");
        driver.findElement(By.id("ContentPlaceHolder1_AllMealsSbm-awed")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("[data-index='1']")).click();
       WebElement element = driver.findElement(By.cssSelector("div[id='ContentPlaceHolder1_AllMealsSbm_s-dropmenu'] li:nth-child(1)"));
        System.out.println(element.getText());
       // driver.findElement(By.cssSelector("i.awe-cbc")).click();
        Actions hover = new Actions(driver);
        hover.moveToElement(element).build().perform();
    }
}
