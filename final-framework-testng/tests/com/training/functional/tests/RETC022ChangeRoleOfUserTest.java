package com.training.functional.tests;

import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.AllUserActionsPOM;
import com.training.pom.CommonComponents;
import com.training.pom.LoginAdmin;
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
 * Test CaseID          :RETC_022
 * Test Case Description:To Verify whether application allows admin to change the role of registered user in Users module
 * Precondition         :user should have launched the application by entering valid URL
 *                      :admin should be logged in
 */

public class RETC022ChangeRoleOfUserTest {
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private AllUserActionsPOM allUserActionsPOM;
	private LoginAdmin loginAdmin;
	private CommonComponents commonComponents;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		allUserActionsPOM = new AllUserActionsPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		loginAdmin = new LoginAdmin(driver);
		commonComponents = new CommonComponents(driver);
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
	public void changeRolUser() throws InterruptedException {
		commonComponents.Users();
		commonComponents.allUsersShown();
		allUserActionsPOM.searchTextBoxEntered("sonali123");
		allUserActionsPOM.searchPropertiesButton();
		allUserActionsPOM.userSelected();
		allUserActionsPOM.changeToNewRole();
		allUserActionsPOM.changeRole();
		allUserActionsPOM.clickChange("Agent");

	}

	@Test(priority = 2)
	public void changedRoleUserAssert() throws InterruptedException {
		String Expected = "Changed roles.";
		String Actual = allUserActionsPOM.AssertRole();
		System.out.println();
		assertEquals(Actual, Expected);
		screenShot.captureScreenShot("ChangedRole");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
