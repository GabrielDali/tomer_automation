package TomerTest;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestYoutubeLinks {

	private static WebDriver driver;
	
	public TestYoutubeLinks (WebDriver driver) {
		TestYoutubeLinks.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"container\"]/div[1]/div[3]/p[1]/a")
	WebElement songLink_babyYouOnlyOne;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div[1]/div[3]/a")
	WebElement songLink_oneManShow;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div[1]/div[3]/p[2]/a")
	WebElement songlink_doubleLife;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div[1]/div[3]/p[4]/a")
	WebElement songlink_hereIam;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div[1]/div[3]/p[7]/a")
	WebElement songlink_shine;
	
	@FindBy(xpath = "//*[@id=\"container\"]/h1/yt-formatted-string")
	WebElement youtubeSongTitle;
	
	@FindBy(xpath = "//*[@id=\"main-nav\"]/a[3]/button")
	private WebElement musicTab;

	public void YoutubeLinks () {
		musicTab.click();
		openlink_babyYouOnlyOne_assert();
		openlink_oneManShow_assert();
		openlink_doubleLife_assert();
		openlink_hereIam_asser();
		openlink_shine_assert();
		
	}

	private void openlink_shine_assert() {
		songlink_shine.click();
		switchToTab();
		assertEquals(getYoutubeSongTitle(), "Tomer Cohen - Shine - תומר כהן");
		closeTab();
		
	}

	private void openlink_babyYouOnlyOne_assert() {
		songLink_babyYouOnlyOne.click();
		switchToTab();
		assertEquals(getYoutubeSongTitle(), "Tomer Cohen - Baby You're The Only One");
		closeTab();
	
	}

	private void openlink_oneManShow_assert() {
		songLink_oneManShow.click();
		switchToTab();
		assertEquals(getYoutubeSongTitle(), "Tomer Cohen - One Man Show - תומר כהן");
		closeTab();
		
	}

	private void openlink_doubleLife_assert() {
		songlink_doubleLife.click();
		switchToTab();
		assertEquals(getYoutubeSongTitle(), "Tomer Cohen - Double Life - תומר כהן");
		closeTab();
		
	}

	private void openlink_hereIam_asser() {
		songlink_hereIam.click();
		switchToTab();
		assertEquals(getYoutubeSongTitle(), "Tomer Cohen - Here I Am - תומר כהן");
		closeTab();
		
	}
	
	private String getYoutubeSongTitle() {
		waitForElement(youtubeSongTitle, 5);
		String songTitle = youtubeSongTitle.getText();
		System.out.println("Song Title: " + songTitle);
		return songTitle;
		
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
	
}














