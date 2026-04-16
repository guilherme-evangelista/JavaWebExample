package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.report.screenshot.ScenarioRepository;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        DriverFactory.initDriver("chrome");
        ScenarioRepository.add(scenario);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot de Erro");
        }
        DriverFactory.quitDriver();
        ScenarioRepository.remove();
    }
}