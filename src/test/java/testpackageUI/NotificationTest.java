package testpackageUI;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseTest;
import pagepackage.Notification;

public class NotificationTest extends BaseTest {

	public NotificationTest() {
		super();
	}
	@BeforeMethod
	public void StartSignInTest() throws InterruptedException {
		getDriver().get(prop.getProperty("notificationurl"));
		Thread.sleep(1000);
		notification = new Notification(); 
	}
	Notification notification;
	
	
	@Test
	public void notificationtest() {
		notification.clicklink();
	}
	
	
}
