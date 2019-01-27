package com.training.pom;

import java.awt.Desktop.Action;
import com.training.functional.tests.LoginTests;
import org.apache.http.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RETC022ChangeRoleOfUser {
	private WebDriver driver;

	public RETC022ChangeRoleOfUser(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//1. Click on Users link
	@FindBy(xpath = "//*[@id='menu-users']/a/div[2]")
	private WebElement Users;

	public void Users() {
		this.Users.click();
	}
//2. Click on All Users link
	@FindBy(xpath = "//a[@class='wp-first-item current']")
	private WebElement allUsers;

	public void allUsers() {
		Actions action = new Actions(driver);
		action.moveToElement(allUsers).build().perform();
		allUsers.click();
	}
//3. Click on the checkbox beside the user
	@FindBy(id = "user_153")
	private WebElement userselected;

	public void userSelected() {
		System.out.println("Checkbox should get selected");
		userselected.click();
	}

	// 4. Click on Change role to list box
	@FindBy(id = "new_role")
	private WebElement newrole;

	public void changeToNewRole() {
		newrole.click();

	}

	// 5. Select valid credentials in change role to list box
	@FindBy(id = "new_role")
	private WebElement changerole;

	public void changeRole() {
		Select chRole = new Select(changerole);
		chRole.selectByVisibleText("Agent");
	}

	// 6. Click on Change button
	@FindBy(id = "changeit")
	private WebElement change;

	public void clickChange(String firstname) {
		change.click();
	}

	// 7.To verify the assertion of changed roles.
	@FindBy(xpath = "//*[@id='message']/p")
	private WebElement changedRole;

	public String AssertRole() throws InterruptedException {
		Thread.sleep(3000);
		String str1 = changedRole.getText();
		System.out.println(str1);
		return str1;
	}

}
