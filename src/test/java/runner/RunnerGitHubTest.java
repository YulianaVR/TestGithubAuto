package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"steps"},
        plugin = {"pretty",
                "junit:target/cucumber-reports.xml",
                "json:target/cucumber-reports.json",
                "html:target/cucumber-reports.html"},
        monochrome = true,
        tags = "@Test"
)

public class RunnerGitHubTest {
    @AfterClass
    public static void cleanDriver() {

        BasePage.closeBrowser();
    }
}
