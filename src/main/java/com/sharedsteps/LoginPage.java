package com.sharedsteps;

import com.pages.EtsyLoginPage;
import com.utils.SeleniumActions;

public class LoginPage {

    public static void login( String username, String password){

        EtsyLoginPage loginPage = new EtsyLoginPage();

        loginPage.usernameText.sendKeys(username);
        loginPage.passwordText.sendKeys(password);
        loginPage.loginButton.click();
    }

}
