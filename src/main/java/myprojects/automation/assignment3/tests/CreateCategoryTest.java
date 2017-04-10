package myprojects.automation.assignment3.tests;
import org.openqa.selenium.By;
import myprojects.automation.assignment3.BaseScript;
import myprojects.automation.assignment3.GeneralActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class CreateCategoryTest extends BaseScript {

    private static String login = "webinar.test@gmail.com";
    private static String password = "Xcg7299bnSmMuRLp9ITw";
    private static String categoryName = "Test test";
    private static String categoryNameFilter ="Test test";
    public static void main(String[] args) throws InterruptedException {

        // TODO prepare driver object
        WebDriver driver = getConfiguredDriver();

        GeneralActions actions = new GeneralActions(driver);
        // login
        actions.login(login, password);
        // create category
        actions.createCategory(categoryName);


        // check that new category appears in Categories table
        actions.filterName(categoryName);
        // finish script
        //actions.waitForContentLoad();
        driver.quit();
    }
}
