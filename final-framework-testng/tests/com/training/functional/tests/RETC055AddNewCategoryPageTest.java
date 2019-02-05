package com.training.functional.tests;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import com.training.generics.ScreenShot;
import com.training.pom.AddNewCategoryPage;
import com.training.pom.LoginAdmin;
import com.training.pom.CommonComponents;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;

public class RETC055AddNewCategoryPageTest {
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private AddNewCategoryPage addNewCategoryPage;
	private LoginAdmin loginAdmin;
	private CommonComponents commonComponents;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		addNewCategoryPage = new AddNewCategoryPage(driver);
		loginAdmin = new LoginAdmin(driver);
		commonComponents = new CommonComponents(driver);
		baseUrl = properties.getProperty("baseURL");
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
	public void addNViewCommentsInBlogPageTest() throws InterruptedException {
		commonComponents.clickPosts();
		commonComponents.addNewPostLinkClick();
		addNewCategoryPage.addNewCategoryButtonClick();
		Thread.sleep(3000);
		addNewCategoryPage.enterCategoryTestBox("Plots2123");
		addNewCategoryPage.selectParentCategory();
		addNewCategoryPage.addNewCatagoryClick();
		addNewCategoryPage.refreshPageView();
		addNewCategoryPage.enterTitle("vihar1");
		addNewCategoryPage.enterTextBody(" New Launch in Plots");
		addNewCategoryPage.createdCategorySelected();
		addNewCategoryPage.publishButton();
		String Expected = "Post published. View post";
		String Actual = addNewCategoryPage.assertPublish();
		assertEquals(Actual, Expected);
		screenShot.captureScreenShot("Post Published");
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
}
