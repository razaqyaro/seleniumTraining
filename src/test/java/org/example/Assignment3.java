package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Assignment3
{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com");
        driver.findElement(By.cssSelector("a[href='/windows']")).click();
        driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> IDs = windows.iterator();
        String parentID = IDs.next();
        String childID = IDs.next();
        driver.switchTo().window(childID);
        System.out.println(driver.findElement(By.tagName("h3")).getText());
        driver.switchTo().window(parentID);
        System.out.println(driver.findElement(By.tagName("h3")).getText());


    }
}
