package TomerTest;

import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSocials {
	
	private static WebDriver driver;
	
	public TestSocials(WebDriver driver) {
		TestSocials.driver = driver; 
	        PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "/html/body/div[2]/a[1]")
	WebElement Email;
	
	@FindBy(xpath = "/html/body/div[2]/a[2]")
	WebElement Facebook;
	
	@FindBy(xpath = "/html/body/div[2]/a[3]")
	WebElement Apple;
	
	@FindBy(xpath = "/html/body/div[2]/a[4]")
	WebElement YouTube;
	
	@FindBy(xpath = "/html/body/div[2]/a[5]")
	WebElement Spotify;
	
	@FindBy(xpath = "/html/body/div[2]/a[6]")
	WebElement SoundCloud;
	
	@FindBy(xpath = "/html/body/div[2]/a[7]")
	WebElement Instagram;
	
	@FindBy(className = "spotify-logo--text")
	WebElement spotifyLogo;
	
	public void OpenSocialsLinks() {
//		EmailIsOpen();
		FacebookIsOpen();
		AppleIsOpen();
		YoutubeIsOpen();
		SpotifyIsOpen();
		SoundcloudIsOpen();
		InstagramIsOpen();
	}

	private void EmailIsOpen() {
		waitForElement(Email, 5);
		Email.click();
		switchToTab();
		String gmlTtl = driver.getCurrentUrl();
		System.out.println("page URL: " + gmlTtl);
		if(gmlTtl.equals("mailto:tomercohenofficial@gmail.com")){
			System.out.println("Email test is done ");
		} else {
			System.out.println("Email title not found");
			fail();
		}
		closeTab();
	}

	private void FacebookIsOpen() {
		waitForElement(Facebook, 5);
		Facebook.click();
		switchToTab();
		String fbTtl = driver.getTitle();
		System.out.println("page title: " + fbTtl);
		if(fbTtl.equals("תומר כהן Tomer Cohen Tc - Home | Facebook")){
			System.out.println("Facebook test is done ");
		} else {
			System.out.println("Facebook title not found");
			fail();
		}
		closeTab();
	}

	private void AppleIsOpen() {
		waitForElement(Apple, 5);
		Apple.click();		
		switchToTab();
		String apTtl = driver.getTitle();
		System.out.println("page title: " + apTtl);
		if(apTtl.contains("תומר כהן on Apple Music")) {
			System.out.println("Apple test is done");
		} else {
			System.out.println("Apple title not found");
			fail();
		}
		closeTab();
	}

	private void YoutubeIsOpen() {
		waitForElement(YouTube, 5);
		YouTube.click();	
		switchToTab();
		String youTtl = driver.getTitle();
		System.out.println("page title: " + youTtl);
		if(youTtl.equals("Tomer Cohen - YouTube")) {
			System.out.println("YouTube test is done");
		} else {
			System.out.println("YouTube title not found");
			fail();			
		} 
		closeTab();
	}

	private void SpotifyIsOpen() {
		waitForElement(Spotify, 5);
		Spotify.click();
		switchToTab();
		waitForElement(spotifyLogo, 5);
		String spfTtl = driver.getTitle();
		System.out.println("page title: " + spfTtl);
		if(spfTtl.equals("Spotify – Tomer Cohen")) {
			System.out.println("Spotify test is done");
		} else {
			System.out.println("Spotify title not found");
			fail();
		}
		closeTab();
	}

	private void SoundcloudIsOpen() {
		waitForElement(SoundCloud, 5);
		SoundCloud.click();
		switchToTab();
		String sclTtl = driver.getTitle();
		System.out.println("page title: " + sclTtl);
		if(sclTtl.equals("Tomer Cohen | TC | Free Listening on SoundCloud")) {
			System.out.println("Soundcloud test is done");
		} else {
			System.out.println("Soundcloud title not found");
			fail();
		} 
		closeTab();
	}

	private void InstagramIsOpen() {
		waitForElement(Instagram, 5);
		Instagram.click();
		switchToTab();
		String insTll = driver.getTitle();
		System.out.println("page title: " + insTll);
		if(insTll.equals("Tomer Cohen (@tomercohenofficial) • Instagram photos and videos")) {
			System.out.println("Instagram test is done");
		}else {
			System.out.println("Instagram title not found");
			fail();
		} 
		closeTab();
	}
	
	private void closeTab() {
	    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    driver.close();
	    driver.switchTo().window(tabs2.get(0));
	}
	
	private void waitXseconds(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		}   catch (Exception e) {}
		
	}
	
	private void switchToTab() {
		 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		 driver.switchTo().window(tabs2.get(1));
	}
	
	private void waitForElement(WebElement element, int seconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.invisibilityOf(element));
		}   catch (Exception e) {}
	}
}


