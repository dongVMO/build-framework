package core.saucedemo.actions.stepdefinitions;

import core.saucedemo.actions.commons.PageGeneratorManager;
import core.saucedemo.actions.driver.Hooks;
import core.saucedemo.actions.steps.Homepage;
import core.saucedemo.actions.steps.LoginPage;
import core.saucedemo.actions.steps.YourCartPage;
import core.saucedemo.actions.utils.UserDataMapper;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static core.saucedemo.pageUI.YourCartPageUI.LIST_NAME_PRODUCT;

public class YourCartPageSteps {
    WebDriver driver;

    Homepage homepage;
    YourCartPage yourCartPage;
    TestContext testContext;


    public YourCartPageSteps(TestContext testContext) {
        this.driver = Hooks.openAndQuitBrowser();
        homepage = PageGeneratorManager.getHomePage(driver);
        yourCartPage = PageGeneratorManager.getYourCart(driver);
        this.testContext = testContext;
    }

    @Then("name product is displayed same name product added")
    public void name_product_is_displayed_same_name_product_added() {
        yourCartPage.verifyYourCartPageIsDisplayed();
        Assert.assertEquals(testContext.getScenarioContext().getContext(DataContext.LIST_NAME_PRODUCT), yourCartPage.getElementText(LIST_NAME_PRODUCT));
    }

}
