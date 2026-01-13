package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    // Glavni WebDriver koji koriste svi testovi
    public WebDriver driver;
    // Explicit wait za cekanje elemenata i stanja na stranici
    public WebDriverWait wait;
    // Page Object klase – zajednicke za sve testove
    public HomePage homePage;
    public CartPage cartPage;
    public ProductsPage productPage;
    public ProductReviewPage productReviewPage;
    public ContactUsPage contactUsPage;

    // Ovde se podesava WebDriver (chromedriver)
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    // Gasi WebDriver sesiju i zatvara sve prozore browsera koje je test otvorio.
    @AfterClass
    public void tearDown() {
        //driver.quit();
    }
    // Pomocna metoda za skrolovanje do odredjenog elementa
    public static void scrollToItem(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    // Pomocna metoda za klik pomocu JavaScript-a
    // Najcesce se koristi kada obican click() ne radi
    public void clickOnItem(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
}