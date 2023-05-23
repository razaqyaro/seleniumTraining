package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown
{
    public static String browser = "chrome";
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
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
        Thread.sleep(3000);
        WebElement dropdown = driver.findElement(By.id("how-select"));

        Select select = new Select(dropdown);

        select.selectByIndex(2);
        Thread.sleep(3000);
        select.selectByValue("Events");
        Thread.sleep(3000);
        select.selectByVisibleText("Word of Mouth/Referral");
    }
}
