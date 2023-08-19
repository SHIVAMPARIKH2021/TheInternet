package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public enum BaseUtil {
	FireFox,
	Chrome, 
	Edge;
public static int PAGE_RESULT = 64;
public static String currentDirectory = System.getProperty("user.dir");
	
	@FindBy(xpath = "//span[text()='Deliver to Shivam']") 
	public static WebElement ADDRESS_BUTTON;
	
	
	
	}
