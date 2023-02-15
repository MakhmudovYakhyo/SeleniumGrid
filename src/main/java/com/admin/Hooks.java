package com.admin;

import com.utils.ConfigurationReader;
import com.utils.Driver;
import com.utils.SeleniumActions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class Hooks {

    @BeforeMethod
    public void setUp() {
        SeleniumActions.goToUrl(ConfigurationReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

}
