package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Scrolling
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scroll(0, 600)");
        Thread.sleep(3000);
        executor.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        WebElement actualTotalElement = driver.findElement(By.className("totalAmount"));
        String[] actualTotalText = actualTotalElement.getText().split(": ");
        String actualTotalValueToBeTrimmed = actualTotalText[1].trim();
        int actualTotalToAssert = Integer.parseInt(actualTotalValueToBeTrimmed);
        int total = 0;
        for(int i = 0; i < values.size(); i++)
        {
            String number = (values.get(i).getText());
            int realValue = Integer.parseInt(number);
            total+=realValue;
        }
        Assert.assertEquals(actualTotalToAssert, total);

        System.out.println("Data type of actualTotalToAssert: " + Integer.class.getSimpleName());
        System.out.println("Data type of actualTotalValueToBeTrimmed: " + actualTotalValueToBeTrimmed.getClass().getSimpleName());
    }
}
