package com.Capgemini.framework.helpers;


import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.Capgemini.framework.helpers.WebDriverHelper.buildChromeBrowser;
import static com.Capgemini.framework.helpers.WebDriverHelper.getWebDriver;

public class PageObjectUtility {

    @Getter
    protected WebDriverWait wait;
    @Getter
    protected WebDriver driver;


    protected PageObjectUtility(){
        this.driver = WebDriverHelper.getWebDriver();
        this.wait = new WebDriverWait(driver, 30);
    }

    protected WebElement waitForExpectedElement(final By by){
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElementVisibility(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getAttributeFromElement(By locator, String attribute) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getAttribute(attribute);
    }

    public void sleep(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    public WebElement waitForElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void startHomepage() throws Throwable {
        if(driver==null){ driver = getWebDriver(); }
        driver.navigate().to(getDataFromLocale("homepage"));
    }

    public Actions startActions(){
        Actions act = new Actions(driver);
        return act;
    }

    public List<WebElement> visibilityOfAllElementsLocatedBy(final By by){
        return wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void selectByText(WebElement ele, String text){
        ele.click();
        Select selectFromDropdown = new Select(ele);
        selectFromDropdown.selectByVisibleText(text);
    }

    public void selectByValue(WebElement ele, String value){
        ele.click();
        Select selectFromDropdown = new Select(ele);
        selectFromDropdown.selectByValue(value);
    }

    public void clickElementUsingJavascriptExecutor(WebElement ele){
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", ele);
    }

    public List<WebElement> presenceOfAllElementsLocatedBy(final By by){
        return (wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by)));
    }

    public List<WebElement> visibilityOfAllElementBy(By by){
        return  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public Double trimDollarAndConvertToDouble(String value){
        String Value = value.replace("$", "");
        return Double.parseDouble(Value);
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor je = (JavascriptExecutor) getDriver();
        je.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void selectByIndex(WebElement ele, int index){
        Select selectFromDropdown = new Select(ele);
        selectFromDropdown.selectByIndex(index);
    }

    public String getElementText(WebElement element){
        return waitForElementVisibility(element).getText();
    }

    public String getRandomNumber(){
        Random rand = new Random();
        return String.valueOf(rand.nextInt(9000000));
    }

    public String getDataFromLocale(String key) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\locales\\general.properties"));
        return prop.getProperty(key);
    }
}
