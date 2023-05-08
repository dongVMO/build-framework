package core.saucedemo.actions.commons;

import core.saucedemo.actions.stepdefinitions.LoginPageSteps;
import core.saucedemo.actions.steps.Homepage;
import core.saucedemo.actions.steps.LoginPage;
import core.saucedemo.actions.steps.YourCartPage;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static Homepage getHomePage(WebDriver driver){
        return new Homepage(driver);
    }
    public static LoginPage getLogin(WebDriver driver){
        return new LoginPage(driver);
    }
    public static YourCartPage getYourCart(WebDriver driver){
        return new YourCartPage(driver);
    }
}
