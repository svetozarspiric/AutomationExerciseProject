package Pages;

import Base.BaseTest;
import org.apache.hc.core5.concurrent.BasicFuture;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {

    WebDriver driver;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Lista svih proizvoda prikazanih na Home stranici
    public List<WebElement> getListOfProducts() {
        return driver.findElements(By.cssSelector(".productinfo.text-center"));
    }

    // Dugme nakon dodavanja proizvoda u korpu
    public WebElement getContiunueShoppingButton() {
        return driver.findElement(By.cssSelector(".btn.btn-success.close-modal.btn-block"));
    }

    // Link koji se pojavljuje nakon dodavanja proizvoda
    public WebElement getViewCartLinkText() {
        return driver.findElement(By.cssSelector("div.modal-content a[href='/view_cart']"));
    }

    // Link za Products stranicu
    public WebElement getProductsNavLink() {
        return driver.findElement(By.cssSelector("a[href='/products']"));
    }

    // Link za Contact Us stranicu
    public WebElement getContactUsNavLink() {
        return driver.findElement(By.cssSelector("a[href='/contact_us']"));
    }


    //----------------------------------------------------

    // Klikce na proizvod na osnovu naziva proizvoda
    public void clickOnProduct(String productName) {
        for (int i = 0; i < getListOfProducts().size(); i++) {
            WebElement product = getListOfProducts().get(i).findElement(By.tagName("p"));
            if (product.getText().equals(productName)) {
                BaseTest.scrollToItem(driver, product);
                getListOfProducts().get(i).click();
                break;
            }
        }
    }

    // Klikce na "View Cart" link iz modala
    public void clickOnViewCartLinkText() {
       getViewCartLinkText().click();
    }

    // Klikce na "View Product" dugme za proizvod sa zadatim imenom
    public void clickOnViewProduct(String productName) {
        for (int i = 0; i < getListOfProducts().size(); i++) {
            WebElement productNameElement = getListOfProducts().get(i).findElement(By.tagName("p"));
            if (productNameElement.getText().equalsIgnoreCase(productName)) {
                WebElement viewProduct = driver.findElements(By.xpath("//a[text()='View Product']")).get(i);
                {
                    viewProduct.click();
                    break;
                }
            }
        }
    }

    // Klikce na "Contact Us" link u navigacionom meniju
    public void clickOnContactUsNavLink() {
        getContactUsNavLink().click();
    }
}