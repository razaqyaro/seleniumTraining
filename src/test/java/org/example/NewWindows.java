package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
public class NewWindows
{
    @Test
    public void newWindowTest() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.TAB);

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> handleID = handles.iterator();
        String parentWindow = handleID.next();
        String childWindow = handleID.next();

        driver.switchTo().window(childWindow);
        driver.get("https://rahulshettyacademy.com");

        String courseName = driver.findElements(By.cssSelector("a[href='https://courses.rahulshettyacademy.com/p/core-java-for-automation-testers-interview-programs']")).get(1).getText();
        System.out.println(courseName);

        driver.switchTo().window(parentWindow);
        WebElement name = driver.findElement(By.cssSelector("[name='name']"));
        name.sendKeys(courseName);

        File file = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("C:\\Users\\Abdul-RazakHussein\\Desktop\\cicdPics\\logo.png"));

        Integer height = name.getRect().getDimension().getHeight();
        Integer width = name.getRect().getDimension().getWidth();

        System.out.println("Height : "+height);
        System.out.println("Width : "+width);
    }

    @Test
    public void NewWindowAndScreenshotAndDimension() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/angularpractice/");

        //Switching Window
        driver.switchTo().newWindow(WindowType.WINDOW);
        Set<String> handles=driver.getWindowHandles();
        Iterator<String> it=handles.iterator();

        String parentWindowId = it.next();
        String childWindow =it.next();
        driver.switchTo().window(childWindow);
        driver.get("https://rahulshettyacademy.com/");
        String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
                .get(1).getText();

        driver.switchTo().window(parentWindowId);
        WebElement name=driver.findElement(By.cssSelector("[name='name']"));
        name.sendKeys(courseName);

        //Screenshot
        File file=name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("logo.png"));
        //driver.quit();
        //GEt Height & Width
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());
    }


}
