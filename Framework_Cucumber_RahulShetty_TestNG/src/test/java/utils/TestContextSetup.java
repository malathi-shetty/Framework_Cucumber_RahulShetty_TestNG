package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;


public class TestContextSetup { // heart of the project
	public WebDriver driver;
	public String landingPageProductName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	
	public TestContextSetup() throws IOException {	
		testBase = new TestBase();
	//pageObjectManager = new PageObjectManager(driver);
	pageObjectManager = new PageObjectManager(testBase.WebDriverManager());//driver is passed from TestBase Class
	
	genericUtils = new GenericUtils(testBase.WebDriverManager());
	
	this.driver = testBase.WebDriverManager();  // Initialize the driver using WebDriverManager
	}

}

//WebDriverManager() is blood of the project 
//TestContextSetup {  heart of the project so its pumping the driver to each & every part of the project
// therfore inshort driver reaches TestContextSetup via WebDriverManager concept  