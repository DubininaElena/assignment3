package myprojects.automation.assignment3;

import myprojects.automation.assignment3.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Base script functionality, can be used for all Selenium scripts.
 */
public abstract class BaseScript {

    /**
     *
     * @return New instance of {@link WebDriver} object. Driver type is based on passed parameters
     * to the automation project, returns {@link ChromeDriver} instance by default.
     */
    public static WebDriver getDriver() {
        String browser = Properties.getBrowser();
        switch (browser) {
            // TODO prepare required WebDriver instance according to browser type
            default:
                System.setProperty(
                        "webdriver.chrome.driver",
                        new File(BaseScript.class.getResource("/chromedriver.exe").getFile()).getPath());
                return new ChromeDriver();
        }
    }

    /**
     * Creates {@link WebDriver} instance with timeout and browser window configurations.
     *
     * @return New instance of {@link EventFiringWebDriver} object. Driver type is based on passed parameters
     * to the automation project, returns {@link ChromeDriver} instance by default.
     */
    public static EventFiringWebDriver getConfiguredDriver() {
        WebDriver driver = getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(16, TimeUnit.SECONDS);
        EventFiringWebDriver wrappedDriver = new EventFiringWebDriver(driver);
        wrappedDriver.register(new WebDriverEventListener() {
            @Override
            public void beforeNavigateTo(String s, WebDriver webDriver) {

            }

            @Override
            public void afterNavigateTo(String s, WebDriver webDriver) {

            }

            @Override
            public void beforeNavigateBack(WebDriver webDriver) {

            }

            @Override
            public void afterNavigateBack(WebDriver webDriver) {

            }

            @Override
            public void beforeNavigateForward(WebDriver webDriver) {

            }

            @Override
            public void afterNavigateForward(WebDriver webDriver) {

            }

            @Override
            public void beforeNavigateRefresh(WebDriver webDriver) {

            }

            @Override
            public void afterNavigateRefresh(WebDriver webDriver) {

            }

            @Override
            public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
                System.out.println("Should be "+by);
            }

            @Override
            public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
                System.out.println("Element found");
            }

            @Override
            public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
                System.out.println("Should click "+ webElement.getTagName());
            }

            @Override
            public void afterClickOn(WebElement webElement, WebDriver webDriver) {
                System.out.println("Clicked successfull");
            }

            @Override
            public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

            }

            @Override
            public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

            }

            @Override
            public void beforeScript(String s, WebDriver webDriver) {

            }

            @Override
            public void afterScript(String s, WebDriver webDriver) {

            }

            @Override
            public void onException(Throwable throwable, WebDriver webDriver) {

            }


            // TODO configure browser window (set timeouts, browser pindow position) and connect loggers.
            //throw new UnsupportedOperationException("Method doesn't return configured WebDriver instance");

        });
        return wrappedDriver;

        // TODO configure browser window (set timeouts, browser pindow position) and connect loggers.
        //throw new UnsupportedOperationException("Method doesn't return configured WebDriver instance");
    }
}
