package core.saucedemo.actions.commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public BasePage() {
    }

    public void waitForElementVisible(By xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(xpathLocator));
    }

    private WebElement getWebElement(By xpathLocator) {
        return driver.findElement(xpathLocator);
    }

    public void sendKeyToElement(By xpathLocator, String textValue) {
        WebElement element = getWebElement(xpathLocator);
        element.clear();
        element.sendKeys(textValue);
    }

    public void clickToElement(By xpathLocator) {
        getWebElement(xpathLocator).click();
    }

    public String getElementText(By xpathLocator) {
        return getWebElement(xpathLocator).getText();
    }

    public boolean isElementDisplayed(By xpathLocator) {
        try {
            return getWebElement(xpathLocator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public List<WebElement> getListWebElement(By xpathLocator) {
        return driver.findElements(xpathLocator);
    }
}
