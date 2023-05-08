package core.saucedemo.actions.stepdefinitions;

import core.saucedemo.actions.commons.PageGeneratorManager;
import core.saucedemo.actions.driver.Hooks;
import core.saucedemo.actions.steps.Homepage;
import core.saucedemo.actions.steps.LoginPage;
import core.saucedemo.actions.utils.UserDataMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class LoginPageSteps {
    WebDriver driver;
    LoginPage loginPage;
    Homepage homepage;
    UserDataMapper userData;
    TestContext testContext;

    public LoginPageSteps(TestContext testContext) {
        this.driver = Hooks.openAndQuitBrowser();
        loginPage = PageGeneratorManager.getLogin(driver);
        homepage = PageGeneratorManager.getHomePage(driver);
        userData = new UserDataMapper().getUserData();
        this.testContext = testContext;

    }

    @Given("user navigates to the website {string}")
    public void user_navigates_to_the_website(String url) {
        testContext.getScenarioContext().setContext(DataContext.LOGIN_URL, loginPage.getPageUrl());
        Assert.assertEquals(testContext.getScenarioContext().getContext(DataContext.LOGIN_URL), url);
    }

    @When("the user can input a username and password")
    public Homepage theUserCanInputAUsernameAndPassword() {
        homepage = loginPage.signIn(userData.getUsername(), userData.getPassword());
        return homepage;
    }
}
