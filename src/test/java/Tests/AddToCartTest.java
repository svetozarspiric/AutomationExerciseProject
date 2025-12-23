package Tests;

import Base.BaseTest;
import Pages.HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCartTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/");

        homePage = new HomePage(driver);
    }

    @Test
    public void userCanAddOneProductToCart() {
        String productName = "Frozen Tops For Kids";
        homePage.clickOnProduct(productName);
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getContiunueShoppingButton()));

        Assert.assertTrue(homePage.getContiunueShoppingButton().isDisplayed());

        homePage.clickOnViewCartLinkText();

        Assert.assertEquals(driver.findElement(By.cssSelector(".cart_description h4 a")).getText(), productName);


    }

}
