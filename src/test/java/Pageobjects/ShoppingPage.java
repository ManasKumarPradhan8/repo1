package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingPage {
	WebDriver driver;

	public   ShoppingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

@FindBy(xpath="//p[@class='a-spacing-mini']/span")
WebElement iphonePrice;

@FindBy(xpath="//span[@data-action='a-dropdown-button']")
WebElement iphoneQuantity;

public double getPhoneprice() {
	String price=iphonePrice.getText();
	String temp= price.replace(",", "");
	 double pric=Double.parseDouble(temp);
	 return pric;
}
public int getQuantity() {
String temp=iphoneQuantity.getText();
String arr[]=temp.split(":");
String temp2=arr[1];
int quant=Integer.parseInt(temp2);
return quant;
}
}