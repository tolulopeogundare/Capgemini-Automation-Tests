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

    public HomepageSteps(HomePage homePage){
        this.homePage = homePage;
    }

    @Given("^I am on homepage$")
    public void iAmOnHomepage() throws Throwable {
        homePage.startHomepage();
    }

    @And("^I navigate to sign in page$")
    public void iNavigateToCreateAccountPage(){
        homePage.clickSignIn();
    }
}
