package TomerTest;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestMediaLinks {
	
	private static WebDriver driver;
	
	public TestMediaLinks (WebDriver driver) {
		TestMediaLinks.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//*[@id=\"press\"]/div[2]/p/a")
	WebElement listOfSongs;
	
	@FindBy(xpath = "//*[@id=\"press\"]/div[3]/a/p")
	WebElement onRadio;
	
	@FindBy(xpath = "//*[@id=\"press\"]/div[1]/p/a")
	WebElement inPress;
	
	@FindBy(xpath = "//*[@id=\"main-nav\"]/a[3]/button")
	WebElement musicTab;
	
	@FindBy(xpath  = "//*[@id=\"mako_top_bar\"]/p/label/a")
	WebElement mako;
	
	@FindBy(xpath = "/html/body/div[3]/div[2]/div/div[2]/h1")
	WebElement radio;
	
	@FindBy(xpath = "//*[@id=\"article-wrap\"]/article/section[1]/header/h1")
	WebElement press;
	
	
	public void MediaLinks() {
		musicTab.click();
		openLinkSongList_assert();
		openLinkRadio_asser();
		openLinkPress_assert();
	}


	private void openLinkSongList_assert() {
		listOfSongs.click();
		waitForElement(mako, 5);
		switchToTab();
		assertPageTitle("שירים שבוצעו ע\"י תומר כהן - שירונט");
		closeTab();
		
	}
		
	

	private void openLinkRadio_asser() {
		onRadio.click();
		waitForElement(radio, 5);
		switchToTab();
		assertPageTitle("\"Tomer Cohen \"Baby You're The Only One ברדיו סול רדיו ישראלי רדיו אינטרנטי");
		closeTab();
		
	}
	
	private void openLinkPress_assert() {
		inPress.click();
		waitForElement(press, 5);
		switchToTab();
		assertPageTitle("תומר כהן: הישראלי שעשוי לייצג את רומניה באירוויזיון");
		closeTab();
	}
	
	private void waitForElement(WebElement element, int seconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.invisibilityOf(element));
		}   catch (Exception e) {}
		
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
	
	private void assertPageTitle(String expected) {
		String title = driver.getTitle();
		System.out.println("page title: " + title);
		assertEquals(title, expected);
		
	}


	
}
	
		

