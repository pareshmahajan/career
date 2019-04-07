package steps;

import com.google.inject.Inject;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.CareerPage;

public class CareerStepDef {

    private CareerPage careerPage;

    @Inject
    public CareerStepDef(CareerPage careerPage){
        this.careerPage = careerPage;
    }

    @When("^User opens career page of the hexad website$")
    public void userOpensCareerPageOfTheHexadWebsite(){
        careerPage.navigate();
    }

    @Then("^Career page is rendered$")
    public void careerPageIsRendered() {
        careerPage.verifyCareerPageIsRendered();
    }

    @When("^User click the Apply button$")
    public void userClickTheApplyButton() {
       careerPage.clickApplyButton();
    }

    @After
    public void quitBrowser(){
        careerPage.getDriver().quit();
    }

    @When("^User click the Job Description button of the UI developer job$")
    public void userClickTheJobDescriptionButtonOfTheUIDeveloperJob()  {
        careerPage.clickJobDescriptionButton();
    }

    @Then("^Job Description of the UI developer job is displayed correctly$")
    public void jobDescriptionOfTheUIDeveloperJobIsDisplayedCorrectly() {
        careerPage.verifyHeadingOfTheUIDeveloperJob();
    }
}
