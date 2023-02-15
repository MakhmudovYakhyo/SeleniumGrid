package com.pages;

import com.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EtsyLoginPage {

    public EtsyLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "join_neu_email_field")
    public WebElement usernameText;

    @FindBy(id = "join_neu_password_field")
    public WebElement passwordText;

    @FindBy(xpath = "//button[@class='wt-btn wt-btn--primary wt-width-full']")
    public WebElement loginButton;

}
