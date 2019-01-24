package com.Capgemini.framework.pageobjects.cms;

import com.Capgemini.framework.helpers.PageObjectUtility;
import org.openqa.selenium.By;

public class HomePage extends PageObjectUtility {

    private By signIn = By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a");
    private By searchBox = By.cssSelector("#search_query_top");
    private By submitSearch = By.cssSelector("#searchbox > button");
    private By cartSummary = By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a");
    private By myAccount = By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(1) > a > span");

    public void clickSignIn(){ waitForExpectedElement(signIn).click(); }

    public void searchItem(String itemName){
        startActions().click(waitForExpectedElement(searchBox)).build().perform();
        waitForExpectedElement(searchBox).clear();
        waitForExpectedElement(searchBox).sendKeys(itemName);
        waitForExpectedElement(submitSearch).click();
    }

    public void clickCartSummary(){
        clickElementUsingJavascriptExecutor(waitForExpectedElement(cartSummary));
    }

    public void clickMyAccount(){ waitForExpectedElement(myAccount).click(); }
}
