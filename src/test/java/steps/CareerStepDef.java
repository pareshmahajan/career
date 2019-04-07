package steps;

import com.google.inject.Inject;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobjects.CareerPage;

public class CareerStepDef {

    private CareerPage careerPage;
    private static final String URL = "https://hexad.de/en/careers.html";

    @Inject
    public CareerStepDef(CareerPage careerPage){
        this.careerPage = careerPage;
    }

    @When("^User opens career page of the hexad website$")
    public void userOpensCareerPageOfTheHexadWebsite(){
        careerPage.getDriver().get(URL);
    }

    @Then("^Career page is rendered$")
    public void careerPageIsRendered() {
        Assert.assertEquals("WE HAVE BEEN LOOKING FOR YOU" ,careerPage.h2Tag.getText());
    }

    @When("^User click the Apply button$")
    public void userClickTheApplyButton() {
        careerPage.applyButton.click();
    }

    @After
    public void quitBrowser(){
        careerPage.getDriver().quit();
    }

    @When("^User click the Job Description button of the UI developer job$")
    public void userClickTheJobDescriptionButtonOfTheUIDeveloperJob()  {
        careerPage.jobDescriptionButton.click();
    }

    @Then("^Job Description of the UI developer job is displayed correctly$")
    public void jobDescriptionOfTheUIDeveloperJobIsDisplayedCorrectly() {
        String expectedJobDescriptionText = "Hexad GmbH, a unique organization dedicated to the widespread adoption of open " +
                "source application software, is looking for a User Interface Developer to join our team. " +
                "An ideal candidate would have deep skills in Web Design and implementation with a passion for " +
                "building great web-based user interfaces.";

        careerPage.getWebDriverWait().until(ExpectedConditions.textToBePresentInElement(careerPage.firstJobDescription,
                expectedJobDescriptionText));
    }
}
