package mcat.cucumberTest;

/**
 * Created by Agung_P1706 on 09/02/2017.
 */
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/mcat/features/",
        glue = "mcat.StepDefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber",
        }

)
//@CucumberOptions(
//        strict = false,
//        features = "src/main/java/mcat/features/",
//        glue = "mcat.StepDefinitions",
//        format = {
//                "pretty",
//                "json:target/cucumber.json"
//        },
//        tags = { "~@ignore" }
//)
public class RunCukeTest {
}
