package test.circtng;

import org.testng.annotations.Test;

import test.base.DbBase;
import test.java.StepDefinitions.ESPNCricTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class CricInfoTNG extends DbBase {

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Launching ChromeBrowser");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("closing ChromeBrowser");
		driver.quit();
	}

	@Test
	public void cricInfoTest() {
		ESPNCricTest cricTest = new ESPNCricTest();		
		cricTest.getURL();
		cricTest.clickOnCountryEdition("India");
		cricTest.matchType("Ranji Trophy");
		cricTest.matchTypeCount("Ranji Trophy");
		cricTest.getMatchTilesCount();
	}

	@BeforeSuite
	public void beforeSuite() {
		DbBase.setProperty();
	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}

}
