package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class AutoSuggestDropDown
{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();
        WebElement modal = driver.findElement(By.className("modalMain"));

        Actions action = new Actions(driver);
        action.moveToElement(getBodyElement(driver)).click().build().perform();

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/label/span")).click();
        WebElement from = driver.findElement(By.xpath("//input[@placeholder='From']"));
        Thread.sleep(2000);
        from.sendKeys("Sydney");
        Thread.sleep(2000);
        from.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        from.sendKeys(Keys.ENTER);
        Thread.sleep(2000);


    }
    private static WebElement getBodyElement(WebDriver driver)
    {
        return driver.findElement(By.tagName("body"));
    }
}
