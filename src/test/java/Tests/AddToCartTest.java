package Tests;

import Base.BaseTest;
import Pages.CartPage;
import Pages.HomePage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCartTest extends BaseTest {

    // Priprema test okruženja pre svakog testa
    // Svaki test se otvara u posebnom browseru (vazi za sve testove u projektu)
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
    public void userCanAddOneProductToCart() {

        // Naziv proizvoda koji se dodaje u korpu
        String productName = "Frozen Tops For Kids";
        homePage.clickOnProduct(productName);

        // Cekanje da se pojavi dugme "Continue Shopping" nakon dodavanja proizvoda
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getContiunueShoppingButton()));

        // Provera da je dugme za nastavak kupovine prikazan
        Assert.assertTrue(homePage.getContiunueShoppingButton().isDisplayed());

        homePage.clickOnViewCartLinkText();

        // Provera da se u korpi nalazi proizvod koji je dodat
        Assert.assertEquals(cartPage.getAddedProduct().getText(), productName);


    }

}
