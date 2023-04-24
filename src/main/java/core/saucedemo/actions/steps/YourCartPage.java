package core.saucedemo.actions.steps;

import core.saucedemo.actions.commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static core.saucedemo.pageUI.YourCartPageUI.*;

public class YourCartPage extends BasePage {
    public YourCartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify [Your Cart] title is displayed")
    public YourCartPage verifyYourCartPageIsDisplayed() {
        waitForElementVisible(YOUR_CART_TITLE);
        Assert.assertTrue(isElementDisplayed(YOUR_CART_TITLE));
        return this;
    }
}
