package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Scope
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
       // ChromeDriver driver1 = new ChromeDriver();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qaclickacademy.com/practice.php");
        // Get the count of links on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        // Get the count of links on the footer section
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        int linkSizeFooter =  footerDriver.findElements(By.tagName("a")).size();
        System.out.println(linkSizeFooter);

        WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        int columnLinks = columnDriver.findElements(By.tagName("a")).size();
        System.out.println(columnLinks);

        // Click on each link in the column and check if the pages are opening
        for(int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++)
        {
            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
            Thread.sleep(5000);


        }
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> tabs = windows.iterator();
        while(tabs.hasNext())
        {
            driver.switchTo().window(tabs.next());
            System.out.println(driver.getTitle());
            System.out.println(driver.manage());
        }

    }
}
