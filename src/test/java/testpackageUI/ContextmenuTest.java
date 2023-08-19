package testpackageUI;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseTest;
import pagepackage.Contextmenu;

public class ContextmenuTest extends BaseTest {

	public ContextmenuTest() {
		super();
	}
	
	@BeforeMethod
	public void StartSignInTest() throws InterruptedException {
		getDriver().get(prop.getProperty("contextmenuurl"));
		Thread.sleep(1000);
		contextmenu = new Contextmenu();
		}
	
	    Contextmenu contextmenu;
	    

	    @Test
	    public void alerttest() {
	    	contextmenu.ContextmenuBox().accept();
	    	contextmenu.ContextmenuAssertion();
	    }

	




}
