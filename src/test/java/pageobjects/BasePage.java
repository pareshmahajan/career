package pageobjects;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.World;

public abstract class BasePage{

    private World world;

    @Inject
    BasePage(World world){
        this.world = world;
        PageFactory.initElements(world.driver, this);
    }

    public WebDriver getDriver(){
        return world.driver;
    }

    public WebDriverWait getWebDriverWait(){
        return world.webDriverWait;
    }
}
