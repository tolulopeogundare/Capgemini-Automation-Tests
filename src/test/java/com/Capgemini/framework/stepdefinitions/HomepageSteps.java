package com.Capgemini.framework.stepdefinitions;

import com.Capgemini.framework.pageobjects.cms.CreateAccountPage;
import com.Capgemini.framework.pageobjects.cms.HomePage;
import com.Capgemini.framework.pageobjects.cms.LoginPage;
import com.Capgemini.framework.pageobjects.cms.MyAccountPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.After;
import org.junit.Assert;

import java.io.IOException;

public class HomepageSteps {

    private HomePage homePage;
    private CreateAccountPage createAccountPage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;

    public HomepageSteps(HomePage homePage, CreateAccountPage createAccountPage, LoginPage loginPage, MyAccountPage myAccountPage){
        this.homePage = homePage;
        this.createAccountPage = createAccountPage;
        this.loginPage = loginPage;
        this.myAccountPage = myAccountPage;
    }

    @Given("^I am on homepage$")
    public void iAmOnHomepage() throws Throwable {
        homePage.startHomepage();
    }

    @And("^I navigate to sign in page$")
    public void iNavigateToCreateAccountPage(){
        homePage.clickSignIn();
    }

    @And("^I enter my email to register$")
    public void iEnterMyEmailToRegister() throws IOException {
        loginPage.enterEmailToCreateAccount();
        loginPage.clickCreateAccountBtn();
    }

    @And("^I complete registration details$")
    public void iEnterMyRegistrationDetails() throws IOException, InterruptedException {
        createAccountPage.addRegistrationInformation();
    }

    @And("^I click register$")
    public void iClickRegister(){
        createAccountPage.clickRegisterBtn();
    }

    @Then("I verify I am taken to My Account page")
    public void iVerifyIamTakenToMyAccountPage() throws IOException, InterruptedException {
        Assert.assertTrue(myAccountPage.amIOnMyAccountPage());
        myAccountPage.clickSignOut();
    }
}
