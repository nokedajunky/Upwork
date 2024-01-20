package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cookies extends CorePage {
    private String acceptCookiesButtonRef = "#gdprBannerMount .btn.btn-primary";

    public Cookies(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        final WebElement acceptCookiesButton = getWaiter().waitForElementToBeClickable(By.cssSelector(this.acceptCookiesButtonRef));
        acceptCookiesButton.click();
    }
}
