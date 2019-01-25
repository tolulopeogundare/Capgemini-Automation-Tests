package com.Capgemini.framework.pageobjects.cms;

import com.Capgemini.framework.helpers.PageObjectUtility;
import org.assertj.core.util.Lists;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartSummaryPage extends PageObjectUtility {

    private By listDeleteCartItems = By.cssSelector("#cart_summary > tbody > tr > td:nth-child(7) > div > a > i");
    private By cartSummary = By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a");
    private By cartItemCount = By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a > span.ajax_cart_no_product");
    private By cartItemUnitPrices = By.cssSelector("#cart_summary > tbody > tr > td:nth-child(4) > span ");

    public List<WebElement> getCartItemListPrices(){ return visibilityOfAllElementBy(cartItemUnitPrices); }

    public List<WebElement> getDeleteItemList(){
        return visibilityOfAllElementBy(listDeleteCartItems);
    }

    public void deleteAllItemsInBag() throws InterruptedException {
        if(!waitForElementVisible(cartItemCount).getText().trim().equals("(empty)")){
            for(WebElement element : getDeleteItemList()){
                sleep(1);
                element.click();
            }
        }
    }

    public boolean isCartEmpty(){
        return waitForElementVisible(cartItemCount).getText().trim().equals("(empty)");
    }

    public boolean doesCartContainItemAdded(Double price){
        return trimDollarAndConvertToDouble(getCartItemListPrices().get(0).getText().trim()).equals(price) && getCartItemListPrices().size()==1;
    }

}
