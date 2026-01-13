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

    @Test(priority = 1)
    public void userCanRemoveItemFromCart() {
        homePage.clickOnProduct("Blue Top");

        // Cekanje da dugme za nastavak kupovine bude klikabilno
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getContiunueShoppingButton()));

        // Provera da je dugme za nastavak kupovine prikazan
        Assert.assertTrue(homePage.getContiunueShoppingButton().isDisplayed());

        // cekanje da se cart modal učita u DOM
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cartModal")));

        // Cekanje da "View Cart" link postane klikabilan
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getViewCartLinkText()));
        homePage.clickOnViewCartLinkText();

        // Provera da je proizvod uspešno dodat u korpu
        Assert.assertTrue(cartPage.getFirstProductInCart().isDisplayed());

        cartPage.clickOnDeleteItemButton();

        // Cekanje da se pojavi poruka da je korpa prazna
        wait.until(ExpectedConditions.visibilityOf(cartPage.getEmptyCartText()));

        // Provera da je poruka o praznoj korpi prikazana
        Assert.assertTrue(cartPage.getEmptyCartText().isDisplayed());

    }
}
