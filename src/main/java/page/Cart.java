package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart extends CorePage {
    private final String emptyCartConfirmButtonRef = "[data-testid='modal-footer'] button";
    private final String emptyCartButtonRef = "[data-hypernova-key='EmptyCart'] button";
    private final String emptyCartTextInfoRef = ".header-1";

    public Cart(WebDriver driver) {
        super(driver);
    }

    public void emptyCart(){
        WebElement emptyCartButton = getWaiter().waitForElementToBeClickable(By.cssSelector(emptyCartButtonRef));
        emptyCartButton.click();
        WebElement emptyCartButtonConfirm = getWaiter().waitForElementToBeVisible(By.cssSelector(emptyCartConfirmButtonRef));
        emptyCartButtonConfirm.click();
    }

    public String getEmptyCartTextInfo() {
        WebElement emptyCartText = getWaiter().waitForElementToBePresent((By.cssSelector(emptyCartTextInfoRef)));
        return emptyCartText.getText();
    }
}
