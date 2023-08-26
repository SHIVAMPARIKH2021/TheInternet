package testpackageUI;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseTest;
import pagepackage.LoginPage;
import utility.ParameterizationUtil;

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
	@DataProvider
	public Object[][] data(){
		ParameterizationUtil params = new ParameterizationUtil();
		Object[][] testData=params.testData("Sheet1");
		return testData;
	}
	@Test(priority=1)
	public void loginbuttontest() {
		loginpage.Username(prop.getProperty("username"));
		loginpage.Password(prop.getProperty("password"));
		loginpage.Loginbutton();
		loginpage.assertonLoginPass();
	}
	@Test(priority=2,dataProvider="data")
	public void failloginbuttontest(String username,String password) {
		//Give any random username & passwrod except the true one.
		loginpage.Username(username);
		loginpage.Password(password);
		loginpage.Loginbutton();
		loginpage.assertonLoginPass();
	}
	
	

}
