import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Locators.ProductPageLocator.*;

public class ProductPage{
    private WebDriver driver;
    public ProductPage(WebDriver driver){
        this.driver= driver;
    }

    public String name(){
        WebElement name = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(PRODUCT_TITLE_ELEMENT));
        return name.getText();
    }


    public ProductPage addToCart(){
        driver.findElement(ADD_TO_CART_LOCATOR).click();
        return new ProductPage(driver);
    }

    public String info(){
        WebElement info = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(DESCRIPTION_ELEMENT));
        return info.getText();
    }


}