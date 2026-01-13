package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    WebDriver driver;


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // WebElement prvog proizvoda u korpi
    public WebElement getFirstProductInCart() {
        return driver.findElement(By.id("product-1"));
    }

    // Dugme za brisanje proizvoda iz korpe
    public WebElement getDeleteProductButton() {
        return driver.findElement(By.className("cart_quantity_delete"));
    }

    // Tekst koji se prikazuje kada je korpa prazna
    public WebElement getEmptyCartText() {
        return driver.findElement(By.id("empty_cart"));
    }

    // Naziv proizvoda koji je dodat u korpu
    public WebElement getAddedProduct() {
        return driver.findElement(By.cssSelector(".cart_description h4 a"));
    }

    //---------------------------------------------------

    // Klikce na dugme za brisanje proizvoda iz korpe
    public void clickOnDeleteItemButton() {
        getDeleteProductButton().click();
    }
}
