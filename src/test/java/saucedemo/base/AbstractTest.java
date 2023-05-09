package saucedemo.base;
import com.google.common.collect.ImmutableMap;
import core.saucedemo.actions.driver.DriverManager;
import org.testng.annotations.*;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import static core.saucedemo.actions.commons.GlobalConstants.USER_PAGE_URL;


public class AbstractTest extends DriverManager {

    @Parameters("browser")
    @BeforeMethod
    public void beforeClass(@Optional("chrome") String browserDriver) {
        getBrowserDriver(browserDriver);
    }

    @BeforeMethod
    public void setAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder().put("Browser", "Chrome").put("Browser.Version", "70.0.3538.77")
                        .put("URL", USER_PAGE_URL).build(),
                System.getProperty("user.dir") + "/allure-results/");
    }

    @AfterMethod(alwaysRun = true)
    public void afterClass() {
       closeBrowserDriver();
    }

}
