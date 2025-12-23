package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    @Test
    public void userCanSearchProducts() {
        clickOnItem(homePage.getProductsNavLink());

        String expectedURL = "https://automationexercise.com/products";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        productPage.inputSearchProductField("Madame Top For Women");
        productPage.clickOnSearchButton();

        String expectedProductName = "Madame Top For Women";
        WebElement madameTopForWomen = driver.findElement(By.cssSelector(".productinfo.text-center"));
        String actualProductName = madameTopForWomen.findElement(By.tagName("p")).getText();
        wait.until(ExpectedConditions.visibilityOf(madameTopForWomen));
        Assert.assertEquals(actualProductName, expectedProductName);

    }
}
