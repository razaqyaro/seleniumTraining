package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoAutomation
{
    public static void main(String[] args)
    {
       // System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();


        driver.get("http://www.ebay.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("mobile");
        driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).click();
        driver.close();

    }
}
