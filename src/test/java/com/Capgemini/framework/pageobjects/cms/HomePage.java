package com.Capgemini.framework.pageobjects.cms;

import com.Capgemini.framework.helpers.PageObjectUtility;
import org.openqa.selenium.By;

public class HomePage extends PageObjectUtility {

    private By signIn = By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a");
    private By myAccount = By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(1) > a > span");

    public void clickSignIn(){ waitForExpectedElement(signIn).click(); }

    public void clickMyAccount(){ waitForExpectedElement(myAccount).click(); }
}
