package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Miscellaneous
{
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();
       // driver.manage().deleteCookieNamed("asf");

        //driver.manage().deleteCookieNamed("sessionKey");

        //Click on any link
        // login page - verify login url

        // Screenshot in selenium
        driver.get("https://google.com");

        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File("C:\\Users\\Abdul-RazakHussein\\Desktop\\cicdPics\\screenshot.png"));

    }
}
