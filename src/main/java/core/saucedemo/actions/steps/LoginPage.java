package core.saucedemo.actions.steps;

import core.saucedemo.actions.commons.BasePage;
import core.saucedemo.actions.commons.PageGeneratorManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static core.saucedemo.pageUI.LoginPageUI.*;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Login page with {0} / {1}")
    public Homepage signIn(String username, String password) {
        sendKeyToElement(USER_NAME,username);
        sendKeyToElement(PASS_WORD,password);
        clickToElement(LOGIN_BUTTON);
        return PageGeneratorManager.getHomePage(driver);
    }

    @Step("Verify [Login page] is displayed")
    public LoginPage verifyLoginPageIsDisplayed() {
        waitForElementVisible(TITLE_LOGIN);
        Assert.assertTrue(isElementDisplayed(TITLE_LOGIN));
        return this;
    }
}
