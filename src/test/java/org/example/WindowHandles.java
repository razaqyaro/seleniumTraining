package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WindowHandles
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> windows = driver.getWindowHandles();
//        Iterator<String> IDs = windows.iterator();
//        String parentID = IDs.next();
//        String childID = IDs.next();
//        driver.switchTo().window(childID);
        List<String> windowHandlesList = new ArrayList<>(windows);
        String desiredWindowHandle = windowHandlesList.get(1);

        driver.switchTo().window(desiredWindowHandle);
        String textContainingEmail = driver.findElement(By.cssSelector(".im-para.red")).getText();
        System.out.println(textContainingEmail);
                // Split the text using space as the delimiter
                String[] words = textContainingEmail.split("\\s+");
        System.out.println(words.length);
        System.out.println(words[0]);
        System.out.println(words[1]);
        String emailExtracted = null;
        // Iterate through the words and check if they match the email pattern
                for (String word : words) {
                    if (word.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}")) {
                        System.out.println(word);
                        emailExtracted = word;
                        break;
                    }
                }
        driver.switchTo().window(windowHandlesList.get(0));
        driver.findElement(By.id("username")).sendKeys(emailExtracted);
    }
}
