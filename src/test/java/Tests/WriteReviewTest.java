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

    @Test
    public void userCanWriteReviewForProduct() {
        homePage.clickOnViewProduct("Sleeves Printed Top - White");
        Assert.assertTrue(productReviewPage.getWriteYourReviewMessage().isDisplayed());

        productReviewPage.inputNameField("Pera");
        productReviewPage.inputEmailField("pera@mail.com");
        productReviewPage.inputReviewField("Mnogo lepo !!");
        productReviewPage.clickOnSubbmitButton();

        Assert.assertTrue(productReviewPage.getReviewMessage().isDisplayed());
    }

}
