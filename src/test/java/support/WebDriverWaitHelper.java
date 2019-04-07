package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

class WebDriverWaitHelper {

    private WebDriverWait webDriverWait;

    private WebDriverWait createWebDriverWait(WebDriver driver) {
        return webDriverWait = new WebDriverWait(driver,30);
    }

    WebDriverWait getWaitInstance(WebDriver driver){
        if (webDriverWait == null) {
            this.createWebDriverWait(driver);
        }
        return webDriverWait;
    }
}
