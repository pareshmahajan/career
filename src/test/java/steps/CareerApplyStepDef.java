package steps;

import com.google.inject.Inject;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pageobjects.CareerApplyPage;

public class CareerApplyStepDef {

    private CareerApplyPage careerApplyPage;

    @Inject
    public CareerApplyStepDef(CareerApplyPage careerApplyPage){
        this.careerApplyPage = careerApplyPage;
    }


    @Then("^Career Apply Page is rendered$")
    public void careerApplyPageIsRendered() throws Exception{
        Thread.sleep(1000);
        Assert.assertEquals("APPLY NOW TO JOIN US" ,careerApplyPage.h2Tag.getText());
    }
}