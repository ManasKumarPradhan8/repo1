package Pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IphoneSearchResultsPage {
	WebDriver driver;

	public  IphoneSearchResultsPage(WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "(//img[@class='_bXVsd_image_1pfbQ'])[1]")
	WebElement iponeImg;
	
	@FindBy(xpath="//*[@class='a-price-whole']")
	List<WebElement>li;
	
	@FindBy(xpath="//span[text()='Apple iPhone 13 Pro (256GB) - Sierra Blue']")
	WebElement iphone13 ;
	
	@FindBy(xpath="//*[@alt='Sierra Blue']")
	WebElement iphoneBlue;
	
	public boolean isIphoneImgPresent() {
		// TODO Auto-generated method stub
	return 	iponeImg.isDisplayed();
	}
	
	public void iphone13Click() {
		iphone13.click();
}
	public void iphone13BlueClick() {
		
		iphoneBlue.click();
}
}
