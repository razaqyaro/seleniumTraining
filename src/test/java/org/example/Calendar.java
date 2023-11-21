package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Calendar
{
    @Test
    public void calendarTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.path2usa.com/travel-companions");
        Thread.sleep(5);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scroll(0, 1000);");
        Thread.sleep(4000);
        driver.findElement(By.id("form-field-travel_comp_date")).click();

        while(!driver.findElement(By.cssSelector(".flatpickr-month")).getText().contains("December"))
        {
            driver.findElement(By.cssSelector("span.flatpickr-next-month")).click();
        }
        List<WebElement> days = driver.findElements(By.cssSelector("span.flatpickr-day"));
       // System.out.println(days.size());
        for(int i = 0; i < days.size(); i++)
        {
            System.out.println(driver.findElements(By.cssSelector("span.flatpickr-day")).get(i).getText());
            String text = driver.findElements(By.cssSelector("span.flatpickr-day")).get(i).getText();
            if(text.equalsIgnoreCase("23"))
            {
                driver.findElements(By.cssSelector("span.flatpickr-day")).get(i).click();
                break;
            }
        }

    }
}
