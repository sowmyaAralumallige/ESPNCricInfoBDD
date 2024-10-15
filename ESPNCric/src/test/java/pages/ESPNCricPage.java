package pages;

public class ESPNCricPage {	
	public static final String matchTypes = "//div[contains(@class,'ds-flex ds-flex-row')]/div//span[contains(@class,'ds-items-center')]/span";	
	public static final String matchesCount = "//div[contains(@class,'ds-flex ds-flex-row')]/div[1]//span[contains(@class,'ds-items-center')]/span/span";	
	public static final String ranjiTrophyCount = "//div[contains(@class,'ds-flex ds-flex-row')]/div[3]//span[contains(@class,'ds-items-center')]/span/span";
	public static final String ranjiTrophyPlateCount = "//div[contains(@class,'ds-flex ds-flex-row')]/div[4]//span[contains(@class,'ds-items-center')]/span/span";
	public static final String womensT20WorldCup = "//div[contains(@class,'ds-flex ds-flex-row')]/div[5]//span[contains(@class,'ds-items-center')]/span/span";
	public static final String matchesTiles = "//div[@class='ds-pt-2']//div[@class='slick-track']/div/following-sibling::div";
	public static final String countryEditionOption = "//div[@id='tippy-9']//div[@class='tippy-content']//li";
	public static final String countryEdition = "//div[contains(text(),'Edition')]";
//	public static final String countryEditionIndia = "//div[text()='Edition IN']";
	public static final String countryEditionIndia = "//div[contains(text(),'Edition')]";	
	
	public static final String popUp = "//*[@id='wzrk_wrapper']/div[2]";
	public static final String popUpCancel = "//*[@id='wzrk-cancel']";
	
	public static String getMatchTypeCountWebEl(int cnt) {
		String matcheTypeCount = "//div[contains(@class,'ds-flex ds-flex-row')]/div["+cnt+"]//span[contains(@class,'ds-items-center')]/span/span";
		return matcheTypeCount;
	}
}
