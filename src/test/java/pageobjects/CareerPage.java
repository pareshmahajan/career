package pageobjects;

import com.google.inject.Inject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import support.World;

public class CareerPage extends BasePage {

    @FindBy(tagName= "h2")
    public WebElement h2Tag;

    @Inject
    public CareerPage(World world){
        super(world);
    }
}
