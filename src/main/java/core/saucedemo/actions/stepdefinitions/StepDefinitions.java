package core.saucedemo.actions.stepdefinitions;

import core.saucedemo.actions.commons.BasePage;
import core.saucedemo.actions.driver.DriverManager;
import core.saucedemo.actions.steps.Homepage;
import core.saucedemo.actions.steps.LoginPage;
import core.saucedemo.actions.steps.YourCartPage;
import core.saucedemo.actions.utils.UserDataMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class StepDefinitions extends BasePage {
    UserDataMapper userData;
    LoginPage loginPage;
    private DriverManager driverManager;
    Homepage homepage;
    YourCartPage yourCartPage;


    public StepDefinitions() {
        userData = new UserDataMapper().getUserData();
        loginPage = new LoginPage(driver);
    }

//    @Parameters("browser")
//    @BeforeMethod
//    public void beforeClass(@Optional("chrome") String browserDriver) {
//        driverManager.getBrowserDriver(browserDriver);
//    }
//    @BeforeMethod(alwaysRun = true)
//    public void beforeMethod() {
//        userData = new UserDataMapper().getUserData();
//        loginPage = new LoginPage(driver);
//    }

    @Given("user navigates to the website")
    public void userNavigatesToTheWebsite() {
        driver = driverManager.getBrowserDriver("chrome");
    }

    @When("there user logs in through Login form by using Username as {string} and Password as {string}")
    public void thereUserLogsInThroughLoginFormByUsingUsernameAsAndPasswordAs(String arg0, String arg1) {
        throw new io.cucumber.java.PendingException();
    }

    @Then("login must be successful.")
    public void loginMustBeSuccessful() {
        throw new io.cucumber.java.PendingException();
    }

    @When("there user tap menu icon")
    public void thereUserTapMenuIcon() {
        throw new io.cucumber.java.PendingException();
    }

    @And("user tap to {string} button")
    public void userTapToButton(String arg0) {
        throw new io.cucumber.java.PendingException();
    }

    @Then("user navigates to the {string} form")
    public void userNavigatesToTheForm(String arg0) {
        throw new io.cucumber.java.PendingException();
    }

    @When("there user logs in through Login form by using Username as <userName> and Password as <password>")
    public void thereUserLogsInThroughLoginFormByUsingUsernameAsUserNameAndPasswordAsPassword() {
    }
}
