package testpackageUI;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseTest;
import pagepackage.iFrame;

public class iframetest extends BaseTest{

	public iframetest() {
		super();
	}
	
	@BeforeMethod
	public void StartSignInTest() throws InterruptedException {
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