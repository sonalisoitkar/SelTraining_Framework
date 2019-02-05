package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewUserAction {
	private WebDriver driver;

	public AddNewUserAction(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// 2. Click on Add New link
	@FindBy(linkText = "Add New")
	private WebElement addNewUser;

	public void addNewUser() throws InterruptedException {
		Thread.sleep(5000);
		addNewUser.click();
	}

	// 3. Enter Valid credentials in Username textbox
	@FindBy(xpath = "//input[@id='user_login']")
	private WebElement userlogin;

	public void userLogin(String userlogin) {
		this.userlogin.sendKeys(userlogin);
	}

	// 4. Enter Valid credentials in Email textbox
	@FindBy(id = "email")
	private WebElement email;

	public void email(String email) {
		this.email.sendKeys(email);
	}

	// 5. Enter Valid credentials in First Name textbox

	@FindBy(id = "first_name")
	private WebElement firstname;

	public void firstName(String firstname) {
		this.firstname.sendKeys(firstname);
	}

	// 6. Enter Valid credentials in Last Name textbox
	@FindBy(id = "last_name")
	private WebElement lastname;

	public void lastName(String lastname) {
		this.lastname.sendKeys(lastname);
	}

	// 7. Enter Valid credentials in Website textbox
	@FindBy(id = "url")
	private WebElement url;

	public void showUrl(String url) {
		this.url.sendKeys(url);
	}

	// 8. Click on Show Password button
	// @FindBy(xpath = "//button[contains(text(),'Show password')]")
	@FindBy(xpath = "//*[@id=\"createuser\"]/table/tbody/tr[6]/td/button")
	private WebElement showpassword;

	public void showPassword() throws InterruptedException {
		Thread.sleep(10000);
		this.showpassword.click();
	}
	// 9. Enter Valid credentials in Password Textbox

	@FindBy(xpath = "//*[@id='pass1-text' or id ='pass1']")

	private WebElement passwordtext;

	public void enterPassword(String pwd) throws InterruptedException {
		Thread.sleep(5000);

		this.passwordtext.sendKeys(pwd);
	}

	// 10. Click on Role list box
	@FindBy(id = "role")
	private WebElement role;

	public void clickRoleList() {
		this.role.click();
	}

	// 11. Select Valid credentials in Role list box
	@FindBy(id = "role")
	private WebElement roleList;

	public void validCredentialsInListBox() {
		this.role.click();
		Select sc = new Select(roleList);
		sc.selectByVisibleText("Agent");
	}

	// 12. Click on Add New User button
	@FindBy(id = "createusersub")
	private WebElement createusersub;

	public void createUsers() throws InterruptedException {
		this.createusersub.click();
		Thread.sleep(3000);
	}

	// RETC022_3. Click on the checkbox beside the user
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
