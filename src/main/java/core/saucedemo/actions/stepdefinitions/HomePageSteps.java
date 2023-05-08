package core.saucedemo.actions.stepdefinitions;

import core.saucedemo.actions.commons.PageGeneratorManager;
import core.saucedemo.actions.driver.Hooks;
import core.saucedemo.actions.steps.Homepage;
import core.saucedemo.actions.steps.LoginPage;
import core.saucedemo.actions.utils.UserDataMapper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static core.saucedemo.pageUI.HomePageUI.LIST_NAME_PRODUCT;

public class HomePageSteps {

    WebDriver driver;
    LoginPage loginPage;
    Homepage homepage;
    UserDataMapper userData;
    TestContext testContext;

    public HomePageSteps(TestContext testContext) {
        this.driver = Hooks.openAndQuitBrowser();
        loginPage = PageGeneratorManager.getLogin(driver);
        homepage = PageGeneratorManager.getHomePage(driver);
        userData = new UserDataMapper().getUserData();
        this.testContext = testContext;
    }

    @Then("login must be successful.")
    public void login_must_be_successful() {
        homepage.verifyLoginSuccess();
    }

    @Then("the cart icon has {string} item")
    public void theCartIconHasItem(String item) {
        homepage.verifyItemAddToCart(item);
    }

    @When("the user can tap cart icon")
    public void theUserCanTapCartIcon() {
        homepage.clickYourCart();
    }

    @When("the user choose a product and add them to the cart")
    public void theUserChooseAProductAndAddThemToTheCart() {
        homepage.clickRandomAddToCart();
        testContext.getScenarioContext().setContext(DataContext.LIST_NAME_PRODUCT, loginPage.getListWebElement(LIST_NAME_PRODUCT).get(0).getText());
    }
}
