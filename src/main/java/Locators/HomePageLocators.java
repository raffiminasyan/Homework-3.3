package Locators;

import org.openqa.selenium.By;

public class HomePageLocators {
    public static final By LOGO = By.xpath("//header/nav[2]/a[1]");
    public static final By BEST_SELLERS_LINK = By.cssSelector("a.nav-item.bottom-line-current.lg\\:px-4.xl\\:px-5.py-7[href*='/collections/best-sellers']");
    public static final By GIFTING_LINK = By.cssSelector("a.nav-item.bottom-line-current.lg\\:px-4.xl\\:px-5.py-7[href*='/collections/gifting']");
    public static final By SEARCH_BUTTON = By.xpath("//header/nav[2]/div[1]/div[3]/button[1]");
    public static final By SEARCH_INPUT = By.xpath("//header/form[1]/input[1]");
    public static final By SEARCH_TITLE = By.xpath("//h1[contains(text(),'Search')]");
    public static final By PROFILE_BUTTON = By.xpath("//header/nav[2]/div[1]/div[3]/a[1]");
    public static final By SIGN_IN_BUTTON = By.cssSelector("a[title='Sign in to your account'].rounded.flex.items-center.px-4.h-20.nav-item.bottom-line-current");
    public static final By POPUP_MODAL = By.id("email-signup");
    public static final By CLOSE_POPUP = By.cssSelector(".modal__cross .modal__cross-web");
}
