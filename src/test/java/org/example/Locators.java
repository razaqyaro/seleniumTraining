package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Locators
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
       // driver.findElement(By.id("user-name")).sendKeys("Testing");
       // driver.findElement(By.className("form_input")).sendKeys("Testing");
       // driver.findElement(By.cssSelector("#password")).sendKeys("Testing");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        WebElement usernameField = driver.findElement(with(By.tagName("input")).above(passwordField));
        usernameField.sendKeys("standard_user");
        WebElement button = driver.findElement(with(By.tagName("input")).below(passwordField));
        button.click();

        // relative locator
        /*
        * above(), below(), toLeftOf(),toRightOf(), near()
        * By emailLocator = RelativeLocator.with(By.tagName("input")).above(By.id("password"));
        * By passwordLocator = RelativeLocator.with(By.tagName("input")).below(By.id("email"));
        * By cancelLocator = RelativeLocator.with(By.tagName("button")).toLeftOf(By.id("submit"));
        * By submitLocator = RelativeLocator.with(By.tagName("button")).toRightOf(By.id("cancel"));
        * By emailLocator = RelativeLocator.with(By.tagName("input")).near(By.id("lbl-email"));  // at most 50px away
        * By submitLocator = RelativeLocator.with(By.tagName("button")).below(By.id("email")).toRightOf(By.id("cancel")); // chaining relative loactors
        *
        * */
    }
}
