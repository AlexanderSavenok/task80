package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Driver {

    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
    }

    private static WebDriver driver;

    public static WebDriver getWebDriver(String url) {
        return getChromeDriver(url);
    }

    private static WebDriver getChromeDriver(String url) {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, setChromeOptions());
        driver = new ChromeDriver(setChromeOptions());
        driver.get(url);
        defaultSettings(driver);
        return driver;
    }

    private static void defaultSettings(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    private static ChromeOptions setChromeOptions() {
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", new File("src/main/resources/downloadedFiles").getAbsolutePath());
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        return options;
    }
}