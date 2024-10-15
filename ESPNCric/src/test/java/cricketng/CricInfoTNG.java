package cricketng;

import org.testng.annotations.Test;

import base.DbBase;
import stepDefinition.ESPNCricTest;
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
	
//	@Test
//	public void cricInfoTestCntry() {
//		ESPNCricTest cricTest = new ESPNCricTest();
//		cricTest.getURL();
//		cricTest.clickOnCountryEdition("Australia");
//		cricTest.matchType("Spring Challenge");
//		cricTest.matchTypeCount("Spring Challenge");
//		cricTest.getMatchTilesCount();
//	}

	@BeforeSuite
	public void beforeSuite() {
		DbBase.setProperty();
	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}

}
