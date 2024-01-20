import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.Cart;
import page.Cookies;
import page.Landing;
import page.Navbar;
import page.results.Results;

import java.util.List;

class CartTest {
    private WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void shouldFindAddEmptyCart_confirmationMessageIsShown() {
        Landing landing = new Landing(driver);
        Cookies cookies = new Cookies(driver);
        Navbar navbar = new Navbar(driver);
        Results results = new Results(driver);
        Cart cart = new Cart(driver);
        final String searchPhrase = "stainless work table";

        landing.goTo();
        cookies.acceptCookies();
        navbar.searchFor(searchPhrase);
        List<String> productNames = results.getProductNames();
        Assertions.assertThat(productNames).allMatch(productName -> productName.contains("Table"));

        results.addToCartAtIndex(59);
        results.viewCart();

        cart.emptyCart();
        String emptyCartTextInfo = cart.getEmptyCartTextInfo();
        Assertions.assertThat(emptyCartTextInfo).isEqualTo("Your cart is empty.");
    }
}