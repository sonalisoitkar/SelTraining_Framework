package com.training.pom;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonComponents {
	private WebDriver driver;

	public CommonComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Click on Posts link
	@FindBy(xpath = "//*[@id='menu-posts']/a/div[2]")
	private WebElement Posts;

	public void clickPosts() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(Posts).click().build().perform();
		this.Posts.click();
	}
	//Click on AllPost link
	@FindBy(xpath = "//*[@id='menu-posts']/ul/li[2]/a")
	private WebElement allPosts;

	public void clickAllPosts() throws InterruptedException {
		this.allPosts.click();
	}
	// Click on Add New link

	@FindBy(xpath = "//*[@id='menu-posts']/ul/li[3]/a")
	private WebElement addNewPost;

	public void addNewPostLinkClick() throws InterruptedException {
		// Thread.sleep(5000);
		addNewPost.click();
	}

	// Click on Categories link
	@FindBy(xpath = "//*[@id='menu-posts']/ul/li[4]/a")
	private WebElement catagoryLink;

	public void categoryLinkClick() {
		catagoryLink.click();
	}
	// Click on Users link
		@FindBy(xpath = "//div[contains(text(),'Users')]")
		private WebElement Users;

		public void Users() {
			this.Users.click();
		}

		//Click on All Users link
		@FindBy(xpath = "//*[@id='menu-users']/ul/li[2]")
		private WebElement allUsers;

		public void allUsersShown() {
			allUsers.click();

		}
		//Click on Add New link
		@FindBy(linkText = "Add New")
		private WebElement addNewUser;

		public void addNewUser() throws InterruptedException {
			Thread.sleep(5000);
			addNewUser.click();
		}

	// Click on Properties link
	@FindBy(xpath = "//*[@id='menu-posts-property']/a/div[2]")
	private WebElement properties;

	public void clickProperties() {
		this.properties.click();
	}

	// Click on All Properties link
	@FindBy(xpath = "//*[@id='menu-posts-property']/ul/li[2]/a")
	private WebElement allProperties;

	public void allProperties() throws AWTException {
		Actions action = new Actions(driver);
		action.moveToElement(this.allProperties).click().build().perform();
	}
	//Click on Add New Property
	@FindBy(xpath = "//*[@id='menu-posts-property']/ul/li[3]/a")
	private WebElement addNeww;

	public void addNewClick() {
		addNeww.click();
	}
	// Click on Feature link
		@FindBy(xpath = "//*[@id='menu-posts-property']/ul/li[4]/a")
		private WebElement featureLink;

		public void featureLinkClick() {
			featureLink.click();
		}

	// Click on Regions link
	@FindBy(xpath = "//*[@id='menu-posts-property']/ul/li[5]/a")
	private WebElement regionLink;

	public void regionLinkClick() {
		regionLink.click();
	}

	

}
