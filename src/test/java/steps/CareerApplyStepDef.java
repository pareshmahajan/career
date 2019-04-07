package steps;

import com.google.inject.Inject;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobjects.CareerApplyPage;

public class CareerApplyStepDef {

    private CareerApplyPage careerApplyPage;

    @Inject
    public CareerApplyStepDef(CareerApplyPage careerApplyPage){
        this.careerApplyPage = careerApplyPage;
    }


    @Then("^Career Apply Page is rendered$")
    public void careerApplyPageIsRendered() {
        careerApplyPage.getWebDriverWait().until(ExpectedConditions.textToBePresentInElement(careerApplyPage.h2Tag,
                "APPLY NOW TO JOIN US"));
    }
}