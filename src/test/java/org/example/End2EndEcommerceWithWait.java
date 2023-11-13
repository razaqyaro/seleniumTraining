package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class End2EndEcommerceWithWait
{
    public static void main(String[] args) {

        String name = "rahulshettyacademy";
        String password = "learning";
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.rahulshettyacademy.com/loginpagePractise");
        logIn(driver, name, password);
        addProduct(driver);
        checkout(driver);

    }


    private static void logIn(WebDriver driver, String name, String password)
    {
        driver.findElement(By.id("username")).sendKeys(name);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector(".customradio:nth-child(2)")).click();
        WebElement userDropDown = driver.findElement(By.cssSelector("select.form-control"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click();
        Select userType = new Select(userDropDown);
        userType.selectByIndex(2);
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
    }

    private static void addProduct( WebDriver driver)
    {
        List<WebElement> addButtons = driver.findElements(By.cssSelector("button.btn.btn-info"));
        for(WebElement button : addButtons)
        {
            if(button.getText().contains("Add"))
            {
               button.click();
            }
        }
    }

    private static void checkout(WebDriver driver)
    {
        driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();
    }


}
