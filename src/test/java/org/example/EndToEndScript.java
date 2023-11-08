package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class EndToEndScript
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");


        driver.findElement(By.id("autosuggest")).sendKeys("Ind");
        Thread.sleep(3000);
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for(WebElement option : options)
        {
            if(option.getText().equals("India"))
            {
                option.click();
                break;
            }
        }

        driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@value=\"MAA\"])[2]")).click();
        driver.findElement(By.linkText("8")).click();

        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
        {
            System.out.println("It's disabled");
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertFalse(false);
        }
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        int i = 1;
        while(i < 5)
        {
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        driver.findElement(By.id("btnclosepaxoption")).click();

        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "USD");
        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());


        driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).click();
        driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).click();

        driver.findElement(By.id("ctl00_mainContent_chk_IndArm")).click();
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }
}
