package com.training.pom;

import java.awt.Desktop.Action;
import com.training.functional.tests.LoginTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RETC023DeleteUser {
	private WebDriver driver;

	public RETC023DeleteUser(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// 1. Click on Users link
	@FindBy(xpath = "//*[@id=\"menu-users\"]/a/div[2]")
	private WebElement Users;

	public void Users() {
		System.out.println("Click on User Navigation menu");
		Actions action = new Actions(driver);
		action.moveToElement(Users).build().perform();
		this.Users.click();
	}

	// 2. Click on All Users link
	@FindBy(xpath = "//*[@id=\"menu-users\"]/ul/li[2]")
	private WebElement allUsers;

	public void allUsersShown() {
		allUsers.click();
		System.out.println("User Clicked");
	}

	// 3. Click on the checkbox beside the user
	@FindBy(id = "user_153")
	private WebElement userselected;

	public void userSelected() {
		System.out.println("User selected");
		userselected.click();
	}

	// 4. Click on Bulk Actions list box
	@FindBy(id = "bulk-action-selector-top")
	private WebElement bulkActionlist;

	public void bulkactionlist() {
		System.out.println("Click on Bulk Action list box");
		bulkActionlist.click();
	}

	// 5. Select valid credentials in Bulk Actions list box
	@FindBy(id = "bulk-action-selector-top")
	private WebElement delUser;

	public void delUser() {
		Select multi = new Select(delUser);
		multi.selectByVisibleText("Delete");
	}

	// 6. Click on Apply button
	@FindBy(id = "doaction")
	private WebElement applybutton;

	public void applyButton() {
		applybutton.click();
	}

	// 7. Click on Confirm Deletion button
	@FindBy(id = "submit")
	private WebElement confirmDeletion;

	public void confirmDelete() {
		confirmDeletion.click();
	}
	// 8.To verify the assertion of changed roles.
	@FindBy(xpath = "//*[@id='message']/p")
	private WebElement deleteUser;

	public String AssertRole() throws InterruptedException {
		Thread.sleep(3000);
		String str1 = deleteUser.getText();
		System.out.println(str1);
		return str1;
	}
}
