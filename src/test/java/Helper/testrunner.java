package Helper;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/Features"} ,
        glue= {"Step_definition"},
        plugin = {"json:target/cucumber.json","html:target/report/cucumber-pretty"},
        tags = {"@Google"}
)
public class testrunner {
}
