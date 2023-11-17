package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenLinks
{
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
       List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert softAssert = new SoftAssert();
       for(WebElement link : links)
       {
           String url_Link = link.getAttribute("href");
           HttpURLConnection connection = (HttpURLConnection) new URL(url_Link).openConnection();
           connection.setRequestMethod("HEAD");
           connection.connect();
           Integer responseCode = connection.getResponseCode();
           System.out.println(responseCode);

           softAssert.assertTrue(responseCode < 400, "The link with Text "+link.getText()+" is broken with code "+responseCode);

       }
       softAssert.assertAll();
        String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("HEAD");
        connection.connect();
        Integer responseCode = connection.getResponseCode();
        System.out.println(responseCode);

        String brokenUrl = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
        HttpURLConnection conn = (HttpURLConnection) new URL(brokenUrl).openConnection();
        conn.setRequestMethod("HEAD");
        conn.connect();
        Integer statusCode = conn.getResponseCode();
        System.out.println(statusCode);


    }
}
