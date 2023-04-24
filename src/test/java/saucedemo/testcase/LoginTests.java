package saucedemo.testcase;

import core.saucedemo.actions.utils.UserDataMapper;
import core.saucedemo.actions.reports.AllureTestListener;
import core.saucedemo.actions.steps.Homepage;
import core.saucedemo.actions.steps.LoginPage;
import core.saucedemo.actions.steps.YourCartPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import saucedemo.base.AbstractTest;

@Listeners(AllureTestListener.class)
public class LoginTests extends AbstractTest {
    UserDataMapper userData;
    LoginPage loginPage;
    Homepage homepage;
    YourCartPage yourCartPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        userData = new UserDataMapper().getUserData();
        loginPage = new LoginPage(driver);
    }


    @Test(priority = 2, groups = {"login"})
    public void Login() {
        homepage = loginPage.signIn(userData.getUsername(), userData.getPassword());
        homepage.verifyLoginSuccess();
    }

    @Test(priority = 2, groups = {"login"})
    public void Logout() {
        homepage = loginPage.signIn(userData.getUsername(), userData.getPassword());
        homepage.verifyLoginSuccess();
        homepage.clickToMenu()
                .clickLogoutButton()
                .verifyLoginPageIsDisplayed();
    }

    @Test(priority = 1, groups = {"cart"})
    public void ViewCart() {
        homepage = loginPage.signIn(userData.getUsername(), userData.getPassword());
        homepage.verifyLoginSuccess();
        homepage.clickToMenu()
                .clickRandomAddToCart()
                .clickRandomAddToCart()
                .verifyItemAddToCart("2");
    }

    @Test(priority = 1, groups = {"cart"})
    public void ViewYourCart() {
        homepage = loginPage.signIn(userData.getUsername(), userData.getPassword());
        homepage.verifyLoginSuccess();
        homepage.clickToMenu()
                .clickRandomAddToCart()
                .clickRandomAddToCart()
                .verifyItemAddToCart("2");
        yourCartPage = homepage.clickYourCart();
        yourCartPage.verifyYourCartPageIsDisplayed();
    }

}
