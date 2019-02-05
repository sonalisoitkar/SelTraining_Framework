package com.training.functional.tests;

import org.testng.annotations.Test;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import com.training.generics.ScreenShot;
import com.training.pom.CommonComponents;
import com.training.pom.DisplayPropertiesPage;
import com.training.pom.LoginAdmin;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;

public class RETC053DisplayAllPropertiesInNewWindowTest {
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private DisplayPropertiesPage displayProperties;
	private LoginAdmin loginAdmin;
	private CommonComponents commonComponents;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		displayProperties = new DisplayPropertiesPage(driver);
		baseUrl = properties.getProperty("baseURL");
		loginAdmin = new LoginAdmin(driver);
		commonComponents=new CommonComponents(driver);
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@Test(priority = 0)
	public void validLoginTest() {
		loginAdmin.sendUserName("admin");
		loginAdmin.sendPassword("admin@123");
		loginAdmin.clickLoginBtn();
		screenShot.captureScreenShot("First");
	}

	@Test(priority = 1)
	public void displayPropertiesPageTest() throws AWTException, InterruptedException {
		commonComponents.clickProperties();
		commonComponents.allProperties();
		displayProperties.trashLink();
		displayProperties.searchTextBoxEntered("DelProperty3");
		displayProperties.searchPropertiesButton();
		String propertyName="DelProperty3";
		displayProperties.trashPropertyLinks(propertyName);
		String Actual = displayProperties.assertMessage();
		String Expected = "1 post restored from the Trash.";
		assertEquals(Actual, Expected);
		screenShot.captureScreenShot("PropertyRestored1");
		displayProperties.allPropertiesDisplayedInNewWindow();
		commonComponents.clickProperties();
		commonComponents.allProperties();
		displayProperties.searchTextBoxEntered("DelProperty3");
		displayProperties.searchPropertiesButton();

	}
	 @AfterClass 
	  public void tearDown() throws Exception 
	  { Thread.sleep(1000);
	  driver.quit(); }
	 
	}
