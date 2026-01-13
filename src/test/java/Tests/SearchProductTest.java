package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.ProductsPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.time.Duration;

public class SearchProductTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/");

        homePage = new HomePage(driver);
        productPage = new ProductsPage(driver);
    }

    @Test(priority = 1)
    public void userCanSearchProducts() {
        clickOnItem(homePage.getProductsNavLink());

        // Provera da je korisnik preusmeren na Products stranicu
        String expectedURL = "https://automationexercise.com/products";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        // Unos naziva proizvoda u search polje
        productPage.inputSearchProductField("Madame Top For Women");
        productPage.clickOnSearchButton();

        // Ocekivani naziv proizvoda koji bi trebao da se pojavi
        String expectedProductName = "Madame Top For Women";

        // Cekanje da rezultat pretrage bude vidljiv
        wait.until(ExpectedConditions.visibilityOf(productPage.getSearchedProduct()));

        // Provera da se prikazani proizvod poklapa sa ocekivanim
        Assert.assertEquals(productPage.getSearchedProductName(), expectedProductName);

    }
}
