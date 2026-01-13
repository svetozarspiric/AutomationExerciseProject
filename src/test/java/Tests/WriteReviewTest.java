package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.ProductReviewPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WriteReviewTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/");

        homePage = new HomePage(driver);
        productReviewPage = new ProductReviewPage(driver);
    }

    @Test(priority = 1)
    public void userCanWriteReviewForProduct() {
        homePage.clickOnViewProduct("Sleeves Printed Top - White");

        // Provera da je poruka za pisanje recenzije vidljiva
        Assert.assertTrue(productReviewPage.getWriteYourReviewMessage().isDisplayed());

        // Provera da je sekcija za pisanje recenzije vidljiva
        productReviewPage.inputNameField("Pera");
        productReviewPage.inputEmailField("pera@mail.com");
        productReviewPage.inputReviewField("Mnogo lepo !!");
        productReviewPage.clickOnSubmitButton();

        // Provera da se prikazuje poruka sa poslatom recenzijom
        Assert.assertTrue(productReviewPage.getReviewMessage().isDisplayed());
    }

}
