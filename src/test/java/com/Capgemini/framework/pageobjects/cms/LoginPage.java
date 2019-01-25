package com.Capgemini.framework.pageobjects.cms;

import com.Capgemini.framework.helpers.PageObjectUtility;
import com.Capgemini.framework.models.LoginPageDataModel;
import org.openqa.selenium.By;

import java.io.IOException;

public class LoginPage extends PageObjectUtility {

    private By createAccountEmail = By.id("email_create");
    private By createAccountBtn = By.cssSelector("#SubmitCreate > span");
    private By userEmail = By.id("email");
    private By userPassword = By.id("passwd");
    private By signInBtn = By.cssSelector("#SubmitLogin > span");
    private LoginPageDataModel loginPageDataModel;

    public LoginPage(LoginPageDataModel loginPageDataModel){
        this.loginPageDataModel = loginPageDataModel;
    }

    public void enterEmailToCreateAccount() throws IOException {
        String email = getDataFromLocale("email.prefix") + getRandomNumber() + "@gmail.com";
        waitForExpectedElement(createAccountEmail).clear();
        waitForElementVisible(createAccountEmail).sendKeys(email);
        loginPageDataModel.setNewAccountEmail(email);
    }

    public void clickCreateAccountBtn(){
        waitForExpectedElement(createAccountBtn).click();
    }

    public void signInUser() throws IOException {
        waitForElementVisible(userEmail).sendKeys(getDataFromLocale("user.email"));
        waitForElementVisible(userPassword).sendKeys(getDataFromLocale("user.password"));
        waitForElementVisible(signInBtn).click();
    }
}
