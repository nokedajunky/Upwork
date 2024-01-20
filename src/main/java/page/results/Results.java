package page.results;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.CorePage;

import java.util.List;
import java.util.stream.Collectors;

public class Results extends CorePage {

    private final String productNamesRef = "#ProductBoxContainer [data-testid='itemDescription']";
    private final String productAddToCartButton = "[data-testid='itemAddCart']";
    private final String viewCartButtonRef = "[data-role='notification'] a[href^='/viewcart']";
    private final int PAGE_MAX_ELEMENTS = 60;

    public Results(WebDriver driver) {
        super(driver);
    }

    public List<String> getProductNames() {
        final List<WebElement> productNames = getWaiter().waitForNumberOfElementsToBe(By.cssSelector(productNamesRef), PAGE_MAX_ELEMENTS);
        return productNames
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void addToCartAtIndex(int index) {
        if (index < 0 || index > PAGE_MAX_ELEMENTS) throw new IllegalArgumentException("Please provide value between 0 adn " + PAGE_MAX_ELEMENTS);

        final List<WebElement> addToCartButtons = getWaiter().waitForNumberOfElementsToBe(By.cssSelector(productAddToCartButton), PAGE_MAX_ELEMENTS);
        addToCartButtons.get(index).click();
    }

    public void viewCart() {
        WebElement viewCartButton = getWaiter().waitForElementToBeVisible((By.cssSelector(viewCartButtonRef)));
        viewCartButton.click();
    }
}
