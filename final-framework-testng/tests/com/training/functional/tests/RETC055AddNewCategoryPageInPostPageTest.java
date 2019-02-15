package com.training.functional.tests;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import com.training.generics.ScreenShot;
import com.training.pom.AddNewPostPage;
import com.training.pom.LoginAdmin;
import com.training.pom.CommonComponents;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;

/*
 * Author               :Sonali Soitkar
 * Test CaseID          :RETC_055
 * Test Case Description:To verify whether application allows admin to add new category while adding new post
 * Precondition         :user should have launched the application by entering valid URL
                        :admin should have added New Launch Post
 */

public class RETC055AddNewCategoryPageInPostPageTest {
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private AddNewPostPage addNewCategoryPage;
	private LoginAdmin loginAdmin;
	private CommonComponents commonComponents;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		addNewCategoryPage = new AddNewPostPage(driver);
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
	public void addNViewCommentsInBlogPageTest(String createdCategory1) throws InterruptedException {
		commonComponents.clickPosts();
		commonComponents.addNewPostLinkClick();
		addNewCategoryPage.addNewCategoryClick();
		Thread.sleep(3000);
		addNewCategoryPage.enterCategoryTestBox("Plots2123");
		addNewCategoryPage.selectParentCategory();
		addNewCategoryPage.addNewCatagoryClick();
		addNewCategoryPage.refreshPageView();
		addNewCategoryPage.enterTitle("vihar1");
		addNewCategoryPage.enterTextBody(" New Launch in Plots");
		addNewCategoryPage.createdCategorySelected(createdCategory1);
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
