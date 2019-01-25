package com.Capgemini.framework.pageobjects.cms;

import com.Capgemini.framework.helpers.PageObjectUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class MyAccountPage extends PageObjectUtility {

    private By myAccountHeader = By.cssSelector("");
    private By listMyAccountTopics = By.cssSelector("#center_column > div > div > ul > li> a > span");
    private By customerName = By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(1) > a > span");
    private By signOut = By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(2) > a");
    private By cart = By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a > b");

    public List<WebElement> getMyAccountTopics(){ return presenceOfAllElementsLocatedBy(listMyAccountTopics); }

    public boolean amIOnMyAccountPage() throws IOException, InterruptedException {
        sleep(4);
        boolean result = true;
        for(WebElement element : getMyAccountTopics()){
            result &=  waitForElementVisibility(element).isDisplayed();
        }
        result &= waitForElementVisible(customerName).getText().equals(getDataFromLocale("firstname") + " " + getDataFromLocale("lastname"));
        result &= waitForElementVisible(signOut).getText().trim().equals("Sign out");
        return result;
    }

    public void clickSignOut(){ waitForElementVisible(signOut).click(); }

    public void clickCartBtn(){ waitForElementVisible(cart).click(); }

}
