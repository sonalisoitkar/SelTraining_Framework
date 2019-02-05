package com.training.functional.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.CommonComponents;
import com.training.pom.DisplayPropertiesPage;
import com.training.pom.LoginAdmin;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;

public class RETC051PropertiesTrashPageTest {
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private DisplayPropertiesPage displayProperties;
	private CommonComponents commonComponents;
	private LoginAdmin loginAdmin;

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
	public void propertiesTrashPageTest() throws AWTException, InterruptedException {
		commonComponents.clickProperties();
		commonComponents.allProperties();
		displayProperties.trashLink();
		displayProperties.searchTextBoxEntered("new launch");
		displayProperties.searchPropertiesButton();
	    String propertyName="new launch";
		displayProperties.trashPropertyLinks(propertyName);
		String Actual = displayProperties.assertMessage();
		String Expected = "1 post restored from the Trash.";
		System.out.println();
		assertEquals(Actual, Expected);
		screenShot.captureScreenShot("PropertyRestored1");
		displayProperties.allPropertiesDisplayed();
		displayProperties.searchTextBoxEntered("new launch");
		displayProperties.searchPropertiesButton();
			}
	 @AfterClass 
	  public void tearDown() throws Exception 
	  { Thread.sleep(1000);
	  driver.quit(); }
	}
