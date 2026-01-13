package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {

    WebDriver driver;



    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Polje za pretragu proizvoda
    public WebElement getSearchProductField() {
        return driver.findElement(By.id("search_product"));
    }

    // Dugme za pokretanje pretrage proizvoda
    public WebElement getSearchButton() {
        return driver.findElement(By.id("submit_search"));
    }

    // Pronadjeni proizvod nakon izvršene pretrage
    public WebElement getSearchedProduct() {
        return driver.findElement(By.cssSelector(".productinfo.text-center"));
    }

    // Naziv pronadjenog proizvoda
    public String getSearchedProductName() {
        return getSearchedProduct().findElement(By.tagName("p")).getText();
    }

    //--------------------------------------------------

    // Unosi naziv proizvoda u search input polje
    public void inputSearchProductField(String productName){
        getSearchProductField().sendKeys(productName);
    }

    // Klikce na dugme za pretragu proizvoda
    public void clickOnSearchButton() {
        getSearchButton().click();
    }
}
