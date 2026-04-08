package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        tags = "@regressivo",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-html.html",
                "json:target/cucumber-reports/cucumber.json"
        },
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunTests extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}