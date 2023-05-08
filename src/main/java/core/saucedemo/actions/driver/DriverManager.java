package core.saucedemo.actions.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;
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
    public WebDriver getBrowserDriver(String browserDriver) {
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
    public void closeBrowserDriver(){
        String cmd = "";
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            String driverInstanceName = driver.toString().toLowerCase();
            if (driverInstanceName.contains("chrome")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
                } else {
                    cmd = "pkill chromedriver";
                }
            } else if (driverInstanceName.contains("internetexplorer")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
                }
            } else if (driverInstanceName.contains("firefox")) {
                if (osName.contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
                } else {
                    cmd = "pkill geckodriver";
                }
            } else if (driverInstanceName.contains("edge")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
                } else {
                    cmd = "pkill msedgedriver";
                }
            } else if (driverInstanceName.contains("opera")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
                } else {
                    cmd = "pkill operadriver";
                }
            } else if (driverInstanceName.contains("safari")) {
                if (osName.contains("mac")) {
                    cmd = "pkill safaridriver";
                }
            }

            if (driver != null) {
                // IE
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
