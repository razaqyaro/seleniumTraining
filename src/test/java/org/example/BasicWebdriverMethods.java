package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class BasicWebdriverMethods
{
        public static String browser = "chrome";
        public static WebDriver driver;
        public static void main(String[] args)
        {
            if(browser.equals("chrome"))
            {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            else if(browser.equals("firefox"))
            {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            else if(browser.equals("edge"))
            {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            driver.get("https://www.saucedemo.com/");
            driver.manage().window().maximize();

            String currentUrl = driver.getCurrentUrl();
            System.out.println(currentUrl);

            String title = driver.getTitle();
            System.out.println(title);

            String pageSource = driver.getPageSource();
            System.out.println(pageSource);

            //driver.navigate().to("http://amalitech.org");

            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

            List<WebElement> items =  driver.findElements(By.className("inventory_item"));
            System.out.println(items);

            driver.navigate().to("https://www.sugarcrm.com");
            driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
            String windowHandle = driver.getWindowHandle();
            System.out.println(windowHandle);

            driver.findElement(By.linkText("GET A DEMO")).click();
            Set<String> windowHandles = driver.getWindowHandles();
            System.out.println(windowHandles);
            /**
             * get(): driver.get()
             * getCurrentUrl(): driver.getCurrentUrl(), gets the current url that the browser is opened
             * getTitle(): driver.getTitle(), Gets the title of the page
             * findElements(): driver.findElements(), Finds all elements on the page by the mechanism stated
             * findElement(): driver.findElement(), Finds only the first element
             * getPageSource()
             * close()
             * quit()
             * navigate()
             * manage()
             * sendKeys()
             * clear()
             * click()
             * getAttribute()
             * getCSSValue()
             * getLocation()
             * getSize()
             * getTagName()
             * getText()
             * isDisplayed()
             * isSelected()
             *
             */

        }
    }


