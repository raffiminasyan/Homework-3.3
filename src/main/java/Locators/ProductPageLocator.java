package Locators;

import org.openqa.selenium.By;

public class ProductPageLocator {

    public static final By ADD_TO_CART_LOCATOR = By.cssSelector("button.button.button-primary[type=\"button\"]");
    public static final By PRODUCT_TITLE_ELEMENT = By.cssSelector("h1.mb-4.product.title");

    public static final By DESCRIPTION_ELEMENT = By.cssSelector("div.description-wrapper.line-clamp-4");
    public static final By PRICE_ELEMENT = By.cssSelector("p.mb-8.text-3xl");


}
