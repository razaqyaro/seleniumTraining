package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
public class NewWindows
{
    @Test
    public void newWindowTest()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.TAB);

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> handleID = handles.iterator();
        String parentWindow = handleID.next();
        String childWindow = handleID.next();

        driver.switchTo().window(childWindow);
        driver.get("https://rahulshettyacademy.com");

        String courseName = driver.findElements(By.cssSelector("a[href='https://courses.rahulshettyacademy.com/p/core-java-for-automation-testers-interview-programs']")).get(1).getText();
        System.out.println(courseName);

        driver.switchTo().window(parentWindow);
        driver.findElement(By.cssSelector("[name='name']")).sendKeys(courseName);
    }


}
