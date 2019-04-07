package steps;

import com.google.inject.Inject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

    @When("^User clicks the Submit Button$")
    public void userClicksTheSubmitButton() {
        careerApplyPage.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(careerApplyPage.submitBtn))
                .click();
    }

    @Then("^User should see the validation message to fill the Full Name$")
    public void userShouldSeeTheValidationMessageToFillTheFullName()  {
        careerApplyPage.getWebDriverWait().until(
                ExpectedConditions.attributeContains(
                        careerApplyPage.fullNameText,
                        "validationMessage",
                        "Please fill out this field."));
    }

    @When("^User sets the 'Full Name' as \"([^\"]*)\"$")
    public void userSetsTheFullNameAs(String fullName) {
        careerApplyPage.getWebDriverWait().until(ExpectedConditions.visibilityOf(careerApplyPage.fullNameText));
        careerApplyPage.fullNameText.sendKeys(fullName);
    }

    @Then("^User should see the validation message to fill the Email$")
    public void userShouldSeeTheValidationMessageToFillTheEmail() {
        careerApplyPage.getWebDriverWait().until(
                ExpectedConditions.attributeContains(
                        careerApplyPage.emailText,
                        "validationMessage",
                        "Please fill out this field."));
    }

    @And("^User sets the 'Email' as \"([^\"]*)\"$")
    public void userSetsTheEmailAs(String email) {
        careerApplyPage.getWebDriverWait().until(ExpectedConditions.visibilityOf(careerApplyPage.emailText));
        careerApplyPage.emailText.sendKeys(email);
    }

    @Then("^User should see the validation message to fill the Phone$")
    public void userShouldSeeTheValidationMessageToFillThePhone() {
        careerApplyPage.getWebDriverWait().until(
                ExpectedConditions.attributeContains(
                        careerApplyPage.phoneText,
                        "validationMessage",
                        "Please fill out this field."));
    }

    @And("^User sets the 'Phone' as \"([^\"]*)\"$")
    public void userSetsThePhoneAs(String phoneNumber) {
        careerApplyPage.getWebDriverWait().until(ExpectedConditions.attributeContains(
                careerApplyPage.phoneText, "id", "phone"));
        careerApplyPage.phoneText.sendKeys(phoneNumber);
    }

    @Then("^User should see the validation message to Upload a Resume file$")
    public void userShouldSeeTheValidationMessageToUploadAResumeFile() {
        careerApplyPage.getWebDriverWait().until(
                ExpectedConditions.attributeContains(
                        careerApplyPage.uploadFile,
                        "validationMessage",
                        "Please select a file."));
    }

    @And("^User selects the file to upload$")
    public void userSelectsTheFileToUpload() {
        careerApplyPage.getWebDriverWait().until(ExpectedConditions.visibilityOf(careerApplyPage.uploadFile));
        careerApplyPage.uploadFile.sendKeys("/Users/pareshmahajan/career/src/test/resources/data/resume.txt");
    }

    @Then("^User should see the validation message for the 'Terms and Conditions' checkbox$")
    public void userShouldSeeTheValidationMessageForTheTermsAndConditionsCheckbox() {
        String errorMessage = "Please check this box if you want to proceed.";
        careerApplyPage.getWebDriverWait().until(
                ExpectedConditions.attributeContains(
                        careerApplyPage.termsAndConditionsChkBox,
                        "validationMessage",
                        errorMessage));
    }

    @Then("^User should see the validation message to enter a valid email address$")
    public void userShouldSeeTheValidationMessageToEnterAValidEmailAddress() {
        careerApplyPage.getWebDriverWait().until(
                ExpectedConditions.attributeContains(
                        careerApplyPage.emailText,
                        "validationMessage",
                        "Please enter an email address."));
    }

    @When("^User sets the 'Title' as \"([^\"]*)\"$")
    public void userSetsTheTitleAs(String title) {
        careerApplyPage.getWebDriverWait().until(ExpectedConditions.visibilityOf(careerApplyPage.fullNameText));
        careerApplyPage.titleText.sendKeys(title);
    }

    @And("^User sets the 'Address' as \"([^\"]*)\"$")
    public void userSetsTheAddressAs(String address) {
        careerApplyPage.getWebDriverWait().until(ExpectedConditions.visibilityOf(careerApplyPage.addressText));
        careerApplyPage.addressText.sendKeys(address);
    }

    @And("^User selects the 'Position' as \"([^\"]*)\"$")
    public void userSelectsThePositionAs(String position) {
        careerApplyPage.getWebDriverWait().until(ExpectedConditions.visibilityOf(careerApplyPage.positionSelectList));
        Select positionDropDown = new Select(careerApplyPage.positionSelectList);
        positionDropDown.selectByVisibleText(position);
    }

    @And("^User selects the 'Job Type' as \"([^\"]*)\"$")
    public void userSelectsTheJobTypeAs(String jobType) {
        careerApplyPage.getWebDriverWait().until(ExpectedConditions.visibilityOf(careerApplyPage.jobTypeSelectList));
        Select jobTypeDropDown = new Select(careerApplyPage.jobTypeSelectList);
        jobTypeDropDown.selectByVisibleText(jobType);
    }

    @And("^User clicks the 'Terms and Conditions' checkbox$")
    public void userClicksTheTermsAndConditionsCheckbox() {
        careerApplyPage.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(careerApplyPage.termsAndConditionsChkBox))
                .click();
    }

    @Then("^User should see the details submitted successfully message$")
    public void userShouldSeeTheDetailsSubmittedSuccessfullyMessage()  {
        String successMessage = "<strong>Success</strong> Your message was sent successfully! We will be in touch as soon as we can.";
        careerApplyPage.getWebDriverWait().until(
                ExpectedConditions.attributeContains(
                        careerApplyPage.careerForm,
                        "innerHTML",
                        successMessage));
    }
}