package testpackage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseTest;
import pagepackage.NewTab;

public class NewTabTest extends BaseTest {

	public NewTabTest() {
		super();
	}
	
	@BeforeMethod
	public void StartSignInTest() throws InterruptedException {
		getDriver().get(prop.getProperty("newtaburl"));
		Thread.sleep(1000);
		nt = new NewTab();
	}
	NewTab nt;
	@Test
	public void tabtest() {
		System.out.println(driver.getTitle().toString());
	}
	
	
}