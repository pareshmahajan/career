package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager{

    private FirefoxDriver driver;

    private WebDriver createDriver() {
        return driver = new FirefoxDriver();
    }

    WebDriver getDriver() {
        System.setProperty("webdriver.gecko.driver", "./src/test/resources/drivers/geckodriver");
        if (driver == null) {
            this.createDriver();
        }
        return driver;
    }
}
