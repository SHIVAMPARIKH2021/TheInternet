package pagepackage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseTest;

public class Index extends BaseTest {

Actions action;
	
	public Index(){
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@class='mds-search-field__input__mds-nuxt'  and @aria-label='Search']")
	private static WebElement SearchField;
	
	@FindBy(xpath="//input[@class='mds-search-field__input__mds-nuxt'  and @aria-label='Index Name']")
	private static WebElement KeyWordField;
	
	@FindBy(xpath="//span[text()='All Indexes']")
	private static WebElement AllIndexes;
	
	@FindBy(xpath="//span[text()='Equity']")
	private static WebElement Equity;
	
	@FindBy(xpath="//span[contains(text(),'Equity') and @class='mds-checkbox__text__mds-nuxt' ]")
	private static WebElement EquityDD;
	
	@FindBy(xpath="//span[text()='Fixed Income']")
	private static WebElement FixedIncome;
	
	@FindBy(xpath="//span[contains(text(),'Fixed Income') and @class='mds-checkbox__text__mds-nuxt' ]")
	private static WebElement FixedIncomeDD;
	
	@FindBy(xpath="//span[text()='Multi Asset']")
	private static WebElement MultiAsset;
	
	@FindBy(xpath="//span[contains(text(),'Multi Asset') and @class='mds-checkbox__text__mds-nuxt' ]")
	private static WebElement MultiAssetDD;
	
	@FindBy(xpath="//span[text()='Alternatives']")
	private static WebElement Alternatives;
	
	@FindBy(xpath="//span[contains(text(),'Alternatives') and @class='mds-checkbox__text__mds-nuxt' ]")
	private static WebElement AlternativesDD;
	
	@FindBy(xpath="//span[text()='Private Markets']")
	private static WebElement PrivateMarket;
	
	@FindBy(xpath="//span[contains(text(),'Private Market') and @class='mds-checkbox__text__mds-nuxt' ]")
	private static WebElement PrivateMarketDD;
	
	@FindBy(xpath="//span[@class='mds-checkbox__text__mds-nuxt'and contains(text(),'Strategic Beta')]")
	private static WebElement StrategicBeta;
	
	@FindBy(xpath="//span[text()='ESG']")
	private static WebElement ESG;
	
	@FindBy(xpath="//span[@class='mds-checkbox__text__mds-nuxt' and contains(text(),'ESG')]")
	private static WebElement ESGIndex;
	
	@FindBy(xpath="(//span[@class='mds-combo-box__placeholder__mds-nuxt' and contains(text(),'Select Option')])[1]")
	private static WebElement IndexFamily;
	
	@FindBy(xpath="//li[contains(@id,'mds-combo-box__descendent')]")
	private static List<WebElement> IndexFamilyList;
	
	@FindBy(xpath="(//span[@class='mds-combo-box__placeholder__mds-nuxt' and contains(text(),'Select Option')])[2]")
	private static WebElement GeoRegion;
	
	@FindBy(xpath="//li[contains(@id,'mds-combo-box__descendent')]")
	private static List<WebElement> GeoRegionList;
	
	@FindBy(xpath="(//select[@class='mds-select__input__mds-nuxt'])[2]/option[text()='10']")
	private static WebElement result_10;
	
	@FindBy(xpath="(//select[@class='mds-select__input__mds-nuxt'])[2]/option[text()='20']")
	private static WebElement result_20;
	
	@FindBy(xpath="(//select[@class='mds-select__input__mds-nuxt'])[2]/option[text()='50']")
	private static WebElement result_50;
	
	@FindBy(xpath="(//select[@class='mds-select__input__mds-nuxt'])[2]")
	private static WebElement resultSelect;
	
	@FindBy(xpath="//ul[@class='mds-tabs__inner__mds-nuxt']/li")
	private static List<WebElement> tablist;
	
	@FindBy(xpath="//div[@class='html-content html-content-regular-text']/h4")
	private static WebElement marketingText;
	
	@FindBy(xpath="//button[contains(text(),'1-Day')]")
	private static WebElement dayColumn;
	
	@FindBy(xpath="//button[contains(text(),'1-Week')]")
	private static WebElement weekColumn;
	
	
	public void allIndexsTab() {
		action = new Actions(driver);
		action.moveToElement(AllIndexes).build().perform();
		action.click().build().perform();
	}
	
