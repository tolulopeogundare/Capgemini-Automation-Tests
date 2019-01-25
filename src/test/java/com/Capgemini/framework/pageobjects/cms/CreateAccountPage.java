package com.Capgemini.framework.pageobjects.cms;

import com.Capgemini.framework.helpers.PageObjectUtility;
import com.Capgemini.framework.models.LoginPageDataModel;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CreateAccountPage extends PageObjectUtility {

    private By mrTitle = By.id("id_gender1");
    private By personalInfoFirstName = By.id("customer_firstname");
    private By personalInfoLastName = By.id("customer_lastname");
    private By email = By.id("email");
    private By password = By.id("passwd");
    private By dobDay = By.cssSelector("#days");
    private By dobMonth = By.id("months");
    private By dobYear = By.id("years");
    private By addressFirstName = By.id("firstname");
    private By addressLastName = By.id("lastname");
    private By company = By.id("company");
    private By addressLine1 = By.id("address1");
    private By addressLine2 = By.id("address2");
    private By city = By.id("city");
    private By state = By.cssSelector("#id_state");
    private By postalcode = By.id("postcode");
    private By country = By.cssSelector("#id_country");
    private By homePhone = By.id("phone");
    private By mobilePhone = By.id("phone_mobile");
    private By registerBtn = By.cssSelector("#submitAccount > span");
    private LoginPageDataModel loginPageDataModel;

    public CreateAccountPage(LoginPageDataModel loginPageDataModel){
        this.loginPageDataModel = loginPageDataModel;
    }

    private void clickMrTitle(){ waitForElementVisible(mrTitle).click(); }

    public void addRegistrationInformation() throws IOException, InterruptedException {
        List<String> dob = Arrays.asList(getDataFromLocale("dob").split("/"));
        clickMrTitle();
        registrationHelper(personalInfoFirstName, "firstname");
        registrationHelper(personalInfoLastName, "lastname");
        Assert.assertEquals(getAttributeFromElement(email, "value"), loginPageDataModel.getNewAccountEmail());
        registrationHelper(password, "password");
        selectByValue(waitForExpectedElement(dobDay), dob.get(0));
        selectByValue(waitForExpectedElement(dobMonth), dob.get(1));
        selectByValue(waitForExpectedElement(dobYear), dob.get(2));
        waitForElementVisible(addressFirstName);
        waitForElementVisible(addressFirstName);
        registrationHelper(company, "company");
        registrationHelper(addressLine1, "address.line1");
        registrationHelper(addressLine2, "address.line2");
        registrationHelper(city, "address.city");
        selectByText(waitForExpectedElement(state), getDataFromLocale("address.state"));
        registrationHelper(postalcode, "address.postalcode");
        selectByText(waitForExpectedElement(country), getDataFromLocale("country"));
        registrationHelper(mobilePhone, "mobile");
    }

    private void registrationHelper(By by, String key) throws IOException {
        waitForElementVisible(by).sendKeys(getDataFromLocale(key));
    }

    public void clickRegisterBtn(){ waitForElementVisible(registerBtn).click(); }

















}
