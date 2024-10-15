package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(		
		features = {"src/test/resources/feature"},	
		glue = {"stepDefinition"},	    
		plugin = {"pretty"},
		dryRun = false,	     
		monochrome = true
)

public class TestRunner {

}
