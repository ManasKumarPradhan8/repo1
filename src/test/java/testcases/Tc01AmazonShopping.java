package testcases;

import java.util.Iterator;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobjects.AddCartPage;
import Pageobjects.HomePage;
import Pageobjects.IphoneSearchResultsPage;
import Pageobjects.ShoppingPage;
import TestBase.Baseclass;

public class Tc01AmazonShopping extends Baseclass {
	
	public HomePage hm;
	public IphoneSearchResultsPage sr;
	public AddCartPage ac;
	JavascriptExecutor js;
	Double phoneprice=120900.00;
	String pageTitile="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	
		@Test(priority=0)
		public void validateFirstPage()
		{
			
			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();
			
			hm=new HomePage(driver);
			String currentUrl=hm.getCurrentUrl();
			
			
			if(currentUrl.equals("https://www.amazon.in/"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
			if(pageTitile.equals(hm.getPageTitle()))
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
			
			
			}
		
		
		@Test(priority=1)
		public void validatePage1() throws InterruptedException {
			
		hm.searchBarClick();
		Assert.assertTrue(true);
		sr=new IphoneSearchResultsPage(driver);
		Thread.sleep(2000);
		if(sr.isIphoneImgPresent()==true) {
			Assert.assertTrue(true);	
		}
		}
		
		
		
		
		@Test(priority=2)
		public void iphonesAbove1l() throws InterruptedException{
		List<WebElement>price=driver.findElements(By.xpath("//*[@class='a-price-whole']"));
		for(WebElement ele:price) {
			String pricee=ele.getText();
			String temp= pricee.replace(",", "");
			double pric=Double.parseDouble(temp);
			if(pric>=100000.00) {
				System.out.print(pric+"rs"+"    ");	
				//System.out.println(ele);
				String tempXpath="//*[@class='a-price-whole']";
				String secXpath="//parent::span//parent::span//parent::a//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//h2";
				String fullXpath=tempXpath+secXpath;
				//System.out.println(fullXpath);
				List<WebElement>phoneName1=driver.findElements(By.xpath(fullXpath));
				for(WebElement elem:phoneName1) {
					
					System.out.println(elem.getText());
				}
		}	
		}
		sr.iphone13Click();
			 ac=new AddCartPage(driver);
			 Thread.sleep(5000);
			js = (JavascriptExecutor) driver;
			 js.executeScript("window.scrollBy(0,2000)");
			 Thread.sleep(4000);
			 
			 
			 WebDriverWait wait = new WebDriverWait(driver,30);
			 Set<String>windowId=driver.getWindowHandles();
			 Iterator<String>itr=windowId.iterator();
			 String parentId=itr.next();
			String child=itr.next();
			driver.switchTo().window(child);
			js.executeScript("window.scrollBy(0,2000)");
			 
			// wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id='add-to-cart-button']"))));
			 //driver.findElement(By.xpath("//div[@id='desktop_qualifiedBuyBox']//following-sibling::div[@id='addToCart_feature_div'][2]")).click();
			 
			//Click on add to cart
			 ac.addToCartClick();
			 //click on cart link
			 ac.cartLinkClick();
			 
}

		@Test(priority=3)
		public void CartValidation() {
			ShoppingPage sp=new ShoppingPage(driver);
			if(sp.getPhoneprice()==phoneprice) {
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
			if(sp.getQuantity()==1) {
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
}

