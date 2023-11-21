package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import static org.openqa.selenium.support.locators.RelativeLocator.*;


public class RelativeLocators
{
    @Test
    public void RelativeLocatorstest()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice");
        WebElement nameBox = driver.findElement(By.cssSelector("[name=\"name\"]"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(nameBox)).getText());

        WebElement dateOfBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();
        WebElement iceCreamLabel = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();

        WebElement radioButton = driver.findElement(By.id("inlineRadio1"));
        String labelOfstudentText = driver.findElement(with(By.tagName("label")).toRightOf(radioButton)).getText();
        System.out.println(labelOfstudentText);
    }
}
