package testpackage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseTest;
import pagepackage.Dynamiccontent;

public class DynamiccontentTest extends BaseTest {

	public DynamiccontentTest() {
		super();
	}
	
	@BeforeMethod
	public void StartSignInTest() throws InterruptedException {
		getDriver().get(prop.getProperty("dynamiccontenturl"));
		Thread.sleep(1000);
		dynamiccontent = new Dynamiccontent();
	}
	
	Dynamiccontent dynamiccontent;
	
	@Test
	public void Dynamiccontent1test() throws InterruptedException {
		dynamiccontent.DynamicContent1();
		dynamiccontent.DynamiccontentAssertion();
	}
	@Test
	public void Dynamiccontent2test() throws InterruptedException {
		dynamiccontent.DynamicContent2();
		dynamiccontent.DynamiccontentAssertion();
	}
	@Test
	public void Dynamiccontent3test() throws InterruptedException {
		dynamiccontent.DynamicContent3();
		dynamiccontent.DynamiccontentAssertion();
	}

	 


}
