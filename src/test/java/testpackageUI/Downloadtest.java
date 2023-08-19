package testpackageUI;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseTest;
import pagepackage.Download;

public class Downloadtest extends BaseTest {
	public Downloadtest() {
		super();
	}

	@BeforeMethod
	public void StartSignInTest() throws InterruptedException {
		getDriver().get(prop.getProperty("downloadurl"));
		Thread.sleep(2000);
		dload = new Download();
	}

	Download dload;

	@Test
	public void testdownload() {
		dload.download();
		File f = new File("C:\\Users\\shiva\\Downloads");
		Assert.assertEquals(f.exists(), true);
	}


}
