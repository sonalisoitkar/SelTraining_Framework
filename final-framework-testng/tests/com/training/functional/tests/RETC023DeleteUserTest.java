package com.training.functional.tests;

import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.LoginAdmin;
import com.training.pom.RETC023DeleteUser;
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

public class RETC023DeleteUserTest {
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private RETC023DeleteUser retc022DelUser;
	private LoginAdmin loginAdmin;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		retc022DelUser = new RETC023DeleteUser(driver);
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
	public void DeleteUser() throws InterruptedException {
		retc022DelUser.Users();
		Thread.sleep(3000);
		//retc022DelUser.allUsersShown();
		retc022DelUser.userSelected();
		retc022DelUser.bulkactionlist();
		retc022DelUser.delUser();
		retc022DelUser.applyButton();
		retc022DelUser.confirmDelete();

	}
	@Test(priority = 2)
	public void addNewUserAssert() throws InterruptedException {
		String Expected = "User deleted.";
		String Actual = retc022DelUser.AssertRole();
		System.out.println();
		assertEquals(Actual, Expected);
		screenShot.captureScreenShot("First");
	}
}
