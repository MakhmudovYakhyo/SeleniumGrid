package com.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    /*
     * Making our driver "driver" instance private, so that it is not reachable from outside the class
     * We make it static, because we want it to run before anything else, also we will use it in static method
     * */
    private static WebDriver driver;

    /*
     * Creating a private constructor, so we are closing access to the object this class from outside any class
     * */
    private Driver() {
    }

    /*
     * Create re-usable utility method which will return some driver instance when we call it.
     * */
    public static WebDriver getDriver() {
        if (driver == null) { // if driver/browser was never opened

            String browserType = ConfigurationReader.getProperty("browser");

            //String nodeUrl = "http://localhost:4444";
            String nodeUrl = "http://192.168.1.102:4444/wd/hub";

            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setBrowserName("chrome");
            capabilities.setPlatform(Platform.WIN10);

            /*
             * Depending on the browserType our switch statement will determine to open specific type of browser/driver
             * */
            switch (browserType) {
                case "chrome" : {
                    //WebDriverManager.chromedriver().setup();
                    System.setProperty("webdriver.chrome.driver","D:\\Apps\\Programms\\Java\\chromedriver.exe");
                    break;
                }
                case "firefox" : {
                    WebDriverManager.firefoxdriver().setup();
                    break;
                }
            }

            try {
                driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        /*
         * Some driver instance will be returned every time we call Driver.getDriver() method
         * */
        return driver;
    }

    public static void closeDriver(){
        if (driver != null) {
            driver.quit(); // this line will kill the session, value will not be null
            driver = null;
        }
    }
}
