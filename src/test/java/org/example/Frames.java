package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Frames
{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com");
        driver.findElement(By.linkText("Nested Frames")).click();

        System.out.println(driver.findElements(By.tagName("frame")).size());
        driver.switchTo().frame(0);
        System.out.println(driver.findElements(By.tagName("frame")).size());
        driver.switchTo().frame(1);
        WebElement middleText = driver.findElement(By.id("content"));
        System.out.println(middleText.getText());
        Assert.assertEquals(middleText.getText(), "MIDDLE");
    }
}
