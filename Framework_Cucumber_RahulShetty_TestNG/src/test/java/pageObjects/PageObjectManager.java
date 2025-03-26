package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
//Factory Design Pattern: Create object & send back	
	
	public LandingPage lp;
	public OffersPage op;
	public WebDriver driver;
	public CheckoutPage cp;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public LandingPage getLandingPage()
	{
		lp = new LandingPage(driver);
		return lp;
	}
	
	public OffersPage getOffersPage()
	{
		op = new OffersPage(driver);
		return op;
	}

	
	public CheckoutPage getCheckoutPage()
	{
		cp = new CheckoutPage(driver);
		return cp;
	}

}
