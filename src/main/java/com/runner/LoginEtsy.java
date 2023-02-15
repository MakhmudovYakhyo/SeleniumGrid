package com.runner;

import com.admin.Hooks;
import com.sharedsteps.LoginPage;
import com.utils.ConfigurationReader;
import org.testng.annotations.Test;

public class LoginEtsy extends Hooks {

    @Test
    public static void loginToEtsy() {

        LoginPage.login(
                ConfigurationReader.getProperty("username"),
                ConfigurationReader.getProperty("password")
        );

    }
}