import Locators.LoginPageLocators;
import base.BasePage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import static Locators.HomePageLocators.LOGO;
import static Locators.LoginPageLocators.*;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getLogo() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(LOGO));
    }

    public void setSignInField(String email) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String successfulLogin(String email, String password) {
        setSignInField(email);
        setPassword(password);
        clickLoginButton();
        return "Welcome Raffi!";
    }

    public String loginAndGetErrorMessage(String email, String password) {
        setSignInField(email);
        setPassword(password);
        clickLoginButton();

        try {
            WebElement errorMessageElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE));
            return errorMessageElement.getText();
        } catch (TimeoutException e) {
            return "";
        }
    }

    public WebElement getSignupButton() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(SIGNUP_BUTTON));
    }

    public WebElement getForgotButton() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(FORGOT_PASSWORD));
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public String getWelcomeMessage() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(WELCOME_MESSAGE)).getText();
    }
}
