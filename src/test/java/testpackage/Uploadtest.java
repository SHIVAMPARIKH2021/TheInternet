package testpackage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basepackage.BaseTest;
import pagepackage.Upload;

public class Uploadtest extends BaseTest {

	public Uploadtest() {
		super();
	}
	Upload uload;
	
	@BeforeMethod
	@Parameters
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
