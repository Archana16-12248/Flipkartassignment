package seleniumflipkart;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class FlipkartTestPage {

	@Test
	public void getPriceModulenameReviewOfIphone() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","D:\\Eclipse workspace 2020-09\\Flipkartassignment\\ChromeBrowser\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();;

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		
		FlipkartHomePage home=new FlipkartHomePage(driver);
		home.FlipkartClose();
		home.FlipkartSearchMob();
		home.FlipkartSearchIcon();
		
		FlipkartSearchPage search=new FlipkartSearchPage(driver);
		
		search.getPriceModuleNameReview();
}
}