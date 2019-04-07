package support;

import cucumber.runtime.java.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;

@ScenarioScoped
public class World {
    public WebDriver driver = new FirefoxDriverManager().getDriver();
}
