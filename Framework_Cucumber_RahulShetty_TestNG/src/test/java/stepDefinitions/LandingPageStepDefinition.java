package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	
	//public WebDriver driver;
	//public String landingPageProductName;
	public String offerPageProductName;
	
	TestContextSetup testContextSetup; //global variable this doesnt have any knowledge
	LandingPage lp;
	
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup) // this has the knowledge
	{
		this.testContextSetup = testContextSetup;
		this.lp = testContextSetup.pageObjectManager.getLandingPage();
	}

	@Given("User is on GreenCart Landing Page")
	public void user_is_on_green_cart_landing_page() {
	    System.out.println("********");
	   
	    System.out.println("User is on GreenCart Landing Page");
	    Assert.assertTrue(lp.getTitleLandingPage().contains("GreenKart"));
	    
	}

	//@When("user searched with Shortname {string} and extracted actual name of the Product")//static
	@When("^user searched with Shortname (.+) and extracted actual name of the Product$")//dynamic
	public void user_searched_with_shortname_and_extracted_actual_name_of_the_product(String shortName) throws InterruptedException {
	   System.out.println();
	   
	  	
	  // testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	  // LandingPage lp = testContextSetup.pageObjectManager.getLandingPage();
	   lp.searchItem(shortName);
	   lp.getSearchText();
	   
	   Thread.sleep(2000);
	 //   testContextSetup.landingPageProductName = testContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
	   testContextSetup.landingPageProductName = lp.getProductName().split("-")[0].trim();
	    System.out.println(testContextSetup.landingPageProductName + " : Extracted from HomePage" );
	    
	}

	@When("Added {string} items of the selected product to the cart")
	public void added_items_of_the_selected_product_to_the_cart(String quantity) {
		lp.incrementQuantity(Integer.parseInt(quantity));
		lp.addToCart();
	}

}
