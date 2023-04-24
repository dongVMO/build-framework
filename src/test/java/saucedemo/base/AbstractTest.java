package saucedemo.base;

import core.saucedemo.actions.driver.DriverManager;
import org.testng.annotations.*;

import java.io.IOException;


public class AbstractTest extends DriverManager {

    @Parameters("browser")
    @BeforeMethod
    public void beforeClass(@Optional("chrome") String browserDriver) {
        getBrowserDriver(browserDriver);
    }

    @AfterMethod(alwaysRun = true)
    public void afterClass() {
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

//    @AfterSuite(alwaysRun = true)
//    public void allureReport() {
//
//        System.getProperty(PROJECT_PATH);
//        System.out.println(PROJECT_PATH);
//        System.out.println(PROJECT_PATH + "\\allure-results");
////        String cmd = "allure serve " +( projectPath + "\\allure-results");
//        String[] cmd = {"allure", "serve",PROJECT_PATH + "\\allure-results"};
//        try {
//
//            Runtime.getRuntime().exec(cmd);
//            Thread.sleep(90000);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

}
