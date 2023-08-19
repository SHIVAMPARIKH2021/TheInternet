package testpackageUI;

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
		getDriver().get(prop.getProperty("uploadurl"));
		Thread.sleep(1000);
		uload = new Upload(); 
	}
	@Test
	public void testupload() {
		uload.upload();
	}
	
	
}
