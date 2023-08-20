package testpackageUI;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseTest;
import pagepackage.JSAlert;

public class JSAlertTest extends BaseTest {

	public JSAlertTest() {
		super();
	}
	
	@BeforeMethod
	public void StartSignInTest() throws InterruptedException {
		getDriver().get(prop.getProperty("jsalerturl"));
		Thread.sleep(1000);
		jsalert = new JSAlert();
	}
	
	JSAlert jsalert;
	@Test
	public void jsalerttest() {
		
		Assert.assertEquals(jsalert.Alert(), "I am a JS Alert");
	}
	
	@Test
	public void jsconfirmtest() {
		Assert.assertEquals(jsalert.Confirm(), "I am a JS Confirm");
	}
	
	@Test
	public void jsprompttest() {
		Assert.assertEquals(jsalert.Prompt(), "You entered: Shivam");
	}
	
	
	
}
