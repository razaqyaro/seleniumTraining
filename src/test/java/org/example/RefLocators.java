package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

public class RefLocators
{
        public static void main(String[] args) throws InterruptedException
        {
            System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            String password = getPassword(driver);
            driver.get("https://rahulshettyacademy.com/locatorspractice/");
            driver.findElement(By.id("inputUsername")).sendKeys("rahul");
            driver.findElement(By.name("inputPassword")).sendKeys("hello123");
            driver.findElement(By.className("signInBtn")).click();
            System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
            driver.findElement(By.linkText("Forgot your password?")).click();
            Thread.sleep(1000);//
            driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
            driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");
            driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
            driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");
            driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");
            driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

            System.out.println(driver.findElement(By.cssSelector("form p")).getText());
            Thread.sleep(2000);
            driver.findElement(By.className("go-to-login-btn")).click();
            String name = "Abdul-Razak";
            driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
            driver.findElement(By.name("inputPassword")).clear();
            driver.findElement(By.name("inputPassword")).sendKeys((password));
            driver.findElement(By.id("chkboxOne")).click();
            driver.findElement(By.className("signInBtn")).click();
            Thread.sleep(2000);
            String successMessage = driver.findElement(By.tagName("p")).getText();
            System.out.println(successMessage);
            Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
            Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+name+",");
            //driver.findElement(By.xpath("//button[text() ='Log Out']")).click();
        }
        public static String getPassword(WebDriver driver) throws InterruptedException {
            driver.get("https://rahulshettyacademy.com/locatorspractice");
            driver.findElement(By.linkText("Forgot your password?")).click();
            Thread.sleep(1000);
            driver.findElement(By.name("inputPassword")).sendKeys("123345");
            driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
            String passwordText = driver.findElement(By.cssSelector("form p")).getText();
            // Please use temporary password 'rahulshettyacademy' to Login.
            String[] passwordArray = passwordText.split("'");
            // 0th index - Please use temporary password
            // 1st index - rahulshettyacademy' to Login.
            String[] newPasswordText = passwordArray[1].split("'");
            //0th index - rahulshettyacademy
            // 1st index - to Login.
            String password = newPasswordText[0];

            return password;

        }



    }



