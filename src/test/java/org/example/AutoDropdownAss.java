package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoDropdownAss
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");


        WebDriver driver = new ChromeDriver();

        driver.get("http://qaclickacademy.com/practice.php");

        driver.findElement(By.id("autocomplete")).sendKeys("ind");

        Thread.sleep(2000);

        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);

        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);

        System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));




    }
}
