package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsDemoInSelenium
{
    @Test
    public void test3()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        //1 Click on column
        driver.findElement(By.xpath("//tr/th[1]")).click();
        //2 Capture the webelements into a list
        List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
        //3 Capture all text of all webelements into new (original) list
        List<String> originalList = elementList.stream().map(element -> element.getText()).collect(Collectors.toList());
        //4 sort text of all texts into a new sorted list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        //5  compare original list vs sorted list
        Assert.assertTrue(originalList.equals(sortedList));
        // scan the name column with getText ->Beans->print the price of the Rice
        List<String> price;
        do
        {
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
            price = rows.stream().filter(s -> s.getText().contains("Rice"))
                 .map(s -> getPriceVeggie(s)).collect(Collectors.toList());
         price.forEach(a -> System.out.println(a));

         if (price.size() < 1)
         {
             driver.findElement(By.cssSelector("[aria-label=\"Next\"]")).click();
         }
        }while(price.size() < 1);

    }

    private String getPriceVeggie( WebElement s)
    {
       String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;
    }
}
