package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TransverseXpath {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Sibling - Child to parent transverse
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).click();
        System.out.println( driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
        driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).click();
        System.out.println( driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());

    }
}
// //header/div/button[1]/following-sibling::button[1]
// //header/div/button[1]/parent::div/parent::header