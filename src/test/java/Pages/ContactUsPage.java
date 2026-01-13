package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage {

    WebDriver driver;


    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Polje za ime korisnika
    public WebElement getNameFiled() {
        return driver.findElement(By.cssSelector("input[type='text']"));
    }

    // Polje za email adresu
    public WebElement getEmailField() {
        return driver.findElement(By.cssSelector("input[name='email']"));
    }

    // Polje za predmet poruke
    public WebElement getSubjectField() {
        return driver.findElement(By.cssSelector("input[name='subject']"));
    }

    // Polje za poruku
    public WebElement getMessageField() {
        return driver.findElement(By.id("message"));
    }

    // Input za upload fajla
    public WebElement getFileInputButton() {
        return driver.findElement(By.cssSelector("input[name='upload_file']"));
    }

    // Dugme za slanje forme
    public WebElement getSubmitButton() {
        return driver.findElement(By.cssSelector("input[name='submit']"));
    }

    // Poruka o uspesno poslatoj formi
    public WebElement getSuccessMessage() {
        return driver.findElement(By.cssSelector(".status.alert.alert-success"));
    }

    //-------------------------------------------

    // Unosi ime u Name polje
    public void inputNameField(String name) {
        getNameFiled().sendKeys(name);
    }

    // Unosi email adresu u Email polje
    public void inputEmailField(String email) {
        getEmailField().sendKeys(email);
    }

    // Unosi predmet poruke u Subject polje
    public void inputSubjectField(String subject) {
        getSubjectField().sendKeys(subject);
    }

    // Unosi tekst poruke u Message polje
    public void inputMessageField(String message) {
        getMessageField().sendKeys(message);
    }

    // Uploaduje fajl
    public void fileUpload() {
        getFileInputButton().sendKeys("C:\\Users\\Asus\\Desktop\\Login.xlsx");
    }

    // Klikce na Submit dugme za slanje forme
    public void clickOnSubmitButton() {
        getSubmitButton().click();
    }
}
