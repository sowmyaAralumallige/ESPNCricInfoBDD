package stepDefinition;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import base.DbBase;
import pages.ESPNCricPage;

public class ESPNCricTest extends DbBase {

	DbBase db = new DbBase();	
	int matchTypeCount = 0;
	

	@Given("^I navigate to ESPNCricInfo webPage$")	
	public void getURL() {
		driver.get(db.webPageURL);
		driver.manage().window().maximize();		
	}


	@Given("^I have selected CountryEdition as \"(.*)\"$") 
	public void clickOnCountryEdition(String countryEditionToSelect) {
		Actions act = new Actions(driver);
		try {		
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ESPNCricPage.popUpCancel)));
			if(driver.findElement(By.xpath(ESPNCricPage.popUpCancel)).isDisplayed()) {
				driver.findElement(By.xpath(ESPNCricPage.popUpCancel)).click();
			}	

		}catch(Exception e) {
			e.printStackTrace();
		}

		WebElement countryEditionMenu = driver.findElement(By.xpath(ESPNCricPage.countryEdition));		
		act.moveToElement(countryEditionMenu).perform();		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ESPNCricPage.countryEditionOption)));
		List<WebElement> countryEditionOpt = driver.findElements(By.xpath(ESPNCricPage.countryEditionOption));
		for(WebElement country : countryEditionOpt) {
			if(country.getText().trim().equalsIgnoreCase(countryEditionToSelect)) {					
				country.click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ESPNCricPage.countryEditionIndia)));						
			}				
		}		
	}

	@When("^I click on MatchType as \"(.*)\"$")
	public void matchType(String matchTypeToSelect) {
		List<WebElement> matchTypesList = driver.findElements(By.xpath(ESPNCricPage.matchTypes));
		for(WebElement matchType : matchTypesList) {
			//			System.out.println(matchType.getText());
			if(matchType.getText().trim().contains(matchTypeToSelect)) {
				matchType.click();
				break;
			}			
		}				
	}

	@And("^captureMatchCount for the selected matchType \"(.*)\"$")
	public void matchTypeCount(String matchTypeToSelect) {		
		List<WebElement> matchTypesList = driver.findElements(By.xpath(ESPNCricPage.matchTypes));
		for(WebElement matchType : matchTypesList) {
			if(matchType.getText().trim().contains(matchTypeToSelect)) {
				if(matchType.isEnabled()) { 
					int pos= matchTypesList.indexOf(matchType);
					String matchTypeCnt = ESPNCricPage.getMatchTypeCountWebEl(pos+1);
					matchTypeCount = Integer.parseInt(driver.findElement(By.xpath(matchTypeCnt)).getText().replaceAll("[^0-9]", ""));
					break;
				}
			}			
		}				
	}

	@Then("^I verify MatchCount with MatchTiles and MatchCount should be same as MatchTiles Count$")
	public void getMatchTilesCount() {
		List<WebElement> matchTilesList = driver.findElements(By.xpath(ESPNCricPage.matchesTiles));
		int matchTilesCount = matchTilesList.size();
		Assert.assertEquals(matchTypeCount, matchTilesCount);
		System.out.println("MatchTypeCount Selected is "+ matchTypeCount +" same as matchTilesCount:- "+matchTilesCount);		
	}
	
	@Given("^I select CountryEdition as \"(.*)\"$") 
	public void selectCountryEdtion(String countryEditionToSelect) {
		Actions act = new Actions(driver);
		try {		
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ESPNCricPage.popUpCancel)));
			if(driver.findElement(By.xpath(ESPNCricPage.popUpCancel)).isDisplayed()) {
				driver.findElement(By.xpath(ESPNCricPage.popUpCancel)).click();
			}	

		}catch(Exception e) {
			System.out.println("StaleElementException occurred. wait again");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ESPNCricPage.popUpCancel)));
		}

		WebElement countryEditionMenu = driver.findElement(By.xpath(ESPNCricPage.countryEdition));		
		act.moveToElement(countryEditionMenu).perform();
		List<WebElement> countryEditionOpt = driver.findElements(By.xpath(ESPNCricPage.countryEditionOption));	
		for(WebElement country : countryEditionOpt) {
			if(country.getText().trim().equalsIgnoreCase(countryEditionToSelect)) {					
				country.click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ESPNCricPage.countryEditionIndia)));						
			}				
		}		
	}

	@When("^I click MatchType as \"(.*)\"$")
	public void selectMatchType(String matchTypeToSelect) {
		List<WebElement> matchTypesList = driver.findElements(By.xpath(ESPNCricPage.matchTypes));
		for(WebElement matchType : matchTypesList) {
			//			System.out.println(matchType.getText());
			if(matchType.getText().trim().contains(matchTypeToSelect)) {
				matchType.click();
				break;
			}			
		}				
	}
	
	@And("^captureMatchCount for selected matchType \"(.*)\"$")
	public void selectMatchTypeCount(String matchTypeToSelect) {		
		List<WebElement> matchTypesList = driver.findElements(By.xpath(ESPNCricPage.matchTypes));
		for(WebElement matchType : matchTypesList) {
			if(matchType.getText().trim().contains(matchTypeToSelect)) {
				if(matchType.isEnabled()) { 
					int pos= matchTypesList.indexOf(matchType);
					String matchTypeCnt = ESPNCricPage.getMatchTypeCountWebEl(pos+1);
					matchTypeCount = Integer.parseInt(driver.findElement(By.xpath(matchTypeCnt)).getText().replaceAll("[^0-9]", ""));
					break;
				}
			}			
		}				
	}

	@Then("^I exit application$")
	public void exit() {
		System.out.println("Closing all Driver Session... ");
		driver.quit();
	}

	
}
