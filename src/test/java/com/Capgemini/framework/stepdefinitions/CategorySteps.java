package com.Capgemini.framework.stepdefinitions;

import com.Capgemini.framework.pageobjects.cms.CategoryPage;
import cucumber.api.java.en.When;

public class CategorySteps {

    private CategoryPage categoryPage;

    public CategorySteps(CategoryPage categoryPage){
        this.categoryPage = categoryPage;
    }

    @When("^I navigate to dresses category$")
    public void iNavigateToCategory(){
        categoryPage.selectAMainCategory();
    }
}
