package testpackage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseTest;
import pagepackage.DynamicLoading;

public class DynamicLoadingTest extends BaseTest {

	public DynamicLoadingTest() {
		PageFactory.initElements(driver, this);
	}
	
	@BeforeMethod
	public void StartSignInTest() throws InterruptedException {
		getDriver().get(prop.getProperty("dynamicloadingurl"));
		Thread.sleep(1000);
		dynamicloading = new DynamicLoading();
	}
	
	DynamicLoading dynamicloading;
	
	@Test
	public void startbuttontest() {
		dynamicloading.start();
	}
	

}
