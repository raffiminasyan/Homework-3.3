import Locators.HomePageLocators;
import base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Locators.HomePageLocators.*;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchTitle() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_TITLE));
    }


    public HomePage closePopup() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(POPUP_MODAL));
        driver.findElement(CLOSE_POPUP).click();
        return this;
//        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(POPUP_MODAL));
    }

    public LoginPage clickSignIn() {
        WebElement clickSign = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(SIGN_IN_BUTTON));
        clickSign.click();
        return new LoginPage(driver);
    }

    public void clickBestSellersLink() {
        WebElement bestSellersLink = driver.findElement(HomePageLocators.BEST_SELLERS_LINK);
        bestSellersLink.click();
    }

    public ProductList fillSearch(String product) {
        WebElement searchInput = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(SEARCH_INPUT));
        searchInput.sendKeys(product + Keys.ENTER);
        return new ProductList(driver);
    }

    public void clickGiftingLink() {
        WebElement giftingLink = driver.findElement(HomePageLocators.GIFTING_LINK);
        giftingLink.click();
    }

    public void clickSearchButton() {
        WebElement searchButton = driver.findElement(SEARCH_BUTTON);
        searchButton.click();
    }

    public LoginPage goToProfile() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(PROFILE_BUTTON)).click();
        return new LoginPage(driver);
    }
}
