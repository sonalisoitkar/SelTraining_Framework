package com.training.functional.tests;

import org.testng.annotations.Test;

import com.training.dataproviders.DataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.CommonComponents;
import com.training.pom.LoginAdmin;
import com.training.pom.PropertiesPage;
import com.training.pom.AddNewRegionPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

/*
 * Author               :Sonali Soitkar
 * Test CaseID          :RETC_082
 * Test Case Description:To Verify whether application allows admin to Add Multiple Region in the application
 * Precondition         :user should have launched the application by entering valid URL
                        :admin should be logged in
 */

public class RETC082AddMultipleRegionsExcelTest {
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private CommonComponents commonComponents;
	private LoginAdmin loginAdmin;
	private AddNewRegionPage addMultipleRegions;

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
		addMultipleRegions = new AddNewRegionPage(driver);
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
	 * Excel.POM pages used for this test is CommonComponents and addMultipleRegions
	 */
	@Test(priority = 1, dataProvider = "excel-inputs1", dataProviderClass = DataProviders.class)
	public void addMultipleRegions(String regionName, String slugName, String parentRegion, String enterDescription) {
		// Navigation menu POM page method is invoked using commonComponents instance.
		commonComponents.clickProperties();
		commonComponents.regionLinkClick();
		// Below steps are to add regions from the excel.
		addMultipleRegions.enterRegionNameText(regionName);
		addMultipleRegions.enterSlugText(slugName);
		addMultipleRegions.selectParentRegion();
		addMultipleRegions.enterDescriptionText(enterDescription);
		addMultipleRegions.addNewRegionButtonClick();
	}

	// The annotated method will be run after all the test methods in the current
	// class have been run.
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
