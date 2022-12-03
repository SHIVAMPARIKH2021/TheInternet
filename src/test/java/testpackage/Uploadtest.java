package testpackage;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import basepackage.BaseTest;
import pagepackage.Upload;

public class Uploadtest extends BaseTest {

	public Uploadtest() {
		super();
	}
	Upload uload;
	
	@BeforeMethod
	public void StartSignInTest() throws InterruptedException {
		initiate();
		driver.get(prop.getProperty("uploadurl"));
		Thread.sleep(1000);
		uload = new Upload(); 
	}
	

	
	@Test
	public void testupload() {
		uload.upload();
	}
	
	@AfterMethod
	public void EndSignInTest() {
		quitbrowser();
		//quiting the browser
	}
}
