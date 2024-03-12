package Factory;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {
    private static WebDriver driver;

    public static  WebDriver initializeBrowser(String browserName) throws InterruptedException {
        if (driver == null) {
            if (browserName.equalsIgnoreCase("chrome")) {
                Thread.sleep(5000);
            Map<String, Object> pref = new HashMap<>();

            pref.put("profile.default_content_setting_values.notifications", 2);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.setExperimentalOption("prefs", pref);
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--allow-file-access-from-files");
            chromeOptions.addArguments("--allow-file-access");
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
            WebDriverManager.chromedriver().setup();

             driver= new ChromeDriver(chromeOptions);
            } else if (browserName.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
            }
             
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
        return driver;
       
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver has not been initialized. Call initializeBrowser() first.");
     
        }
        return driver;
    }

    public static WebDriver quitDriver() {
        if (driver != null) {
            driver.quit();
            return driver;
        } else {
            return null; // Return null if the driver instance is already null
        }
    }
}

