package cucumberTestRunnerOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "@target/failed_scenarios.txt", glue = "stepDefinitions", dryRun = false, monochrome = true,
		// html, xml, json, junit, extent :
		// https://extentreports.com/docs/versions/4/java/cucumber4.html
		plugin = { "pretty", "html:target/cucumber.html", "json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				})
public class FailedTestNGTestRunner extends AbstractTestNGCucumberTests {
	// The class can remain empty if it extends AbstractTestNGCucumberTests

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {

		return super.scenarios();

	}

}
