package testpackage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basepackage.BaseTest;
import pagepackage.iFrame;

public class iframetest extends BaseTest{

	public iframetest() {
		super();
	}
	
	@BeforeMethod
	public void StartSignInTest() throws InterruptedException {
//		initiate("edge");
		getDriver().get(prop.getProperty("iframeurl"));
		Thread.sleep(1000);
		frame = new iFrame();
	}
	
	iFrame frame;
	
	
	@Test
	public void Frametest() {
		frame.iframe();
	}
	
}