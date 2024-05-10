
import base.BasePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        driver.manage().window().maximize();
        driver.get(BasePage.BASE_URL);
        homePage = new HomePage(driver);
        homePage.closePopup();
    }


    @AfterMethod
    private void screenShotListener(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {

            final String PATH = "src/screenshots/";

            if (!(driver instanceof TakesScreenshot)) {
                throw new UnsupportedOperationException("Driver does not support screenshots.");
            }
            TakesScreenshot screenshotMaker = (TakesScreenshot) driver;
            File screenShotFile = screenshotMaker.getScreenshotAs(OutputType.FILE);

            String fileName = result.getStartMillis() + "-screenshot" + ".png";
            Path destination = Paths.get(PATH, fileName);

            try {
                Files.move(screenShotFile.toPath(), destination);
            } catch (IOException e) {
                e.printStackTrace();
            }
            driver.quit();
        }

    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
