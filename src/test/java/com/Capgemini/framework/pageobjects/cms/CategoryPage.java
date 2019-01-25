package com.Capgemini.framework.pageobjects.cms;

import com.Capgemini.framework.helpers.PageObjectUtility;
import com.Capgemini.framework.models.CategoryDataModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CategoryPage extends PageObjectUtility {

    private By mainCategories = By.cssSelector("#block_top_menu > ul > li > a");
    private By listItemsPrices = By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[1]/span[1]");
    private By listItemsAddToCartBtn = By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]/span");
    private By listMainCategorySelection = By.cssSelector("#block_top_menu > ul > li");
    private CategoryDataModel categoryDataModel;

    private List<WebElement> getMainCategoryList(){ return  visibilityOfAllElementBy(mainCategories); }

    private List<WebElement> getListOfItemsPrices(){ return presenceOfAllElementsLocatedBy(listItemsPrices); }

    private List<WebElement> getListOfAddToCartBtn(){ return presenceOfAllElementsLocatedBy(listItemsAddToCartBtn); }

    private List<WebElement> getListOfMainCategorySelection(){ return visibilityOfAllElementBy(listMainCategorySelection); }

    public CategoryPage(CategoryDataModel categoryDataModel){
        this.categoryDataModel = categoryDataModel;
    }

    public void selectAMainCategory(){
        startActions().moveToElement(getListOfMainCategorySelection().get(1)).build().perform();
        getListOfMainCategorySelection().get(1).click();
    }

    public void selectMostExpensiveItem() throws InterruptedException {
        int index = getIndexOfMostExpensiveItem();
        WebElement mostExpensiveItem = getListOfAddToCartBtn().get(index);
        scrollIntoView(mostExpensiveItem);
        startActions().click(mostExpensiveItem).build().perform();
    }

    private int getIndexOfMostExpensiveItem() {
        Double mostExpensive = 0.00;
        int index = -1;
        for(int i = 0; i < getListOfItemsPrices().size(); i++){
            Double itemPrice = trimDollarAndConvertToDouble(getListOfItemsPrices().get(i).getText().trim());
            if(itemPrice > mostExpensive){
                mostExpensive = itemPrice;
                index = i;
            }
        }
        categoryDataModel.setItemPrice(mostExpensive);
        return index;
    }
}
