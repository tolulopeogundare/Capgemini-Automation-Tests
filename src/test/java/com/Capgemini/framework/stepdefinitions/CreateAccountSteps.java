package com.Capgemini.framework.stepdefinitions;

import com.Capgemini.framework.pageobjects.cms.CreateAccountPage;
import com.Capgemini.framework.pageobjects.cms.MyAccountPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.io.IOException;

public class CreateAccountSteps {

    private CreateAccountPage createAccountPage;
    private MyAccountPage myAccountPage;

    public CreateAccountSteps(CreateAccountPage createAccountPage, MyAccountPage myAccountPage){
        this.createAccountPage = createAccountPage;
        this.myAccountPage = myAccountPage;
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
