package myprojects.automation.assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;
import static org.apache.xalan.xsltc.compiler.util.Type.Text;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;
    private By catalogueLink = By.cssSelector("#subtab-AdminCatalog");
    private By categoriesLink = By.cssSelector("#subtab-AdminCategories");
    private By addCategory = By.cssSelector("#page-header-desc-category-new_category");
    private By saveButton = By.cssSelector(".process-icon-save");
    private By searchButton = By.cssSelector("#submitFilterButtoncategory");
    private By fieldFilter = By.cssSelector("[name=categoryFilter_name]");
    private By checkText = By.cssSelector("#tr_2_14_1");
    private By fieldName = By.cssSelector("#name_1");
    private By massege = By.cssSelector("[class='alert alert-success']");

    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * Logs in to Admin Panel.
     *
     * @param login
     * @param password
     */
    public void login(String login, String password) {
        driver.navigate().to("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0");
        WebElement loginInput = driver.findElement(By.cssSelector("#email"));
        WebElement passwordInput = driver.findElement(By.cssSelector("#passwd"));
        WebElement loginButton = driver.findElement(By.cssSelector("[name='submitLogin']"));
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
        //throw new UnsupportedOperationException();
    }

    /**
     * Adds new category in Admin Panel.
     *
     * @param categoryName
     */
    public void createCategory(String categoryName) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogueLink));
        WebElement catalogueLink = driver.findElement(this.catalogueLink);
        WebElement categoriesLink = driver.findElement(this.categoriesLink);
        Actions actions = new Actions(driver);
        actions.moveToElement(catalogueLink);
        actions.click(categoriesLink).build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(addCategory));
        WebElement addCategory = driver.findElement(this.addCategory);
        addCategory.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldName));
        WebElement fieldName = driver.findElement(this.fieldName);
        fieldName.sendKeys(categoryName);

        wait.until(ExpectedConditions.visibilityOfElementLocated(saveButton));
        WebElement saveButton = driver.findElement(this.saveButton);
        saveButton.click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(massege,"Создано"));
        WebElement massege = driver.findElement(this.massege);
    }

    /**
     * @param categoryNameFilter
     */
    public void filterName(String categoryNameFilter) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldFilter));
        WebElement fieldFilter = driver.findElement(this.fieldFilter);
        fieldFilter.sendKeys(categoryNameFilter);

        wait.until(ExpectedConditions.presenceOfElementLocated(searchButton));
        WebElement searchButton = driver.findElement(this.searchButton);
        searchButton.click();
    }

    /**
     * Waits until page loader disappears from the page
     */
    public void waitForContentLoad() {
        // TODO implement generic method to wait until page content is loaded
        wait.until(ExpectedConditions.textToBePresentInElementLocated(checkText, "Test test"));
        WebElement checkText = driver.findElement(this.checkText);


    }
}

