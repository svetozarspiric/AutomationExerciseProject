package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    WebDriver driver;
    WebElement firstProductInCart;
    WebElement deleteProductButton;
    WebElement emptyCartText;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFirstProductInCart() {
        return driver.findElement(By.id("product-1"));
    }

    public WebElement getDeleteProductButton() {
        return driver.findElement(By.className("cart_quantity_delete"));
    }

    public WebElement getEmptyCartText() {
        return driver.findElement(By.id("empty_cart"));
    }

    //---------------------------------------------------

    public void clickOnDeleteItemButton() {
        getDeleteProductButton().click();
    }
}
