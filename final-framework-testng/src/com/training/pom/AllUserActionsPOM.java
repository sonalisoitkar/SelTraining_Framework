package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AllUserActionsPOM {
	private WebDriver driver;

	public AllUserActionsPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//RETC_013 To verify the added user with successful message.
	@FindBy(xpath="//*[@id='message']/p")
	private WebElement editUser;

	public String AssertUser() {
		String str1=editUser.getText();
		return str1;
	}
	
	//RETC022_3. Click on the checkbox beside the user
		@FindBy(id = "user_31")
		private WebElement userselected1;

		public void userSelected1() {
			userselected.click();
		}

		// RETC022_4. Click on Change role to list box
		@FindBy(id = "new_role")
		private WebElement newrole;

		public void changeToNewRole() {
			newrole.click();

		}

		// RETC022_5. Select valid credentials in change role to list box
		@FindBy(id = "new_role")
		private WebElement changerole;

		public void changeRole() {
			Select chRole = new Select(changerole);
			chRole.selectByVisibleText("Agent");
		}

		// RETC022_6. Click on Change button
		@FindBy(id = "changeit")
		private WebElement change;

		public void clickChange(String firstname) {
			change.click();
		}

		// RETC022_7.To verify the assertion of changed roles.
		@FindBy(xpath = "//*[@id='message']/p")
		private WebElement changedRole;

		public String AssertRole1() throws InterruptedException {
			Thread.sleep(3000);
			String str1 = changedRole.getText();
			return str1;
		}
		// RETC023_3. Click on the checkbox beside the user
		@FindBy(id = "user_32")
		private WebElement userselected;

		public void userSelected() {
			userselected.click();
		}

		// RETC023_4. Click on Bulk Actions list box
		@FindBy(id = "bulk-action-selector-top")
		private WebElement bulkActionlist;

		public void bulkactionlist() {
			bulkActionlist.click();
		}

		// RETC023_5. Select valid credentials in Bulk Actions list box
		@FindBy(id = "bulk-action-selector-top")
		private WebElement delUser;

		public void delUser() {
			Select multi = new Select(delUser);
			multi.selectByVisibleText("Delete");
		}

		// RETC023_6. Click on Apply button
		@FindBy(id = "doaction")
		private WebElement applybutton;

		public void applyButton() {
			applybutton.click();
		}

		// RETC023_7. Click on Confirm Deletion button
		@FindBy(id = "submit")
		private WebElement confirmDeletion;

		public void confirmDelete() {
			confirmDeletion.click();
		}
		// RETC023_8.To verify the assertion of changed roles.
		@FindBy(xpath = "//*[@id='message']/p")
		private WebElement deleteUser;

		public String AssertRole() throws InterruptedException {
			Thread.sleep(3000);
			String str1 = deleteUser.getText();
			return str1;
		}
}
		











