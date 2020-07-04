package TomerTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSuit {
	static WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/admin/Documents/workspace/selenium/chromedriver");
		driver = new ChromeDriver();
		System.out.println("Open web page");
		driver.get("https://tomercohenofficial.com/");
		driver.manage().window().maximize();
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (Exception e) {}
	}
	
	
//	@Test
//	public void test1() {
//		TabTest tt = new TabTest(driver);
//		tt.openAllTabs();
//	}
//	
//	@Test
//	public void test2() {
//		TabTest tt = new TabTest(driver);
//		driver.get("https://cocky-torvalds-66ee45.netlify.app/");
//		tt.fillContactForm("Gabriel", "naltes8@gmail.com", "This is an automation test");
//		driver.get("https://tomercohenofficial.com/");
//	}
//	
//	@Test
//	public void test3() {
//		TestSocials social = new TestSocials(driver);
//		social.OpenSocialsLinks();
//	}
//	
//	@Test
//	public void test4() {
//		TestShareButton button = new TestShareButton(driver);
//		button.ShareButton();
//	}
//	
//	@Test
//	public void test5() {
//		TestYoutubeLinks youtubeLinks = new TestYoutubeLinks(driver);
//		youtubeLinks.YoutubeLinks();
//
//
//	}
	
	@Test
	public void test6() {
		TestMediaLinks mediaLinks = new TestMediaLinks(driver);
		mediaLinks.MediaLinks();
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
