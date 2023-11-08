package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class EndToEndAssignment
{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.findElement(By.name("name")).sendKeys("Abdul-Razak Hussein");
        driver.findElement(By.name("email")).sendKeys("razzy@raztech.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("123455");
        driver.findElement(By.id("exampleCheck1")).click();
        Assert.assertTrue(driver.findElement(By.id("exampleCheck1")).isSelected());

        WebElement gender =  driver.findElement(By.id("exampleFormControlSelect1"));

        Select selectGender = new Select(gender);
        selectGender.selectByIndex(0);

        driver.findElement(By.id("inlineRadio2")).click();
        for(int i = 1; i<3; i++)
        {
            driver.findElement(By.cssSelector("input[type='date']")).sendKeys("4");
        }
        driver.findElement(By.cssSelector("input[type='date']")).sendKeys("2004");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText(), "× \nSuccess! The Form has been submitted successfully!.");
        System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
    }

    // ×
    //Success! The Form has been submitted successfully!.
}
