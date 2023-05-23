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

public class WorkingWithWebElements {
    public static String browser = "chrome";
    public static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.get("https://www.sugarcrm.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
        driver.findElement(By.linkText("GET A DEMO")).click();

        driver.findElement(By.name("firstname")).sendKeys("Testing");
        driver.findElement(By.name("firstname")).clear();
        String classAttribute = driver.findElement(By.name("firstname")).getAttribute("class");
        System.out.println(classAttribute);

        System.out.println(driver.findElement(By.xpath("//*[@id=\"field1\"]/div")).getCssValue("text-transform"));
        System.out.println(driver.findElement(By.xpath("//*[@id=\"field1\"]/div")).getSize());
        System.out.println(driver.findElement(By.xpath("//*[@id=\"field1\"]/div")).getLocation());
        System.out.println(driver.findElement(By.xpath("//*[@id=\"field1\"]/div")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@id=\"field1\"]/div")).getTagName());
        System.out.println(driver.findElement(By.xpath("//*[@id=\"field1\"]/div")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//*[@id=\"field1\"]/div")).isEnabled());
        System.out.println(driver.findElement(By.xpath("//*[@id=\"field1\"]/div")).isSelected());









    }
}

//driver.navigate().to("http://amalitech.org");
/*
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
