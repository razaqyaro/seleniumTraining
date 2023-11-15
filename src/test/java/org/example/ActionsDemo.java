package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsDemo
{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://amazon.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        Actions hover = new Actions(driver);
        hover.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-nav-role='signin']"))))
                .build()
                .perform();
        hover.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello")
                .build()
                .perform();


    }
}
