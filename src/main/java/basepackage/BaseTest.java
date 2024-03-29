package basepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Optional;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.BaseUtil;
import utility.CommonUtil;

public class BaseTest {

    private static FileInputStream file;
    protected static Properties prop;
    protected static WebDriver driver;
    protected static
    ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
    private static Logger log = Logger.getLogger(BaseTest.class);
    protected static final int EXPLICIT_WAIT = 500;
    protected static final int IMPLICIT_WAIT = 1000;
    private static final long WAIT_FOR_BUILD = 10000L;
    protected static Actions action;
    protected static Select select;
    protected static WebDriverWait wait;

    public BaseTest() {
        prop = new Properties();
        try {
            file = new FileInputStream(CommonUtil.currentDirectory + "\\src\\main\\java\\configurationpackage\\configuration.properties" );
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
    @Parameters({"browser"})
    public static synchronized WebDriver initiate(@Optional("Abc") String browser) {
        log.info("Browser is: " + browser);
        switch (prop.getProperty("type")) {

            case "local":
                if (browser.equalsIgnoreCase(BaseUtil.Chrome.toString())) {
                    WebDriverManager.chromedriver().setup();
                    threadLocalDriver.set(driver = new ChromeDriver());
                    driver.manage().timeouts().pageLoadTimeout(EXPLICIT_WAIT, TimeUnit.MILLISECONDS);
                    log.warn("Connecting with Chrome Browser");
                    log.info("Current Thread ID:" + Thread.currentThread());
                } else if (browser.equalsIgnoreCase(BaseUtil.FireFox.toString())) {
                    WebDriverManager.firefoxdriver().setup();
                    threadLocalDriver.set(driver = new FirefoxDriver());
                    log.warn("Connecting with FireFox Browser");
                    log.info("Current Thread ID:" + Thread.currentThread());
                } else if (browser.equalsIgnoreCase(BaseUtil.Edge.toString())) {
                    WebDriverManager.edgedriver().setup();
                    threadLocalDriver.set(driver = new EdgeDriver());
                    log.warn("Connecting with Edge Browser");
                    log.info("Current Thread ID:" + Thread.currentThread());
                } else {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("start-maximized");
                    options.addArguments("enable-automation");
                    options.addArguments("--headless");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--disable-browser-side-navigation");
                    options.addArguments("--disable-gpu");
                    options.setPageLoadStrategy(PageLoadStrategy.NONE);
                    WebDriverManager.chromedriver().setup();
                    threadLocalDriver.set(driver = new ChromeDriver(options));
                    driver.manage().timeouts().pageLoadTimeout(WAIT_FOR_BUILD, TimeUnit.MILLISECONDS);
                    log.warn("Connecting with Chrome Browser");
                    log.info("Current Thread ID:" + Thread.currentThread());
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
        driver = threadLocalDriver.get();
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
