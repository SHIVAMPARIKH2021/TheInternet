package testpackage;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
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
		jsalert.Alert();
		Assert.assertEquals(driver.switchTo().alert().getText().toString(), "I am a JS Alert");
	}
	
	@Test
	public void jsconfirmtest() {
		jsalert.Confirm();
		Assert.assertEquals(driver.switchTo().alert().getText().toString(), "I am a JS Confirm");
	}
	
	@Test
	public void jsprompttest() {
		jsalert.Prompt();
		Assert.assertEquals(driver.switchTo().alert().getText().toString(), "You entered: Shivam");
	}
	
	
	
}
