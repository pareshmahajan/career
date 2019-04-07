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

    @FindBy(id="Title")
    public WebElement titleText;

    @FindBy(id="Full Name")
    public WebElement fullNameText;

    @FindBy(id="Email")
    public WebElement emailText;

    @FindBy(id="Address")
    public WebElement addressText;

    @FindBy(xpath="//input[@placeholder='Phone']")
    public WebElement phoneText;

    @FindBy(xpath="//input[@type='checkbox']")
    public WebElement termsAndConditionsChkBox;

    @FindBy(name="file")
    public WebElement uploadFile;

    @FindBy(name="position")
    public WebElement positionSelectList;

    @FindBy(name="jobtype")
    public WebElement jobTypeSelectList;

    @FindBy(id="career-form")
    public WebElement careerForm;

    @Inject
    public CareerApplyPage(World world) {
        super(world);
    }
}
