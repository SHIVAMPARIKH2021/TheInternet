package testpackage;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseTest;
import pagepackage.Index;

public class IndexTest extends BaseTest {

	public IndexTest() {
		super();
	}
	Index in;

	@BeforeMethod
	public void indexTest() throws InterruptedException {
		getDriver().get(prop.getProperty("indexurl"));
		Thread.sleep(10000);
		in=new Index();
	}
	@Test
	public void indexByNameTest() {
		in.indexByName("Morningstar Developed Markets");
	}
	@Test
	public void indexByKeywordTest() {
		in.indexByKeyword("Free form text");
	}
	@Test
	public void allIndexTabTest() {
		in.allIndexsTab();
	}
	@Test
	public void equityTabTest() {
		in.equityTab();
	}
	@Test
	public void fixedIncomeTabTest() {
		in.fixedIncomeTab();
	}
	@Test
	public void multiAssetTabTest() {
		in.multiAssetTab();
	}
	@Test
	public void alternativesTabTest() {
		in.alternativesTab();
	}
	@Test
	public void esgTabTest() {
		in.esgTab();
	}
	@Test
	public void privateMarketTabTest() {
		long e = System.currentTimeMillis();
		in.privateMarketsTab();
		long s = System.currentTimeMillis();
		System.out.println(s-e);
	}
	@Test
	public void assetTypeTest() {
		in.assetType();
	}
	@Test
	public void indexType() {
		in.indexType();
	}
	@Test
	public void indexFamilyTest() throws InterruptedException {
		in.indexFamily();
	}
	@Test
	public void geoRegionTest() throws InterruptedException {
		in.geographicRegion();
	}
	@Test
	public void result_10test() throws InterruptedException,StaleElementReferenceException {
		in.result10();
		System.out.println(in.result10());
	}
	@Test
	public void result_20test() throws InterruptedException,StaleElementReferenceException {
		in.result20();
		System.out.println(in.result20());
	}
	@Test
	public void result_50test() throws InterruptedException, StaleElementReferenceException {
		in.result50();
		System.out.println(in.result50());
	}

	@Test
	public void dayColumntest() {
		in.dayColumn();
	}

	@Test
	public void weekColumntest() {
		in.weekColumn();
	}

	@Test
	public void marketingTextTest() {
		System.out.println(in.marketingText());
	}
	@Test
	public void tabListTest() {
		in.tabList();
		for(WebElement listelement:in.tabList()) {
			listelement.getText();
			System.out.println(listelement.getText());
			}
	}
	//@AfterMethod
	//public void closeIndex() {
	//	driver.close();
	//}

}