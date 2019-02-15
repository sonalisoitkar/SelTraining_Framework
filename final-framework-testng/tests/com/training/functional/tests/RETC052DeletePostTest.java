package com.training.functional.tests;

import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import com.training.generics.ScreenShot;
import com.training.pom.LoginAdmin;
import com.training.pom.CommonComponents;
import com.training.pom.DisplayPropertiesPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;

/*
 * Author               :Sonali Soitkar
 * Test CaseID          :RETC_051
 * Test Case Description:To verify whether application allows admin to delete post permanently
 * Precondition         :user should have launched the application by entering valid URL
 *                      :admin should be logged in
                        :admin should have added property details
 */

public class RETC052DeletePostTest {
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private DisplayPropertiesPage displayProperties;
	private RETC052DeletePostTest deletePostTest;
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
	public void deletePostTest() throws IOException, InterruptedException, AWTException {
		commonComponents.clickProperties();
		commonComponents.allProperties();
		displayProperties.searchTextBoxEntered("new launch");
		displayProperties.searchPropertiesButton();
		 String propertyName1="new launch";
		displayProperties.mouseOverProperty(propertyName1);
		String Actual = displayProperties.assertMessage();
		String Expected = "1 post moved to the Trash. Undo";
		assertEquals(Actual, Expected);
		screenShot.captureScreenShot("PropertyMovedToTrash");
		displayProperties.alltrashPropertyDisplayed();
		displayProperties.mouseOverOneProperty("new launch");
		String Actual1 = displayProperties.assertMessageDel();
		String Expected1 = "1 post permanently deleted.";
			assertEquals(Actual1, Expected1);
		screenShot.captureScreenShot("PropertyDeleted");
	}
	 @AfterClass 
	  public void tearDown() throws Exception 
	  { Thread.sleep(1000);
	  driver.quit(); }
	 }

