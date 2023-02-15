package com.runner;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Simple {

    WebDriver driver;

    @Test(priority = 1)
    public void setup() throws MalformedURLException {
        String nodeURL = "http://192.168.1.102:4444/wd/hub";
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.WIN10);
        System.setProperty("webdriver.chrome.driver", "D:\\Apps\\Programms\\Java\\chromedriver.exe");
        driver = new RemoteWebDriver(new URL(nodeURL), cap);
    }

    @Test(priority = 2)
    void login() {

        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        //close Fire fox
        driver.close();
    }


}