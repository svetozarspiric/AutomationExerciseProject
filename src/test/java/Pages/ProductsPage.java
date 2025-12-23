package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {

    WebDriver driver;
    WebElement searchProductField;
    WebElement searchButton;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSearchProductField() {
        return driver.findElement(By.id("search_product"));
    }

    public WebElement getSearchButton() {
        return driver.findElement(By.id("submit_search"));
    }

    //--------------------------------------------------

    public void inputSearchProductField(String productName){
        getSearchProductField().sendKeys(productName);
    }

    public void clickOnSearchButton() {
        getSearchButton().click();
    }
}
