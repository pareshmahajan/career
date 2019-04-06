package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CareerStepDef {

    private WebDriver webDriver;

    @When("^User opens career site of the hexad website$")
    public void userOpensCareerSiteOfTheHexadWebsite(){
        System.setProperty("webdriver.gecko.driver", "./src/test/resources/drivers/geckodriver");
        webDriver = new FirefoxDriver();

        webDriver.get("https://hexad.de/en/careers.html");

    }

    @Then("^Career page is rendered$")
    public void careerPageIsRendered() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("WE HAVE BEEN LOOKING FOR YOU" ,webDriver.findElement(By.tagName("h2")).getText());
    }

    @After
    public void quitBrowser(){
        webDriver.quit();
    }
}
