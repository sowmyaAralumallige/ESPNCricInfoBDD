package main.java.com.test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		 dryRun = false,	     
	     monochrome = true,
		features = {"C:/Users/225255/eclipse-workspace/CWS/ESPNCric/features/CricInfo.feature"},		
		glue={"StepDefinition","stepDefinitions"},	    
		plugin = {"pretty"}
)

public class TestRunner {

}

//features = {"C:\\Users\\225255\\eclipse-workspace\\CWS\\ESPNCric\\src\\test\\features"},
//glue={"StepDefs","C:\\Users\\225255\\eclipse-workspace\\CWS\\ESPNCric\\src\\test\\testStep"},
