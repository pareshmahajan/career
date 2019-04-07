package pageobjects;

import com.google.inject.Inject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import support.World;

public class CareerApplyPage extends BasePage {

    @FindBy(tagName= "h2")
    public WebElement h2Tag;

    @FindBy(css = "button.btn:nth-child(1)")
    public WebElement submitBtn;

    @FindBy(id="Full Name")
    public WebElement fullNameText;

    @FindBy(id="Email")
    public WebElement emailText;

    @FindBy(xpath="//input[@placeholder='Phone']")
    public WebElement phoneText;

    @FindBy(xpath="//input[@type='checkbox']")
    public WebElement termsAndConditionsChkBox;

    @FindBy(name="file")
    public WebElement uploadFile;

    @Inject
    public CareerApplyPage(World world) {
        super(world);
    }
}
