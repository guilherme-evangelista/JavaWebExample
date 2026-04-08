package factory;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void initDriver(String browser) {
        if (getDriver() == null) {
            driver.set(BrowserFactory.createInstance(browser));
            getDriver().manage().window().setSize(new Dimension(1920, 1080));
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        }
    }

    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}