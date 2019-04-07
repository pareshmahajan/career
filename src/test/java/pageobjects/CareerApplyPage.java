package pageobjects;

import com.google.inject.Inject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import support.World;

import java.text.Collator;
import java.util.Locale;

public class CareerApplyPage extends BasePage {

    private static final String ERROR_MESSAGE_FOR_BLANK_FIELD = "Please fill out this field.";

    @FindBy(tagName = "h2")
    private WebElement h2Tag;

    @FindBy(css = "button.btn:nth-child(1)")
    private WebElement submitBtn;

    @FindBy(id = "Title")
    private WebElement titleText;

    @FindBy(id = "Full Name")
    private WebElement fullNameText;

    @FindBy(id = "Email")
    private WebElement emailText;

    @FindBy(id = "Address")
    private WebElement addressText;

    @FindBy(xpath = "//input[@placeholder='Phone']")
    private WebElement phoneText;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement termsAndConditionsChkBox;

    @FindBy(name = "file")
    private WebElement uploadFile;

    @FindBy(name = "position")
    private WebElement positionSelectList;

    @FindBy(name = "jobtype")
    private WebElement jobTypeSelectList;

    @FindBy(id = "career-form")
    private WebElement careerForm;

    @Inject
    public CareerApplyPage(World world) {
        super(world);
    }

    public void verifyCareerApplyPageRendered() {
        getWebDriverWait().until(ExpectedConditions.textToBePresentInElement(h2Tag,
                "APPLY NOW TO JOIN US"));
    }

    public void clickSubmitButton() {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
    }

    public void assertValidationMessageWhenFullNameIsMissing() {

        getWebDriverWait().until(
                ExpectedConditions.attributeContains(
                        fullNameText,
                        "validationMessage",
                        ERROR_MESSAGE_FOR_BLANK_FIELD)
        );
    }

    public void enterFullName(String fullName) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(fullNameText));
        fullNameText.sendKeys(fullName);
    }

    public void assertValidationMessageWhenEmailIsMissing() {
        getWebDriverWait().until(
                ExpectedConditions.attributeContains(
                        emailText,
                        "validationMessage",
                        ERROR_MESSAGE_FOR_BLANK_FIELD)
        );
    }

    public void enterEmail(String email) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(emailText));
        emailText.sendKeys(email);
    }

    public void assertValidationMessageWhenPhoneIsMissing() {
        getWebDriverWait().until(
                ExpectedConditions.attributeContains(
                        phoneText,
                        "validationMessage",
                        ERROR_MESSAGE_FOR_BLANK_FIELD)
        );
    }

    public void enterPhone(String phoneNumber) {
        getWebDriverWait().until(ExpectedConditions.attributeContains(
                phoneText, "id", "phone"));
        phoneText.sendKeys(phoneNumber);
    }

    public void assertValidationMessageWhenResumeIsMissing() {
        String errorMessage = "Please select a file.";
        getWebDriverWait().until(
                ExpectedConditions.attributeContains(
                        uploadFile,
                        "validationMessage",
                        errorMessage)
        );
    }

    public void selectFileToUpload() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(uploadFile));
        String filePath = System.getProperty("user.dir")+"/src/test/resources/data/resume.txt";
        uploadFile.sendKeys(filePath);
    }

    public void assertValidationMessageWhenTermsAndConditionCheckBoxIsNotChecked() {
        String errorMessage = "Please check this box if you want to proceed.";
        getWebDriverWait().until(
                ExpectedConditions.attributeContains(
                        termsAndConditionsChkBox,
                        "validationMessage",
                        errorMessage)
        );
    }

    public void assertValidationMessageWhenEmailIsInvalid() {
        String errorMessage = "Please enter an email address.";
        getWebDriverWait().until(
                ExpectedConditions.attributeContains(
                        emailText,
                        "validationMessage",
                        errorMessage)
        );
    }

    public void enterTitle(String title) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(fullNameText));
        titleText.sendKeys(title);
    }

    public void enterAddress(String address) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(addressText));
        addressText.sendKeys(address);
    }

    public void selectPosition(String position) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(positionSelectList));
        Select positionDropDown = new Select(positionSelectList);
        positionDropDown.selectByVisibleText(position);
    }

    public void selectJobType(String jobType) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(jobTypeSelectList));
        Select jobTypeDropDown = new Select(jobTypeSelectList);
        jobTypeDropDown.selectByVisibleText(jobType);
    }

    public void clickTermsAndConditionsCheckBox() {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(termsAndConditionsChkBox)).click();
    }

    public void assertSuccessfulMessage() {
        String successMessage = "<strong>Success</strong> Your message was sent successfully! We will be in touch as soon as we can.";
        getWebDriverWait().until(
                ExpectedConditions.attributeContains(
                        careerForm,
                        "innerHTML",
                        successMessage)
        );
    }

    public void assertValuesDisplayedInPositionDropdown() {
        Collator collator = Collator.getInstance(Locale.GERMAN);
        collator.setStrength(Collator.PRIMARY);

        getWebDriverWait().until(ExpectedConditions.visibilityOf(positionSelectList));
        Select positionDropDown = new Select(positionSelectList);

        int size = positionDropDown.getOptions().size();

        for (int i = 0; i < size - 1; i++) {
            Assert.assertTrue(collator.equals(getScenarioData().getPositionList().get(i),
                    positionDropDown.getOptions().get(i+1).getText()));
        }
    }
}
