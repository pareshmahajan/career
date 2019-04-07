package support;

import cucumber.runtime.java.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@ScenarioScoped
public class World {
    public WebDriver driver = new FirefoxDriverManager().getDriver();
    public WebDriverWait webDriverWait = new WebDriverWaitHelper().getWaitInstance(driver);
}
