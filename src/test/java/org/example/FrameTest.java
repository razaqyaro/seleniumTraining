package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest
{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable");
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        Actions drag = new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        // driver.switchTo().frame(0);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        drag.dragAndDrop(source, target)
                .build()
                .perform();

        driver.switchTo().defaultContent();  // Brings you back to normal ( outside frame )
    }
}
