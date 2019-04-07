package steps;

import com.google.inject.Inject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.CareerApplyPage;

public class CareerApplyStepDef {

    private CareerApplyPage careerApplyPage;

    @Inject
    public CareerApplyStepDef(CareerApplyPage careerApplyPage){
        this.careerApplyPage = careerApplyPage;
    }

    @Then("^Career Apply Page is rendered$")
    public void careerApplyPageIsRendered() {
        careerApplyPage.verifyCareerApplyPageRendered();
    }

    @When("^User clicks the Submit Button$")
    public void userClicksTheSubmitButton() {
        careerApplyPage.clickSubmitButton();
    }

    @Then("^User should see the validation message to fill the Full Name$")
    public void userShouldSeeTheValidationMessageToFillTheFullName()  {
        careerApplyPage.assertValidationMessageWhenFullNameIsMissing();
    }

    @When("^User sets the 'Full Name' as \"([^\"]*)\"$")
    public void userSetsTheFullNameAs(String fullName) {
        careerApplyPage.enterFullName(fullName);
    }

    @Then("^User should see the validation message to fill the Email$")
    public void userShouldSeeTheValidationMessageToFillTheEmail() {
        careerApplyPage.assertValidationMessageWhenEmailIsMissing();
    }

    @And("^User sets the 'Email' as \"([^\"]*)\"$")
    public void userSetsTheEmailAs(String email) {
        careerApplyPage.enterEmail(email);
    }

    @Then("^User should see the validation message to fill the Phone$")
    public void userShouldSeeTheValidationMessageToFillThePhone() {
        careerApplyPage.assertValidationMessageWhenPhoneIsMissing();
    }

    @And("^User sets the 'Phone' as \"([^\"]*)\"$")
    public void userSetsThePhoneAs(String phoneNumber) {
        careerApplyPage.enterPhone(phoneNumber);
    }

    @Then("^User should see the validation message to Upload a Resume file$")
    public void userShouldSeeTheValidationMessageToUploadAResumeFile() {
        careerApplyPage.assertValidationMessageWhenResumeIsMissing();
    }

    @And("^User selects the file to upload$")
    public void userSelectsTheFileToUpload() {
        careerApplyPage.selectFileToUpload();
    }

    @Then("^User should see the validation message for the 'Terms and Conditions' checkbox$")
    public void userShouldSeeTheValidationMessageForTheTermsAndConditionsCheckbox() {
        careerApplyPage.assertValidationMessageWhenTermsAndConditionCheckBoxIsNotChecked();
    }

    @Then("^User should see the validation message to enter a valid email address$")
    public void userShouldSeeTheValidationMessageToEnterAValidEmailAddress() {
        careerApplyPage.assertValidationMessageWhenEmailIsInvalid();
    }

    @When("^User sets the 'Title' as \"([^\"]*)\"$")
    public void userSetsTheTitleAs(String title) {
        careerApplyPage.enterTitle(title);
    }

    @And("^User sets the 'Address' as \"([^\"]*)\"$")
    public void userSetsTheAddressAs(String address) {
        careerApplyPage.enterAddress(address);
    }

    @And("^User selects the 'Position' as \"([^\"]*)\"$")
    public void userSelectsThePositionAs(String position) {
        careerApplyPage.selectPosition(position);
    }

    @And("^User selects the 'Job Type' as \"([^\"]*)\"$")
    public void userSelectsTheJobTypeAs(String jobType) {
        careerApplyPage.selectJobType(jobType);
    }

    @And("^User clicks the 'Terms and Conditions' checkbox$")
    public void userClicksTheTermsAndConditionsCheckbox() {
        careerApplyPage.clickTermsAndConditionsCheckBox();
    }

    @Then("^User should see the details submitted successfully message$")
    public void userShouldSeeTheDetailsSubmittedSuccessfullyMessage()  {
        careerApplyPage.assertSuccessfulMessage();
    }

    @And("^User can see the same values in the 'Position' dropdown as captured from the Career page$")
    public void userCanSeeTheSameValuesInThePositionDropdownAsCapturedFromTheCareerPage() {
        careerApplyPage.assertValuesDisplayedInPositionDropdown();
    }
}