package testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


/*import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;*/

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/main/java/Features",
        glue= {"src/test/java/stepdefination"},
        //plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 
        monochrome = true
                )
public class Amztestrunner {
	
	

}
