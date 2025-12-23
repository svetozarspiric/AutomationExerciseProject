package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductReviewPage {

    WebDriver driver;
    WebElement writeYourReviewMessage;
    WebElement nameField;
    WebElement emailField;
    WebElement reviewField;
    WebElement submitButton;
    WebElement reviewMessage;

    public ProductReviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getWriteYourReviewMessage() {
        return driver.findElement(By.cssSelector("a[href='#reviews']"));
    }

    public WebElement getNameField() {
        return driver.findElement(By.id("name"));
    }

    public WebElement getEmailField() {
        return driver.findElement(By.id("email"));
    }

    public WebElement getReviewField() {
        return driver.findElement(By.id("review"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("button-review"));
    }

    public WebElement getReviewMessage() {
        return driver.findElement(By.id("review-section"));
    }

    //--------------------------------------

    public void inputNameField(String name) {
        getNameField().sendKeys(name);
    }

    public void inputEmailField(String email) {
        getEmailField().sendKeys(email);
    }

    public void inputReviewField(String review) {
        getReviewField().sendKeys(review);
    }

    public void clickOnSubbmitButton() {
        getSubmitButton().click();
    }
}
