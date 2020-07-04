package TomerTest;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TabTest {
	
	private static WebDriver driver;
	
	public TabTest(WebDriver driver) {
		TabTest.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"main-nav\"]/a[4]/button")
	private WebElement contactTab;
	
	@FindBy(id = "container")
	private WebElement containerInContactPage;
	
	@FindBy(xpath = "//*[@id=\"main-nav\"]/a[3]/button")
	private WebElement musicTab;
	
	@FindBy(className = "tomer")
	private WebElement aboutInfo;
	
	@FindBy(xpath = "//*[@id=\"main-nav\"]/a[2]/button")
	private WebElement aboutPage;
	
	@FindBy(className = "article")
	private WebElement article;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div[3]/h3")
	private WebElement tcMainPageTitle;
	
	@FindBy(xpath = "//*[@id=\"name\"]")
	private WebElement nameTextBox;
	
	@FindBy(id = "email")
	private WebElement emailTextBox;
	
	@FindBy(id = "message")
	private WebElement messageTextBox;
	
	@FindBy(id = "recaptcha-anchor")
	private WebElement reCaptcha;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/form/button")
	private WebElement sendButton;
	
	public void openAllTabs() {
		isWebsiteOpen();
		AssertHomeTabIsOpen();
		openAboutPageAndAssert();
		openMusicPageAndAssert();
		openContactPageAndAssert();
	}
	
	public void fillContactForm(String name, String mail, String message) {			
		waitForElement(contactTab, 5);
		contactTab.click();
		enterName(name);
		enterEmail(mail);
		enterMsg(message);
		clickSend();
	}
	
	private void clickSend() {
		sendButton.click();
	}
	
	private void enterMsg(String message ) {
		messageTextBox.sendKeys(message);
	
	}
	
	private void enterEmail(String mail) {
		emailTextBox.sendKeys(mail);
		
	}
	
	private void enterName(String name) {
		waitForElement(nameTextBox, 5);
		nameTextBox.sendKeys(name);
		
	}
	
	private void isWebsiteOpen() {
		String ttl = driver.getTitle();
		if((ttl.equals("Tomer Cohen: Music Composer | Songwriter & Singer"))){
			System.out.println("The web page title: " + ttl);
		}else {
			System.out.println("Website was not open");
			fail();
		} 
	}

	private void openContactPageAndAssert() {
		contactTab.click();
		if(containerInContactPage.isDisplayed());{
			System.out.println("Contact page - successfully oppened");
		} 
	}

	private void openMusicPageAndAssert() {
		musicTab.click();
		if(aboutInfo.isDisplayed());{
			System.out.println("Music page - successfully oppened");
		} 
		
	}

	private void openAboutPageAndAssert() {
		aboutPage.click();
		if (article.isDisplayed());{
			System.out.println("About page - successfully oppened");
		} 
	}

	private void AssertHomeTabIsOpen() {
		try {
			waitForElement(tcMainPageTitle, 5);
		} catch (Exception e) {}
		if(tcMainPageTitle.isDisplayed()) {
			System.out.println("Home page - successfully oppened");
			
		} 
	}
	
	private void waitForElement(WebElement element, int seconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {}

	}

}
