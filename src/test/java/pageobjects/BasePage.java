package pageobjects;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.ScenarioData;
import support.World;

public abstract class BasePage{

    private World world;

    @Inject
    BasePage(World world){
        this.world = world;
        PageFactory.initElements(world.driver, this);
    }

    public ScenarioData getScenarioData(){
        return world.scenarioData;
    }

    public WebDriver getDriver(){
        return world.driver;
    }

    WebDriverWait getWebDriverWait(){
        return world.webDriverWait;
    }
}
