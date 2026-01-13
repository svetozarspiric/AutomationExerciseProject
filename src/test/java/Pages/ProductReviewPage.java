package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductReviewPage {

    WebDriver driver;


    public ProductReviewPage(WebDriver driver) {
        this.driver = driver;
    }

    // Sekcija "Write Your Review" na stranici proizvoda
    public WebElement getWriteYourReviewMessage() {
        return driver.findElement(By.cssSelector("a[href='#reviews']"));
    }

    // Polje za ime korisnika u formi za recenziju
    public WebElement getNameField() {
        return driver.findElement(By.id("name"));
    }

    // Polje za email korisnika u formi za recenziju
    public WebElement getEmailField() {
        return driver.findElement(By.id("email"));
    }

    // Polje za unos teksta recenzije
    public WebElement getReviewField() {
        return driver.findElement(By.id("review"));
    }

    // Dugme za slanje recenzije
    public WebElement getSubmitButton() {
        return driver.findElement(By.id("button-review"));
    }

    // Poruka nakon uspesnog slanja recenzije
    public WebElement getReviewMessage() {
        return driver.findElement(By.id("review-section"));
    }

    //--------------------------------------

    // Unosi ime korisnika u polje za recenziju
    public void inputNameField(String name) {
        getNameField().sendKeys(name);
    }

    // Unosi email korisnika u polje za recenziju
    public void inputEmailField(String email) {
        getEmailField().sendKeys(email);
    }

    // Unosi tekst recenzije u odgovarajuće polje
    public void inputReviewField(String review) {
        getReviewField().sendKeys(review);
    }

    // Klikce na dugme za slanje recenzije
    public void clickOnSubmitButton() {
        getSubmitButton().click();
    }
}
