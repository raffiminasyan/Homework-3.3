import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchTest extends BaseTest {
    @Test
    public void testFillSearch() {
        homePage = homePage.closePopup();
        homePage.clickSearchButton();
        homePage.fillSearch("Shampoo");
        wait.until(ExpectedConditions.titleContains("Shampoo"));
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Shampoo"), AssertionMessages.NO_PRODUCT_FOUND);
    }

    @Test
    public void testFillSearchNoResult() {
        homePage = homePage.closePopup();
        homePage.clickSearchButton();
        ProductList productList = homePage.fillSearch("random");
        Assert.assertEquals(productList.getNoResultsMessage(), AssertionMessages.NO_RESULT);
    }
}