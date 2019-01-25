package com.Capgemini.framework.stepdefinitions;

import com.Capgemini.framework.pageobjects.cms.CartSummaryPage;
import com.Capgemini.framework.pageobjects.cms.HomePage;
import com.Capgemini.framework.pageobjects.cms.LoginPage;
import com.Capgemini.framework.pageobjects.cms.MyAccountPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.junit.Assert;

import java.io.IOException;

public class LoginSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    private CartSummaryPage cartSummaryPage;

    public LoginSteps(HomePage homePage, LoginPage loginPage, MyAccountPage myAccountPage, CartSummaryPage cartSummaryPage){
        this.homePage = homePage;
        this.loginPage = loginPage;
        this.myAccountPage = myAccountPage;
        this.cartSummaryPage = cartSummaryPage;
    }

    @Given("^I am logged in as a customer$")
    public void iAmLoggedInAsACustomer() throws Throwable {
        homePage.startHomepage();
        homePage.clickSignIn();
        loginPage.signInUser();
        Assert.assertTrue(myAccountPage.amIOnMyAccountPage());
        cartSummaryPage.deleteAllItemsInBag();
    }

    @And("^I log out and log back in again$")
    public void iLogOutAndLogBackIn() throws IOException {
        myAccountPage.clickSignOut();
        homePage.clickSignIn();
        loginPage.signInUser();
    }

    @And("^I enter my email to register$")
    public void iEnterMyEmailToRegister() throws IOException {
        loginPage.enterEmailToCreateAccount();
        loginPage.clickCreateAccountBtn();
    }
}
