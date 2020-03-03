package qa.dar.my.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "Features" }, 
       glue = { "qa.dar.stepdefinition" }, 
       plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html", "pretty",
		"json:target/cucumber-reports/cucumber.json" }, 
       monochrome = true, 
       dryRun = false)
    
    public class MyRunnerTest extends AbstractTestNGCucumberTests {
	
/*	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("./extent-config.xml"));

	}*/
}
