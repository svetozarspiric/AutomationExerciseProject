package Tests;

import Base.BaseTest;
import Pages.ContactUsPage;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ContactUsTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/");

        homePage = new HomePage(driver);
        contactUsPage = new ContactUsPage(driver);
    }

    @Test
    public void userCanSendMessageFromContactUsPage() {
        homePage.clickOnContactUsNavLink();

        String expectedURL = "https://automationexercise.com/contact_us";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        contactUsPage.inputNameField("Mika");
        contactUsPage.inputEmailField("mika@mail.com");
        contactUsPage.inputSubjectField("Reklamacija");
        contactUsPage.inputMessageField("Poslali ste mi pocepan dzemper !! Hocu da mi vratite pare !");
        contactUsPage.fileUpload();
        contactUsPage.clickOnSubmitButton();
        driver.switchTo().alert().accept();

        String expectedSuccessMessage = "Success! Your details have been submitted successfully.";
        String actualSuccessMessage = driver.findElement(By.cssSelector(".status.alert.alert-success")).getText();
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);


    }
}