	public void equityTab() {
		action = new Actions(driver);
		action.moveToElement(Equity).build().perform();
		action.click().build().perform();
	}
	
	public void fixedIncomeTab() {
		action = new Actions(driver);
		action.moveToElement(FixedIncome).build().perform();
		action.click().build().perform();
	}
	
	public void multiAssetTab() {
		action = new Actions(driver);
		action.moveToElement(MultiAsset).build().perform();
		action.click().build().perform();
	}
	
	public void alternativesTab() {
		action = new Actions(driver);
		action.moveToElement(Alternatives).build().perform();
		action.click().build().perform();
	}
	
	public void esgTab() {
		action = new Actions(driver);
		action.moveToElement(ESG).build().perform();
		action.click().build().perform();
	}
	
	public void privateMarketsTab() {
		action = new Actions(driver);
		action.moveToElement(PrivateMarket).build().perform();
		action.click().build().perform();
	}
	public void indexByName(String search) {

		SearchField.sendKeys(search);
	}
	
	public void indexByKeyword(String keyword ) {
		action = new Actions(driver);
		action.moveToElement(KeyWordField).build().perform();
		KeyWordField.sendKeys(keyword);
	}
	
	public void strategicBetaIndexType() {
		action = new Actions(driver);
		action.moveToElement(ESGIndex).build().perform();
		action.click().build().perform();
	}
	
	public void assetType() {
		action = new Actions(driver);
		action.moveToElement(EquityDD).build().perform();
		action.click().build().perform();
		action.moveToElement(FixedIncomeDD).build().perform();
		action.click().build().perform();
		action.moveToElement(MultiAssetDD).build().perform();
		action.click().build().perform();
		action.moveToElement(AlternativesDD).build().perform();
		action.click().build().perform();
	}
	
	public void indexType() {
		action = new Actions(driver);
		action.moveToElement(ESGIndex).build().perform();
		action.click().build().perform();
		action.moveToElement(StrategicBeta).build().perform();
		action.click().build().perform();
	}
	
	public List<WebElement> indexFamily() throws InterruptedException {
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,550)", "");
		action.moveToElement(IndexFamily).build().perform();
		action.click().build().perform();
		List<WebElement> indexfamilylist = new ArrayList<WebElement>(IndexFamilyList);
		for(WebElement element:indexfamilylist) {
			action.moveToElement(element).build().perform();
			action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);
			Thread.sleep(250);
			System.out.println(element.getText());
		}
		return indexfamilylist;
	}
	
	public List<WebElement> geographicRegion() throws InterruptedException {
		action = new Actions(driver);
		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript("scrollBy(0,1100)", "");
		action.moveToElement(GeoRegion).build().perform();
		action.click().build().perform();
		List<WebElement> georegionlist = new ArrayList<WebElement>(GeoRegionList);
		for(WebElement e:georegionlist) {
			action.moveToElement(e).build().perform();
			action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			System.out.println(e.getText());
		}
		return georegionlist;
	}
	
	public String result10() {
		action = new Actions(driver);
		action.moveToElement(resultSelect).build().perform();
		action.click().build().perform();
		result_10.click();
		return result_10.getText();
	}
	
	public String result20() {
		action = new Actions(driver);
		action.moveToElement(resultSelect).build().perform();
		action.click().build().perform();
		result_20.click();
		return result_20.getText();
	}
	public String result50() {
			action = new Actions(driver);
			action.moveToElement(resultSelect).build().perform();
			action.click().build().perform();
			result_50.click();
		return result_50.getText();
	}
	
	public List<WebElement> tabList() {
		List<WebElement> totalTabList = new ArrayList<WebElement>(tablist);
		return totalTabList;
	}
	
	public String marketingText() {
		return marketingText.getText();
	}
	public void dayColumn() {
		action=new Actions(driver);
		action.moveToElement(dayColumn).build().perform();
		action.doubleClick().build().perform();
	}
	
	public void weekColumn() {
		action=new Actions(driver);
		action.moveToElement(weekColumn).build().perform();
		action.doubleClick().build().perform();
	}
	
}
