package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage {

    WebDriver driver;
    WebElement nameFiled;
    WebElement emailField;
    WebElement subjectField;
    WebElement messageField;
    WebElement fileInputButton;
    WebElement submitButton;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNameFiled() {
        return driver.findElement(By.cssSelector("input[type='text']"));
    }

    public WebElement getEmailField() {
        return driver.findElement(By.cssSelector("input[name='email']"));
    }

    public WebElement getSubjectField() {
        return driver.findElement(By.cssSelector("input[name='subject']"));
    }

    public WebElement getMessageField() {
        return driver.findElement(By.id("message"));
    }

    public WebElement getFileInputButton() {
        return driver.findElement(By.cssSelector("input[name='upload_file']"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.cssSelector("input[name='submit']"));
    }

    //-------------------------------------------

    public void inputNameField(String name) {
        getNameFiled().sendKeys(name);
    }

    public void inputEmailField(String email) {
        getEmailField().sendKeys(email);
    }

    public void inputSubjectField(String subject) {
        getSubjectField().sendKeys(subject);
    }

    public void inputMessageField(String message) {
        getMessageField().sendKeys(message);
    }

    public void fileUpload() {
        getFileInputButton().sendKeys("C:\\Users\\Asus\\Desktop\\Login.xlsx");
    }

    public void clickOnSubmitButton() {
        getSubmitButton().click();
    }
}
