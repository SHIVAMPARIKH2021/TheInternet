package pagepackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basepackage.BaseTest;

public class LoginPage extends BaseTest{

	public LoginPage() {
		PageFactory.initElements(driver, this);
		}
	
	@FindBy (id="username")
	private static  WebElement username;
	
	@FindBy (id="password")
	private static WebElement password;
	
	@FindBy (xpath="//i[contains(text(),' Login')]/parent::button")
	private static WebElement LoginButton;
	
	@FindBy(xpath="//div[@class='flash success']")
	private static WebElement LoginAssertion;
	
	@FindBy(xpath="//div[@class='flash error']")
	private static WebElement FailLoginAssertion;

	public void Username(String USERNAME) {
		username.click();
		username.sendKeys(USERNAME);
	}
	
	public void Password(String PASSWORD) {
		password.click();
		password.sendKeys(PASSWORD);
	}
	
	public void Loginbutton() {
		LoginButton.click();
	}
	
	
	
	
	
	
	public void assertonLoginPass() {
		if(FailLoginAssertion == null)
		Assert.assertEquals(LoginAssertion.getText().toString().contains("You logged into a secure area!"), true);
	
		else if(LoginAssertion == null) {
		Assert.assertEquals(FailLoginAssertion.getText().toString().contains("invalid!"), true);
	}
	}
}
