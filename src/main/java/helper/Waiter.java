package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class Waiter {
    private WebDriver driver;
    private FluentWait<WebDriver> wait;
    private final static Duration TIMEOUT = Duration.ofSeconds(5);
    private final static Duration POLLING = Duration.ofMillis(500);

    public Waiter(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<>(driver)
                .withTimeout(TIMEOUT)
                .pollingEvery(POLLING)
                .ignoring(NoSuchElementException.class);
    }

    public WebElement waitForElementToBeClickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));
    }

    public WebElement waitForElementToBeVisible(By by) {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
    }

    public WebElement waitForElementToBePresent(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> waitForNumberOfElementsToBe(final By by, final Integer number) {
        return wait.until(ExpectedConditions.numberOfElementsToBe(by, number));
    }
}
