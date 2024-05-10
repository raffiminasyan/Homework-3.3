package Locators;

import org.openqa.selenium.By;

public class LoginPageLocators {

    public static final By EMAIL_INPUT = By.cssSelector("input#email");
    public static final By PASSWORD_INPUT = By.xpath("//input[@type='password' and @id='password']");
    public static final By LOGIN_BUTTON  = By.cssSelector("button[type='submit'].button-primary");
    public static final By ERROR_MESSAGE = By.cssSelector("p.py-2.pl-5.form.error-message");
    public static final By FORGOT_PASSWORD = By.xpath("//a[contains(text(),'Forgot Password?')]");
    public static final By SIGNUP_BUTTON = By.xpath("//a[contains(text(),'Sign up')]");
    public static final By WELCOME_MESSAGE = By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/section[1]/div[1]/div[2]/div[1]/h1[1]");
}
