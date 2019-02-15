package com.training.functional.tests;

import org.testng.annotations.Test;
import com.training.dataproviders.DataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.CommonComponents;
import com.training.pom.LoginAdmin;
import com.training.pom.AllUserActionsPOM;
import com.training.pom.AddNewUserAction;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

/*
 * Author               :Sonali Soitkar
 * Test CaseID          :RETC_084
 * Test Case Description:To Verify whether application displays error message upon entering invalid details in required fields while creating
 *                       user by admin
 * Precondition         :user should have launched the application by entering valid URL
                        :admin should be logged in
 */

public class RETC084AddNewUserExcelTestDB {
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private AddNewUserAction addNewUserAction;
	private LoginAdmin loginAdmin;
	private CommonComponents commonComponents;

	/*
	 * This method The annotated method will be run before the first test method in
	 * the current class is invoked.
	 */

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		new AllUserActionsPOM(driver);
		addNewUserAction = new AddNewUserAction(driver);
		baseUrl = properties.getProperty("baseURL");
		loginAdmin = new LoginAdmin(driver);
		commonComponents = new CommonComponents(driver);
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

	}

	/*
	 * This method is for execution of the test case steps and fetch the data from
	 * Excel.POM pages used for this test is CommonComponents,AddNewUserAction
	 */

	@Test(priority = 1, dataProvider = "excel-inputs3", dataProviderClass = DataProviders.class)

	public void addNewUserTest(String userlogin, String email, String firstname, String lastname, String url,
			String passwordtext, String roleList1) throws InterruptedException {
		// Navigation menu POM page method is invoked using commonComponents instance.
		commonComponents.Users();
		commonComponents.addNewUser();
		// Below steps are to add new user with wrong email and email already
		// registered.
		addNewUserAction.userLogin(userlogin);
		addNewUserAction.email(email);
		screenShot.captureScreenShot("Incorrect email");
		addNewUserAction.firstName(firstname);
		addNewUserAction.lastName(lastname);
		addNewUserAction.showUrl(url);
		addNewUserAction.showPassword();
		addNewUserAction.enterPassword(passwordtext);
		addNewUserAction.clickRoleList();
		addNewUserAction.validCredentialsInListBox(roleList1);
		addNewUserAction.createUsers();
		// Below steps are to assert the wrong input value message shown in UI.
		String Actual = addNewUserAction.assertEmail();
		String incorrectEmail = "ERROR: The email address isn’t correct.";
		String registerdEmail = "ERROR: This email is already registered, please choose another one.";
		if (Actual.contains(incorrectEmail))
			Assert.assertEquals(Actual, incorrectEmail);
		else
			Assert.assertEquals(Actual, registerdEmail);

	}

// The annotated method will be run after all the test methods in the current class have been run.

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}
