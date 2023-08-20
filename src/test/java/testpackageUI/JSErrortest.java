package testpackageUI;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseTest;
import pagepackage.JSError;

public class JSErrortest extends BaseTest{

	
	public JSErrortest() {
		super();
	}

	@BeforeMethod
	public void StartSignInTest() throws InterruptedException {
		getDriver().get(prop.getProperty("jserrorurl"));
		Thread.sleep(1000);
		jserror = new JSError();
	}
	
	JSError jserror; 
	
	@Test
	public void test() {
		jserror.Error();
	}
}
