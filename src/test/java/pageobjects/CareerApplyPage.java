package pageobjects;

import com.google.inject.Inject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import support.World;

public class CareerApplyPage extends BasePage {

    @FindBy(tagName= "h2")
    public WebElement h2Tag;

    @Inject
    public CareerApplyPage(World world) {
        super(world);
    }
}
