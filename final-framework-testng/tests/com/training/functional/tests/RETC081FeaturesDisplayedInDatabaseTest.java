package com.training.functional.tests;

import org.testng.annotations.Test;

import com.training.dataproviders.DataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.CommonComponents;
import com.training.pom.LoginAdmin;
import com.training.pom.PropertiesPage;
import com.training.pom.AddNewFeaturePageDisplayedInDB;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

/*
 * Author               :Sonali Soitkar
 * Test CaseID          :RETC_081
 * Test Case Description:To Verify whether application allows admin to Add multiple New Feature in the application & added feature details get 
 *                      :displayed in database
 * Precondition         :user should have launched the application by entering valid URL
                        :admin should be logged in
 */

public class RETC081FeaturesDisplayedInDatabaseTest {
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private CommonComponents commonComponents;
	private LoginAdmin loginAdmin;
	private AddNewFeaturePageDisplayedInDB featuresDisplayedInDB;

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
		new PropertiesPage(driver);
		featuresDisplayedInDB = new AddNewFeaturePageDisplayedInDB(driver);
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
	 * This method is for execution of the test case steps and asserting the data
	 * from UI wrt fetched data from DB POM pages used for this test is
	 * CommonComponents and AddMultipleFeaturesDisplayedInDB
	 */
	
	@Test(priority = 1, dataProvider = "db-inputs", dataProviderClass = DataProviders.class)
	public void multipleFeaturesDisplayedinDB(String featureName, String slugName, String enterDescription){
		//Navigation menu POM page method is invoked using commonComponents instance.
		commonComponents.clickProperties();
		commonComponents.featureLinkClick();
		//Below steps are to add a new feature 
		featuresDisplayedInDB.enterFeatureNameText("New Launches");
		String featureNameText = featuresDisplayedInDB.getfeaturename();//storing value from DB in a string
		featuresDisplayedInDB.enterSlugText("launch");
		String slugNameText = featuresDisplayedInDB.getslugName();
		featuresDisplayedInDB.selectParentFeature();
		featuresDisplayedInDB.enterDescriptionText("New Launches of vilas, apartments, flats");
		String enterDescriptionText = featuresDisplayedInDB.getenterDescription();
		featuresDisplayedInDB.addNewFeatureButtonClick();
		//Below steps are to assert the value passed in application to the value fetched from DB.
		assertEquals(featureNameText, featureName);
		assertEquals(slugNameText, slugName);
		assertEquals(enterDescriptionText, enterDescription);
	}

//The annotated method will be run after all the test methods in the current class have been run.
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
