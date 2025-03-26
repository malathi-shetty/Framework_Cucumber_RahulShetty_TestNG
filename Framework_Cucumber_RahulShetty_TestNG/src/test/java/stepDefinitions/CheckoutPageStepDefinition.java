package stepDefinitions;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;




public class CheckoutPageStepDefinition {
	
	public WebDriver driver;
	public CheckoutPage cp;
	
	//public WebDriver driver;
	//public String landingPageProductName;
	public String offerPageProductName;
	TestContextSetup testContextSetup; //global variable this doesnt have any knowledge
	
	public CheckoutPageStepDefinition(TestContextSetup testContextSetup) // this has the knowledge
	{
		this.testContextSetup = testContextSetup;
		this.cp =  testContextSetup.pageObjectManager.getCheckoutPage();
		 this.driver = testContextSetup.driver;  // Accessing the driver from TestContextSetup
	}

	


	@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout_and_validate_the_tom_items_in_checkout_page(String name) throws InterruptedException {
		
		cp.CheckoutItems();
		//Assertion to extract name from screen & compare with name
		
		Thread.sleep(2000);
		
		 // Locate the element containing the name         
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='productCartTables']//p[contains(text(),'Tomato - 1 Kg')]")));

        
     // Get the name from the element
        String productText = productName.getText();
        System.out.println("Product Text: " + productText);
        
        // Expected name to compare against
        String expectedName = "Tomato - 1 Kg";
        System.out.println("Expected Text: " + expectedName);
        
        // Assert that the extracted name matches the expected name
        Assert.assertEquals(productText, expectedName, "Name does not match!");  // The message will show if the test fails
        System.out.println("Test Passed: Name matches!");
		
	}

	@Then("verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
		
		Assert.assertTrue(cp.VerifypromoBtn()); // if not displayed on page it wud fail
		Assert.assertTrue(	cp.VerifyPlaceOrder());
	}
	
	

}
