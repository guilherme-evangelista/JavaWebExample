package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {

    public static WebDriver createInstance(String browserName) {
        WebDriver driver;

        switch (browserName.toLowerCase()) {
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = new EdgeDriver(edgeOptions);
                break;

            case "chrome":
            default:
                ChromeOptions chromeOptions = new ChromeOptions();

                chromeOptions.addArguments("--headless=new");
                chromeOptions.addArguments("--window-size=1920,1080");

                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--disable-gpu");

                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--disable-notifications");

                driver = new ChromeDriver(chromeOptions);
                break;
        }

        return driver;
    }
}