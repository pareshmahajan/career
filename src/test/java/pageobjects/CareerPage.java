package pageobjects;

import com.google.inject.Inject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.World;

public class CareerPage extends BasePage {

    private static final String URL = "https://hexad.de/en/careers.html";

    @FindBy(tagName= "h2")
    private WebElement h2Tag;

    @FindBy(css="button.btn-primary:nth-child(1)")
    private WebElement applyButton;

    @FindBy(css="button.btn-default:nth-child(2)")
    private WebElement jobDescriptionButton;

    @FindBy(xpath="//*[@id=\"inner-content\"]/div/div[2]/div[4]/div/p[1]")
    private WebElement firstJobDescription;

    @Inject
    public CareerPage(World world){
        super(world);
    }

    public void navigate() {
        this.getDriver().get(URL);
    }

    public void verifyCareerPageIsRendered() {
        Assert.assertEquals("WE HAVE BEEN LOOKING FOR YOU" ,h2Tag.getText());
    }

    public void clickApplyButton() {
        applyButton.click();
    }

    public void clickJobDescriptionButton() {
        jobDescriptionButton.click();
    }

    public void verifyHeadingOfTheUIDeveloperJob() {
        String expectedJobDescriptionText = "Hexad GmbH, a unique organization dedicated to the widespread adoption of open " +
                "source application software, is looking for a User Interface Developer to join our team. " +
                "An ideal candidate would have deep skills in Web Design and implementation with a passion for " +
                "building great web-based user interfaces.";

        getWebDriverWait().until(ExpectedConditions.textToBePresentInElement(firstJobDescription,
                expectedJobDescriptionText));
    }
}
