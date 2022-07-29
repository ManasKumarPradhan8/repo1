package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCartPage {
	WebDriver driver;
	
	 
	public AddCartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id='add-to-cart-button']")
	WebElement addtoCart;
	
	@FindBy(xpath="//*[@id='attach-sidesheet-view-cart-button']/span/input")
	WebElement cartLink;
	
	public  void cartLinkClick() {
		cartLink.click();
	}
	public void addToCartClick() {
		addtoCart.click();
	}
}
