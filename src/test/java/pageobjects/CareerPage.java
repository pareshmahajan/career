package pageobjects;

import com.google.inject.Inject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import support.World;

public class CareerPage extends BasePage {

    @FindBy(tagName= "h2")
    public WebElement h2Tag;

    @FindBy(css="button.btn-primary:nth-child(1)")
    public WebElement applyButton;

    @FindBy(css="button.btn-default:nth-child(2)")
    public WebElement jobDescriptionButton;

    @FindBy(xpath="//*[@id=\"inner-content\"]/div/div[2]/div[4]/div/p[1]")
    public WebElement firstJobDescription;

    @Inject
    public CareerPage(World world){
        super(world);
    }
}
