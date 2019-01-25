package com.Capgemini.framework.stepdefinitions;

import com.Capgemini.framework.models.CategoryDataModel;
import com.Capgemini.framework.pageobjects.cms.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.io.IOException;

public class AddToCartSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    private CategoryPage categoryPage;
    private CartSummaryPage cartSummaryPage;
    private CategoryDataModel categoryDataModel;

    public AddToCartSteps(HomePage homePage, LoginPage loginPage,
                          MyAccountPage myAccountPage, CategoryPage categoryPage, CartSummaryPage cartSummaryPage,
                          CategoryDataModel categoryDataModel){
        this.homePage = homePage;
        this.loginPage = loginPage;
        this.myAccountPage = myAccountPage;
        this.categoryPage = categoryPage;
        this.cartSummaryPage = cartSummaryPage;
        this.categoryDataModel = categoryDataModel;
    }

    @Given("^I am logged in as a customer$")
    public void iAmLoggedInAsACustomer() throws Throwable {
        homePage.startHomepage();
        homePage.clickSignIn();
        loginPage.signInUser();
        Assert.assertTrue(myAccountPage.amIOnMyAccountPage());
        cartSummaryPage.deleteAllItemsInBag();
    }

    @When("^I navigate to dresses category$")
    public void iNavigateToCategory(){
        categoryPage.selectAMainCategory();
    }

    @And("^I add the most expensive dress to cart$")
    public void iAddTheMostExpensiveDressToCart() throws InterruptedException {
        categoryPage.selectMostExpensiveItem();
    }

    @And("^I log out and log back in again$")
    public void iLogOutAndLogBackIn() throws IOException {
        myAccountPage.clickSignOut();
        homePage.clickSignIn();
        loginPage.signInUser();
    }

    @And("^I verify the item added to cart is still added$")
    public void IVerifyItemAddedToCartIsStillAdded(){
        Assert.assertFalse(cartSummaryPage.isCartEmpty());
        Assert.assertTrue(cartSummaryPage.doesCartContainItemAdded(categoryDataModel.getItemPrice()));
    }
}
