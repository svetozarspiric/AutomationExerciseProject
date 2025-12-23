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
    WebDriverWait wait;
    List<WebElement> listOfProducts;
    WebElement contiunueShoppingButton;
    WebElement viewCartLinkText;
    WebElement productsNavLink;
    WebElement contactUsNavLink;

    


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getListOfProducts() {
        return driver.findElements(By.cssSelector(".productinfo.text-center"));
    }

    public WebElement getContiunueShoppingButton() {
        return driver.findElement(By.cssSelector(".btn.btn-success.close-modal.btn-block"));
    }

    public WebElement getViewCartLinkText() {
        return driver.findElement(By.cssSelector("div.modal-content a[href='/view_cart']"));
    }

    public WebElement getProductsNavLink() {
        return driver.findElement(By.cssSelector("a[href='/products']"));
    }

    public WebElement getContactUsNavLink() {
        return driver.findElement(By.cssSelector("a[href='/contact_us']"));
    }


    //----------------------------------------------------

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

    public void clickOnViewCartLinkText() {
       getViewCartLinkText().click();
    }

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

    public void clickOnContactUsNavLink() {
        getContactUsNavLink().click();
    }
}