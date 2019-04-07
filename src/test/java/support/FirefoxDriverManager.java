package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class FirefoxDriverManager{

    private WebDriver driver;

    private WebDriver createDriver() {
        return driver = new FirefoxDriver();
    }

    WebDriver getDriver() {
        System.setProperty("webdriver.gecko.driver", "./src/test/resources/drivers/geckodriver");
        if (driver == null) {
            this.createDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }
}
