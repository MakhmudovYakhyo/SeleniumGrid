package com.utils;

public class SeleniumActions {

    public static void goToUrl(String url){
        Driver.getDriver().get(url);
    }

}
