package seleniumflipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartHomePage {

	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']") private WebElement close;
	@FindBy(xpath = "//input[@class='_3704LK']") private WebElement search;
	@FindBy(xpath = "//button[@class='L0Z3Pu']") private WebElement searchIcon;
	
	
	public FlipkartHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void FlipkartClose() {
		close.click();
	}
	
	public void FlipkartSearchMob() {
		search.sendKeys("iphone");
	}
	
	public void FlipkartSearchIcon() {
		searchIcon.click();
	}
}
