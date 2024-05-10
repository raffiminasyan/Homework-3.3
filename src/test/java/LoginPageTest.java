import org.testng.Assert;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoginPageTest extends BaseTest {
    @Test
    public void testSuccessfulLogin() {
        homePage = homePage.closePopup();
        LoginPage loginPage = homePage.goToProfile();
        Assert.assertTrue(loginPage.getForgotButton().getText().contains(AssertionMessages.FORGOT_PASSWORD));
        loginPage.setSignInField("raffiminasyan@gmail.com");
        loginPage.setPassword("QWERTY123");
        loginPage.clickLoginButton();
        Assert.assertNotNull(loginPage.getWelcomeMessage());
        Assert.assertEquals(loginPage.getWelcomeMessage(), AssertionMessages.WELCOME_MESSAGE);
        loginPage.getLogo().click();
    }

    @Test
    public void testUnsuccessfulLogin() {
        homePage = homePage.closePopup();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setSignInField("raffiminasyan@gmail.com");
        loginPage.setPassword("wrong password");
        loginPage.clickLoginButton();
        Assert.assertNotNull(loginPage.getErrorMessage());
        Assert.assertEquals(loginPage.getErrorMessage(), AssertionMessages.UNSUCCESSFUL_SIGN_IN_MESSAGE);
    }

}
