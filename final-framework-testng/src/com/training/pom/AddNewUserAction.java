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
	//11. Select Valid credentials in Role list box
	@FindBy(id = "role")
	private WebElement roleList;

	public void validCredentialsInListBox(String roleList1) {
		this.role.click();
		Select sc = new Select(roleList);
		sc.selectByVisibleText(roleList1);
	}

	// 12. Click on Add New User button
	@FindBy(id = "createusersub")
	private WebElement createusersub;

	public void createUsers() throws InterruptedException {
		this.createusersub.click();
		Thread.sleep(3000);
	}
	//RETC_013 To verify the added user with successful message.
		@FindBy(xpath="//p[contains(text(),'New user created.')]")
		private WebElement userCreated;

		public String assertUserCreated() {
			String str1=userCreated.getText();
			return str1;
		}
	
	
	@FindBy(xpath="//div[@class='error']/p")
	private WebElement emailAdd;

	public String assertEmail() {
		String str1=emailAdd.getText();
		return str1;
	}
	
	}
