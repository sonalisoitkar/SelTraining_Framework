package com.training.functional.tests;

import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.CommonComponents;
import com.training.pom.LoginAdmin;
import com.training.pom.AddNewRegionPage;
import com.training.pom.AddNewPropertyPage;
import com.training.pom.HomePage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;
import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

/*
 * Author               :Sonali Soitkar
 * Test CaseID          :RETC_085
 * Test Case Description:To verify whether application allows admin to create property details based on the Region created & added property 
 *                       details should get displayed on home screen for user
 * Precondition         :user should have launched the application by entering valid URL
                        :admin should be logged in
 */
public class RETC085PropertyAddedAndDisplayedTest {
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private CommonComponents commonComponents;
	private LoginAdmin loginAdmin;
	private AddNewRegionPage addNewRegion;
	private AddNewPropertyPage addNewPropertyPage;
	private HomePage homePage;

	/*
	 * This method The annotated method will be run before the first test method in
	 * the current class is invoked.
	 */

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		commonComponents = new CommonComponents(driver);
		addNewRegion = new AddNewRegionPage(driver);
		addNewPropertyPage = new AddNewPropertyPage(driver);
		homePage = new HomePage(driver);
		baseUrl = properties.getProperty("baseURL");
		loginAdmin = new LoginAdmin(driver);
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	// This method is for admin login into the application
	@Test(priority = 0)
	public void validLoginTest() {
		loginAdmin.sendUserName("admin");
		loginAdmin.sendPassword("admin@123");
		loginAdmin.clickLoginBtn();
		screenShot.captureScreenShot("First");
	}

	/*
	 * This method is for execution of the test case steps and fetch the data from
	 * Excel.POM pages used for this test is CommonComponents,AddNewUserAction
	 */
	@Test(priority = 1)
	public void propertyAddedAndDisplayed() throws AWTException, InterruptedException {
		// Navigation menu POM page method is invoked using commonComponents instance.
		commonComponents.clickProperties();
		commonComponents.regionLinkClick();
		// Below steps are to add the region
		addNewRegion.enterRegionNameText("Apex city");
		addNewRegion.enterSlugText("Apex city	");
		addNewRegion.selectParentRegion();
		addNewRegion.enterDescriptionText("New Launches of villas, apartments, flats");
		addNewRegion.addNewRegionButtonClick();
		// Below steps are to go back to navigation to look in new property page
		commonComponents.allProperties();
		commonComponents.addNewClick();
		// Below steps are to add new property an select the region created above.
		addNewPropertyPage.enterTitle("prestige");
		addNewPropertyPage.enterTextBody("home town");
		addNewPropertyPage.addRegionSelected("Apex city");
		addNewPropertyPage.publishButton();
		String Expected = "Post published. View post";
		String Actual = addNewPropertyPage.assertPublish();
		assertEquals(Actual, Expected);
		screenShot.captureScreenShot("Assert Published Passed");
		addNewPropertyPage.mouseHoverIcon();
		addNewPropertyPage.clicklogoutButton();
		homePage.clickIcon();
		homePage.searchAddedProperty("prestige");
	}

	// The annotated method will be run after all the test methods in the current
	// class have been run.
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}
