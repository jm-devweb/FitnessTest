package fitness;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = false,
        features = {"classpath:set"},
        glue = {"fitness"},
        plugin = {"pretty", "html:target/cucumber"})
public class SetTest {
}

