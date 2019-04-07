package steps;

import com.google.inject.Inject;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import pageobjects.CareerPage;

public class CareerStepDef {

    private CareerPage careerPage;

    @Inject
    public CareerStepDef(CareerPage careerPage) {
        this.careerPage = careerPage;
    }

    @When("^User opens career page of the hexad website$")
    public void userOpensCareerPageOfTheHexadWebsite() {
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
    public void quitBrowser() {
        careerPage.getDriver().quit();
    }

    @When("^User click the Job Description button of the UI developer job$")
    public void userClickTheJobDescriptionButtonOfTheUIDeveloperJob() {
        careerPage.clickJobDescriptionButton();
    }

    @Then("^Job Description Heading of the UI developer job is displayed correctly$")
    public void jobDescriptionHeadingOfTheUIDeveloperJobIsDisplayedCorrectly() {
        careerPage.verifyHeadingOfTheUIDeveloperJob();
    }

    @When("^I remember the list of Available positions on the career page$")
    public void iRememberTheListOfAvailablePositionsOnTheCareerPage() {
        int numberOfPositions = careerPage.getDriver().findElements(By.cssSelector("div.row")).size();
        for (int i = 2; i < numberOfPositions; i++) {
            String currentPosition = careerPage.getDriver().findElement(
                    By.cssSelector("div.row:nth-child(" + i + ") > div:nth-child(2) > p:nth-child(1)")).getText();
            careerPage.getScenarioData().addPosition(currentPosition);
        }
    }
}
