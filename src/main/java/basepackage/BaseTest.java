package basepackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.BaseUtil;

public class BaseTest {

	private static FileInputStream file;
	protected static Properties prop;
	protected static WebDriver driver;
	protected static 
    ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
	private static Logger log = Logger.getLogger(BaseTest.class);
	protected static final int EXPLICIT_WAIT = 500;
	protected static final int IMPLICIT_WAIT = 1000;
	protected static Actions action;
	protected static Select select;
	protected static WebDriverWait wait;
	private static String current = System.getProperty("user.dir");

	public BaseTest() {
		try {
			prop = new Properties();
			file = new FileInputStream(current + "\\src\\main\\java\\configurationpackage\\configuration.properties");
			prop.load(file);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Configurations are not found; Restart the process or Check the program"+""+e);

		}
	}

	private static WebDriver manageDriver() {
		driver.navigate().refresh();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}
	@BeforeTest
	@Parameters("browser")
	public static synchronized WebDriver initiate(String browser){
		switch(prop.getProperty("type")){
		
		case "local":
			if(browser.equalsIgnoreCase(BaseUtil.Chrome.toString())) {
				//WebDriverManager.chromedriver().setup();
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				threadLocalDriver.set(driver=new ChromeDriver());
				log.warn("Connecting with Chrome Browser");
				log.info("Current Thread ID:"+Thread.currentThread());
			}
			else if(browser.equalsIgnoreCase(BaseUtil.Edge.toString())) {
				//WebDriverManager.edgedriver().setup();
				System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
				threadLocalDriver.set(driver=new EdgeDriver());
				log.warn("Connecting with Edge Browser");
				log.info("Current Thread ID:"+Thread.currentThread());
			}
			else {
				WebDriverManager.firefoxdriver().setup();
				//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
				threadLocalDriver.set(driver=new FirefoxDriver());
				log.warn("Connecting with FireFox Browser");
				log.info("Current Thread ID:"+Thread.currentThread());
			}
			break;
			
		case "remote":

			try {
				driver = RemoteDriverFactory.getRemoteWebDriver(browser);
				log.warn("RemoteDriverFactory is started");
				} catch (MalformedURLException e) {
				e.printStackTrace();
			}

			break;
			}
		manageDriver();
		return getDriver();

	}
	@BeforeClass
	public static synchronized WebDriver getDriver() {
		driver=threadLocalDriver.get();
		return driver;
	}
	@AfterTest
	public static void quitbrowser() {
		if (driver != null) {
			driver.quit();
		} else {
			driver.close();
		}
	}
}
