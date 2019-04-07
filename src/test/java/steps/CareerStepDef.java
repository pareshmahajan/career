package steps;

import com.google.inject.Inject;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageobjects.CareerPage;

public class CareerStepDef {

    private CareerPage careerPage;

    @Inject
    public CareerStepDef(CareerPage careerPage){
        this.careerPage = careerPage;
    }

    @When("^User opens career site of the hexad website$")
    public void userOpensCareerSiteOfTheHexadWebsite(){

        careerPage.getDriver().get("https://hexad.de/en/careers.html");

    }

    @Then("^Career page is rendered$")
    public void careerPageIsRendered() {
        Assert.assertEquals("WE HAVE BEEN LOOKING FOR YOU" ,careerPage.h2Tag.getText());
    }

    @After
    public void quitBrowser(){
        careerPage.getDriver().quit();
    }
}
