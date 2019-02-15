package com.training.functional.tests;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.CommonComponents;
import com.training.pom.LoginAdmin;
import com.training.pom.PropertiesPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

/*
 * Author               :Sonali Soitkar
 * Test CaseID          :RETC_025
 * Test Case Description:TO Verify whether application allows admin to filter properties details based on the search criteria
 * Precondition         :user should have launched the application by entering valid URL 
 *                      :admin should be logged in
 */
public class RETC025PropertiesPageTest {
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private PropertiesPage propertiesPage;
	private CommonComponents commonComponents;
	private LoginAdmin loginAdmin;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		commonComponents=new CommonComponents(driver);
		propertiesPage = new PropertiesPage(driver);
		baseUrl = properties.getProperty("baseURL");
		loginAdmin = new LoginAdmin(driver);
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
	public void userProperties() throws AWTException {
		commonComponents.clickProperties();
		commonComponents.allProperties();
		propertiesPage.addDates();
		propertiesPage.validCredentialsInDateBox();
		propertiesPage.filterResult();
		
	}
	@Test(priority = 2)
	public void adminPropertiesAssert() {
		String Expected = "admin";
		String Actual = propertiesPage.AdminProperties();
		assertEquals(Actual, Expected);
		screenShot.captureScreenShot("AdminAuthorColumnPassed");
	}
}
