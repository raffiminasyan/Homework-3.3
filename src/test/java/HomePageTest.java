import Locators.HomePageLocators;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePageTest extends BaseTest {

    @Test
    public void testBestSellersLink() {
        homePage = homePage.closePopup();
        homePage.clickBestSellersLink();
        wait.until(ExpectedConditions.titleContains("Best Sellers"));
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Best Sellers"), AssertionMessages.BEST_SELLERS_PAGE_NOT_DISPLAYED);
    }

    @Test
    public void testGiftingLink() {
        homePage = homePage.closePopup();
        homePage.clickGiftingLink();
        wait.until(ExpectedConditions.titleContains("Gifting"));
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Gifting"), AssertionMessages.GIFTING_PAGE_NOT_DISPLAYED);
    }

    @Test
    public void testSearchButtonFunctionality() {
        homePage = homePage.closePopup();
        homePage.clickSearchButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.SEARCH_BUTTON));
        WebElement searchInput = driver.findElement(HomePageLocators.SEARCH_BUTTON);
        homePage.clickSearchButton();
        WebElement searchTitle = homePage.getSearchTitle();
        Assert.assertTrue(searchInput.isDisplayed(), AssertionMessages.SEARCH_NOT_VISIBLE);
        Assert.assertTrue(searchTitle.isDisplayed(), AssertionMessages.SEARCH_NOT_VISIBLE);
        Assert.assertEquals(searchTitle.getText(), AssertionMessages.SEARCH_NOT_VISIBLE);
    }

    @Test
    public void allPomTest() {
        homePage = homePage.closePopup();
        homePage.clickSearchButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.SEARCH_BUTTON));
        homePage.clickSearchButton();
        ProductList productList = homePage.fillSearch("mask");
        productList.searchProduct("Shampoo");
        Assert.assertEquals(productList.getSearchTitle().getText(), AssertionMessages.SEARCH_ITEM);
        ProductPage productPage = productList.getProduct();
        Assert.assertEquals(productPage.info(), AssertionMessages.INFO);
    }
}

