package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();
//        driver.findElement(By.xpath("//a[contains(text(),'Chennai (MAA)')]")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);
       // driver.findElement(By.xpath("(//a[@value=\"MAA\"])[2]")).click();
        Thread.sleep(2000);
        //driver.findElement(By.partialLinkText("Surat")).click();
        Thread.sleep(3000);
        //driver.findElement(By.partialLinkText("15")).click();
     String city = driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value=\"MAA\"]")).getText();
        System.out.println(city);
    }
}
