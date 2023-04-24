package core.saucedemo.actions.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static core.saucedemo.actions.commons.GlobalConstants.LONG_TIMEOUT;
import static core.saucedemo.actions.commons.GlobalConstants.USER_PAGE_URL;

public class DriverManager {
    public WebDriver driver;
    public WebDriver getDriverInstance() {
        return this.driver;
    }
    protected WebDriver getBrowserDriver(String browserDriver) {
        if (browserDriver.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
//            disable-logging
            System.getProperty("webdriver.chrome.args", "--disable-logging");
            System.getProperty("webdriver.chrome.silentOutput", "true");
            ChromeOptions options = new ChromeOptions();
            // Setup lang for browser
            options.addArguments("--lang=vi");
            // Disable developer popup
            options.addArguments("--disable-infobars");
            // Disable notifications popup
            options.addArguments("--disable-notifications");
            // Disable location popup
            options.addArguments("--disable-geolocation");
            // Disable Automation info Bar popup
            options.setExperimentalOption("useAutomationExtension",false);
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            // Save password in chrome
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service",false);
            prefs.put("profile.password_manager_enabled",false);
            options.setExperimentalOption("prefs",prefs);
            driver = new ChromeDriver(options);
        } else if (browserDriver.equals("h_chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1920x1080");
            driver = new ChromeDriver(options);
        } else if (browserDriver.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
//            Setup lang for browser
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("intl.accept_languages", "vi-vn, vi, en-us, en");
            driver = new FirefoxDriver(options);
        } else if (browserDriver.equals("h_firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1920x1080");
            driver = new FirefoxDriver(options);
        } else if (browserDriver.equals("coccoc")) {
            WebDriverManager.chromedriver().driverVersion("102.0.5005.61").setup();
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
            driver = new ChromeDriver(options);
        } else {
            throw new RuntimeException("Browser name invalid.");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(LONG_TIMEOUT));
        driver.get(USER_PAGE_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        return driver;
    }
}
