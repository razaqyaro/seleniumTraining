package org.example;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SSLCheck
{
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipaddress: 4444");
        options.setCapability("proxy", proxy);
        options.setAcceptInsecureCerts(true);
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");

       // block all pop up windows
        options.setExperimentalOption("excludeSwitches",
                Arrays.asList("disable-popup-blocking"));
        WebDriver driver = new ChromeDriver(options);

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", "/directory/path");
        options.setExperimentalOption("prefs", prefs);

// FirefoxOptions options1 = new FirefoxOptions();

// options1.setAcceptInsecureCerts(true);

// EdgeOptions options2 = new EdgeOptions();
        driver.get("https://expired.badssl.com/");

    }
}
