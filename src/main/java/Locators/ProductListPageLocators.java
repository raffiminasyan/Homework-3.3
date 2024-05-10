package Locators;

import org.openqa.selenium.By;

public class ProductListPageLocators {
    public static final By FIND_TITLE = By.xpath("//p[contains(text(),\"Find what you're looking for.\")]");
    public static final By PRODUCT = By.xpath("//body/div[@id='__next']/main[1]/div[1]/div[1]");
    public static final By SEARCH_FIELD = By.xpath("//body[1]/div[1]/main[1]/header[1]/form[1]/input[1]");
    public static final By PRODUCT_TITLE = By.xpath("//h3[contains(text(),'Oribe The Cleanse Clarifying Shampoo')]");
    public static final By NO_RESULT_CONTAINER = By.xpath("//p[contains(text(),'No results')]");
}
