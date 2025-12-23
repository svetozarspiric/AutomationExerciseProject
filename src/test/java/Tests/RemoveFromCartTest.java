package Tests;

import Base.BaseTest;
import Pages.CartPage;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RemoveFromCartTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/");

        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    public void userCanRemoveItemFromCart() {
        homePage.clickOnProduct("Blue Top");

        wait.until(ExpectedConditions.elementToBeClickable(homePage.getContiunueShoppingButton()));
        Assert.assertTrue(homePage.getContiunueShoppingButton().isDisplayed());

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cartModal")));
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getViewCartLinkText()));
        homePage.clickOnViewCartLinkText();

        Assert.assertTrue(cartPage.getFirstProductInCart().isDisplayed());

        cartPage.clickOnDeleteItemButton();

        wait.until(ExpectedConditions.visibilityOf(cartPage.getEmptyCartText()));
        Assert.assertTrue(cartPage.getEmptyCartText().isDisplayed());

    }
}
