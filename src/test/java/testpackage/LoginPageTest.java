package testpackage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseTest;
import pagepackage.LoginPage;

public class LoginPageTest extends BaseTest {

	public LoginPageTest() {
		super();
	}
	

	@BeforeMethod
	public void StartSignInTest() throws InterruptedException {
		getDriver().get(prop.getProperty("url"));
		Thread.sleep(1000);
		loginpage = new LoginPage();
		}
	
	LoginPage loginpage;
	@Test(priority=1)
	public void loginbuttontest() {
		loginpage.Username(prop.getProperty("username"));
		loginpage.Password(prop.getProperty("password"));
		loginpage.Loginbutton();
		loginpage.AssertionLoginPass();
	}
	@Test(priority=2)
	public void failloginbuttontest() {
		//Give any random username & passwrod except the true one.
		loginpage.Username(prop.getProperty("username"));
		loginpage.Password(prop.getProperty("password"));
		loginpage.Loginbutton();
		loginpage.AssertionLoginPass();
	}
	
	

}
