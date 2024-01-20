package page;

import helper.Waiter;
import org.openqa.selenium.WebDriver;

public class CorePage {
    private WebDriver driver;
    private Waiter waiter;

    public CorePage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new Waiter(this.driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Waiter getWaiter() {
        return waiter;
    }
}
