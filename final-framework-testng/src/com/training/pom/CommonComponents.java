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
	//RETC_051_052_053_1. Click on Properties link
		@FindBy(xpath = "//*[@id='menu-posts-property']/a/div[2]")
		private WebElement properties;

		public void clickProperties() {
			this.properties.click();
		}

		// RETC_051_052_053_2. Click on All Properties link
		@FindBy(xpath = "//*[@id='menu-posts-property']/ul/li[2]/a")
		private WebElement allProperties;

		public void allProperties() throws AWTException {
			Actions action = new Actions(driver);
			action.moveToElement(this.allProperties).click().build().perform();
					}
		//1. Mouse over on Posts link
		@FindBy(xpath = "//*[@id='menu-posts']/a/div[2]")
		private WebElement Posts;

		public void clickPosts() throws InterruptedException {
			Actions action = new Actions(driver);
			action.moveToElement(Posts).click().build().perform();
			this.Posts.click();
		}
		// 2. Click on Add New link

		@FindBy(xpath = "//*[@id=\"menu-posts\"]/ul/li[3]/a")
		private WebElement addNewPost;

		public void addNewPostLinkClick() throws InterruptedException {
			// Thread.sleep(5000);
			addNewPost.click();
		}
		// 1. Click on Users link
		@FindBy(xpath = "//*[@id=\"menu-users\"]/a/div[2]")
		private WebElement Users;

		public void Users() {
			Actions action = new Actions(driver);
			action.moveToElement(Users).build().perform();
			this.Users.click();
		}

		// 2. Click on All Users link
		@FindBy(xpath = "//*[@id=\"menu-users\"]/ul/li[2]")
		private WebElement allUsers;

		public void allUsersShown() {
			allUsers.click();
					}

		
	
}
