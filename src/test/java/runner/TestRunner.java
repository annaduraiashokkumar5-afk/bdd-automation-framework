package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        //plugin = {"pretty", "json:target/cucumber-reports/cucumber.json", "html:target/cucumber-reports/cucumber.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, monochrome = true
        plugin = {"pretty", "html:test-output/cucumber-report.html", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}, monochrome = true
)
public class    TestRunner extends AbstractTestNGCucumberTests {
}
