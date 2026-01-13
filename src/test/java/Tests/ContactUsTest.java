package Tests;

import Base.BaseTest;
import Pages.ContactUsPage;
import Pages.HomePage;
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

    @Test(priority = 1)
    public void userCanSendMessageFromContactUsPage() {
        homePage.clickOnContactUsNavLink();

        // Provera da je korisnik preusmeren na Contact Us stranicu
        String expectedURL = "https://automationexercise.com/contact_us";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        // Popunjavanje Contact Us forme
        contactUsPage.inputNameField("Mika");
        contactUsPage.inputEmailField("mika@mail.com");
        contactUsPage.inputSubjectField("Reklamacija");
        contactUsPage.inputMessageField("Poslali ste mi pocepan dzemper !! Hocu da mi vratite pare !");

        // Upload fajla
        contactUsPage.fileUpload();
        contactUsPage.clickOnSubmitButton();

        // Potvrda JavaScript alerta (OK dugme)
        driver.switchTo().alert().accept();

        // Provera poruke o uspesnom slanju forme
        String expectedSuccessMessage = "Success! Your details have been submitted successfully.";
        Assert.assertEquals(contactUsPage.getSuccessMessage().getText(), expectedSuccessMessage);


    }
}
