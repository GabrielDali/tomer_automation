package TomerTest;

import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestShareButton {
	
private static WebDriver driver;
private Map<String, Object> vars;
	
	public TestShareButton(WebDriver driver) {
		TestShareButton.driver = driver; 
	    PageFactory.initElements(driver, this);
	}
	        
    @FindBy(using  = "facebook")
    WebElement shareButton;
    
    @FindBy(xpath = "/html/body/footer/p/a")
    WebElement linkedInButton;
    
    @FindBy(className = "lazy-loaded")
    WebElement linkedinIcon;
      
    public void ShareButton() {
    	facebookShareButton();
    	linkedInButton();
    }

	private void facebookShareButton() {
		clickShsreBtn();
		switchToTab();
		String facebookBtn = driver.getTitle();
			if(facebookBtn.equals("Facebook")) {
			System.out.println("Share button test is successfully comleted");
			}else {
			System.out.println("Share button test failed");
			fail();
			} 
			closeTab();
		
	}
	
	private void linkedInButton() {
		waitForElement(linkedInButton, 5);
		linkedInButton.click();
		switchToTab();
		String lindBtn = driver.getTitle();
		waitForElement(linkedinIcon, 5);
		System.out.println("Page title is: " + lindBtn);
			if(lindBtn.equals("Security Verification | LinkedIn") || (lindBtn.equals("Sign Up | LinkedIn"))) {
				System.out.println("Security check. LinkedIn test is successfully comleted");
			} else {
				System.out.println("Linked Test failed");	
//				fail();
			} 
			closeTab();
		
	}
	
	private void waitXseconds(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (Exception e) {}
	}
	
	private void switchToTab() {
		 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		 driver.switchTo().window(tabs2.get(1));
	}
	
	private void closeTab() {
	    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    driver.close();
	    driver.switchTo().window(tabs2.get(0));
	}
	
	private void clickShsreBtn() {
		waitForElement(shareButton, 5);
		vars = new HashMap<String, Object>();
	    driver.switchTo().frame(0);
	    vars.put("window_handles", driver.getWindowHandles());
	    driver.findElement(By.cssSelector(".\\_8f1i")).click();
		waitXseconds(5);
	}
	
	private void waitForElement(WebElement element, int seconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {}
	}
}
