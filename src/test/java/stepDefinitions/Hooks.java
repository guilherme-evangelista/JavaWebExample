package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
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
            ScenarioRepository.screenShot();
        }
        DriverFactory.quitDriver();
        ScenarioRepository.remove();
    }
}