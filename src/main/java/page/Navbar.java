package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Navbar extends CorePage {
    private String searchInput = "input[data-testid='searchval']";
    private String searchButton = "button[value='Search']";

    public Navbar(WebDriver driver) {
        super(driver);
    }


    public void searchFor(final String phrase) {
        WebElement searchField = getWaiter().waitForElementToBeClickable(By.cssSelector(searchInput));
        searchField.sendKeys(phrase);
        getDriver().findElement(By.cssSelector(searchButton)).click();
    }
}
