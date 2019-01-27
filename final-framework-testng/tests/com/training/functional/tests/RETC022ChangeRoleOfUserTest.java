package com.training.functional.tests;

import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.LoginAdmin;
import com.training.pom.RETC022ChangeRoleOfUser;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class RETC022ChangeRoleOfUserTest {
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private RETC022ChangeRoleOfUser retc022ChangeRoleOfUser;
	private LoginAdmin loginAdmin;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		retc022ChangeRoleOfUser = new RETC022ChangeRoleOfUser(driver);
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
	public void createUserSub() throws InterruptedException {
		retc022ChangeRoleOfUser.Users();
		Thread.sleep(1000);
		retc022ChangeRoleOfUser.allUsers();
		retc022ChangeRoleOfUser.userSelected();
		retc022ChangeRoleOfUser.changeToNewRole();
		retc022ChangeRoleOfUser.changeRole();
		retc022ChangeRoleOfUser.clickChange("Manager");

	}
	@Test(priority = 2)
	public void addNewUserAssert() throws InterruptedException {
		String Expected = "Changed roles.";
		String Actual = retc022ChangeRoleOfUser.AssertRole();
		System.out.println();
		assertEquals(Actual, Expected);
		screenShot.captureScreenShot("First");
	}
}
