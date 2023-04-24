package core.saucedemo.actions.steps;

import core.saucedemo.actions.commons.BasePage;
import core.saucedemo.actions.commons.PageGeneratorManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

import static core.saucedemo.pageUI.HomePageUI.*;

public class Homepage extends BasePage {
    public Homepage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify [ Home Page] is displayed")
    public Homepage verifyLoginSuccess() {
        waitForElementVisible(TITLE_HOME_PAGE);
        Assert.assertTrue(isElementDisplayed(TITLE_HOME_PAGE));
        return this;
    }

    @Step("Click to [Menu] button")
    public Homepage clickToMenu() {
        waitForElementVisible(MENU_BUTTON);
        clickToElement(MENU_BUTTON);
        return this;
    }

    @Step("Click to [Logout] button")
    public LoginPage clickLogoutButton() {
        waitForElementVisible(LOGOUT_BUTTON);
        clickToElement(LOGOUT_BUTTON);
        return PageGeneratorManager.getLogin(driver);
    }
    @Step("Choose random a product and tap on [Add to cart] button")
    public Homepage clickRandomAddToCart() {
        waitForElementVisible(TITLE_HOME_PAGE);
        List<WebElement> elements = getListWebElement(LIST_PRODUCT);
        Random random = new Random();
        int x = random.nextInt(elements.size());
        for (int i = 0; i < elements.size(); i++) {
            if (i == x) {
                elements.get(i).click();
                break;
            }
        }
        return this;
    }

    @Step("Verify item in your cart is: {0}")
    public Homepage verifyItemAddToCart(String item) {
        waitForElementVisible(ITEM_CARD);
        Assert.assertEquals(getElementText(ITEM_CARD),item);
        return this;
    }

    @Step("Click to [Cart] icon")
    public YourCartPage clickYourCart() {
        waitForElementVisible(ITEM_CARD);
        clickToElement(ITEM_CARD);
        return PageGeneratorManager.getYourCart(driver);
    }
}
