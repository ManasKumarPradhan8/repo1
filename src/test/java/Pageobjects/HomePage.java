package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"twotabsearchtextbox\"]")
	WebElement SearchBar;
	@FindBy(xpath="//*[@id=\"nav-search-submit-button\"]")
	WebElement searchButton;
	
	

	public String getCurrentUrl() {
		// TODO Auto-generated method stub
		return driver.getCurrentUrl();
	}
	public String getPageTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}
	public void searchBarClick() {
		SearchBar.clear();
		SearchBar.sendKeys("Apple iPhone 13");
		searchButton.click();
	}
}

