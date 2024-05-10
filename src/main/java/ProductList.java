import Locators.ProductListPageLocators;
import base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;

import static Locators.ProductPageLocator.*;

public class ProductList extends BasePage {
    public ProductList(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchTitle() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(ProductListPageLocators.FIND_TITLE));
    }

    public ProductPage getProduct() {
        WebElement product = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(ProductListPageLocators.PRODUCT));
        product.click();
        return new ProductPage(driver);
    }

    public ProductList searchProduct(String search) {
        WebElement searchField = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(ProductListPageLocators.SEARCH_FIELD));
        searchField.click();
        searchField.clear();
        searchField.sendKeys(search + Keys.ENTER);
        return this;
    }

    public WebElement getProductTitle() {
        WebElement productTitle = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(ProductListPageLocators.PRODUCT_TITLE));
        return productTitle;
    }

    public String getNoResultsMessage() {
        WebElement container = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(ProductListPageLocators.NO_RESULT_CONTAINER));
        return container.getText();
    }

}