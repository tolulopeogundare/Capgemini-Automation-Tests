package com.Capgemini.framework.stepdefinitions;

import com.Capgemini.framework.models.CategoryDataModel;
import com.Capgemini.framework.pageobjects.cms.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.io.IOException;

public class AddToCartSteps {

    private CategoryPage categoryPage;
    private CartSummaryPage cartSummaryPage;
    private CategoryDataModel categoryDataModel;

    public AddToCartSteps(CategoryPage categoryPage, CartSummaryPage cartSummaryPage, CategoryDataModel categoryDataModel){
        this.categoryPage = categoryPage;
        this.cartSummaryPage = cartSummaryPage;
        this.categoryDataModel = categoryDataModel;
    }

    @And("^I add the most expensive dress to cart$")
    public void iAddTheMostExpensiveDressToCart() throws InterruptedException {
        categoryPage.selectMostExpensiveItem();
    }

    @And("^I verify the item added to cart is still added$")
    public void IVerifyItemAddedToCartIsStillAdded(){
        Assert.assertFalse(cartSummaryPage.isCartEmpty());
        Assert.assertTrue(cartSummaryPage.doesCartContainItemAdded(categoryDataModel.getItemPrice()));
    }
}
