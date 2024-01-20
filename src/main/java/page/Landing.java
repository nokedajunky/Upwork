package page;

import org.openqa.selenium.WebDriver;

public class Landing extends CorePage {
    private final String websiteUrl = "https://www.webstaurantstore.com/";

    public Landing(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        getDriver().get(websiteUrl);
    }
}
