package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Filter
{
    @Test
    public  void FilterTest()
        {
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.id("search-field")).sendKeys("Rice");
        List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
        //results
        List<WebElement> filteredResults = veggies.stream().filter(veggie -> veggie.getText().contains("Rice"))
                .collect(Collectors.toList());

        // 1 result
            Assert.assertEquals(veggies, filteredResults);

    }

    @Test
    public void TestingFilter()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.id("search-field")).sendKeys("Rice");

        List<WebElement> veggies=driver.findElements(By.xpath("//tr/td[1]"));

        //1 results

        List<WebElement> filteredList= veggies.stream().filter(veggie->veggie.getText().contains("Rice")).

                collect(Collectors.toList());

        //1 result

        Assert.assertEquals(veggies.size(), filteredList.size());
    }
}
