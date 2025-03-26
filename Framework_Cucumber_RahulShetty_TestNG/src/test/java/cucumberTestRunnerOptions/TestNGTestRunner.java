package cucumberTestRunnerOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = ".//Features", glue = "stepDefinitions", dryRun = false, monochrome = true,
		// tags="@SmokeTest and @RegressionTest",
		// tags="@SmokeTest or @RegressionTest",
		// tags="not @RegressionTest"
		// tags="@PlaceOrder",

		// html, xml, json, junit, extent :
		// https://extentreports.com/docs/versions/4/java/cucumber4.html

		plugin = {

				"json:target/jsonReports/Cucumber.json", // This generates the JSON report
				"json:target/cucumber/report.json", "html:target/cucumber/reports/report.html", // Avoid conflicts here
				"pretty", // Optional: to make the output more readable
				"html:target/cucumber-reports", // Optional: if you want an HTML report as well
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failed_scenarios.txt" })
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	// The class can remain empty if it extends AbstractTestNGCucumberTests

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {

		return super.scenarios();

	}

}
