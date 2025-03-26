package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {

	public String offerPageProductName;

	TestContextSetup testContextSetup; // global variable this doesnt have any knowledge
	PageObjectManager pageObjectManager;

	public OfferPageStepDefinition(TestContextSetup testContextSetup) // this has the knowledge
	{
		this.testContextSetup = testContextSetup;
	}

	//@Then("user searched for {string} shortname in offers page")
	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {
		System.out.println();
		switchToOffersPage();

		// testContextSetup.driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(shortName);
		OffersPage op = testContextSetup.pageObjectManager.getOffersPage();
		op.searchItem(shortName);
		op.getSearchText();

		Thread.sleep(3000);
		System.out.println("----");
		// offerPageProductName = testContextSetup.driver.findElement(By.cssSelector("tr
		// td:nth-child(1)")).getText();
		offerPageProductName = op.getProductName();

		System.out.println("user searched in offers page to check if product exist: " + offerPageProductName);
		String expectedProductName = testContextSetup.landingPageProductName; // Assuming you retrieved it from Landing
																				// Page
		String actualProductName = offerPageProductName; // Method that retrieves product name from Offers Page
		System.out.println("Expected: " + expectedProductName + ", Actual: " + actualProductName);
		Assert.assertEquals(actualProductName, expectedProductName);

		
	}

	public void switchToOffersPage() {
		// if switched to offer page: skip below part
		// if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
		// {
		// testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
	//	pageObjectManager = new PageObjectManager(testContextSetup.driver);
	//	LandingPage lp = new LandingPage(testContextSetup.driver);
		LandingPage lp = testContextSetup.pageObjectManager.getLandingPage();
		
		lp.selectTopDealsPage();

		//Added in GenericUtils for reusability
	/*	Set<String> s1 = testContextSetup.driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		String parentWindow = i1.next();
		String childWindow = i1.next();
		testContextSetup.driver.switchTo().window(childWindow);
		*/
		//GenericUtils gu = new GenericUtils(); //to avoid creating objects so we create in TextContextSetUp
		testContextSetup.genericUtils.SwitchWindowToChild();
	}
	// }

	@Then("validate product name matches with landing Page")
	public void validate_product_name_matches_with_landing_page() {

		Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);

	}

}
