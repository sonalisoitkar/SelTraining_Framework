package com.training.pom;

import java.awt.Desktop.Action;
import com.training.functional.tests.LoginTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RETC024AddNewUser {
	private WebDriver driver;

	public RETC024AddNewUser(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// 1.Click on Users link
	@FindBy(xpath = "//*[@id='menu-users']/a/div[2]")
	private WebElement Users;

	public void clickUsers() throws InterruptedException {
		System.out.println("Click on user link");
		Thread.sleep(5000);
		this.Users.click();
		System.out.println("User Clicked");
	}

	// 2. Click on Add New link
	@FindBy(linkText = "Add New")
	private WebElement addNewUser;

	public void addNewUser() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("Click on Add New link");
			 addNewUser.click();
			}
	
	// 3. Enter Valid credentials in Username textbox
	@FindBy(xpath = "//input[@id='user_login']")
	private WebElement userlogin;

	public void userLogin(String userlogin) {
		System.out.println("enter credential for username");
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
		System.out.println("enter credential for firstname");
		this.firstname.sendKeys(firstname);
	}

	// 6. Enter Valid credentials in Last Name textbox
	@FindBy(id = "last_name")
	private WebElement lastname;

	public void lastName(String lastname) {
		System.out.println("enter credential for lastname");
		this.lastname.sendKeys(lastname);
	}

	// 7. Enter Valid credentials in Website textbox
	@FindBy(id = "url")
	private WebElement url;

	public void showUrl(String url) {
		this.url.sendKeys(url);
	}
    //8. Click on Show Password button
	//@FindBy(xpath = "//button[contains(text(),'Show password')]")
	@FindBy(xpath = "//*[@id=\"createuser\"]/table/tbody/tr[6]/td/button")
	private WebElement showpassword;

	public void showPassword() throws InterruptedException {
		System.out.println("click show password");
		Thread.sleep(10000);
		this.showpassword.click();
				}		
	//9. Enter Valid credentials in Password Textbox
	
	@FindBy(xpath ="//*[@id='pass1-text' or id ='pass1']")

	private WebElement passwordtext;
	
	public void enterPassword(String pwd) throws InterruptedException {
		System.out.println("entering password");
		Thread.sleep(5000);
				
		this.passwordtext.sendKeys(pwd);
			}

	//10. Click on Role list box
	@FindBy(id = "role")
	private WebElement role;

	public void clickRoleList() {
		System.out.println("clickRole");
		this.role.click();
		}
	
   //11. Select Valid credentials in Role list box
	@FindBy(id = "role")
	private WebElement roleList;

	public void validCredentialsInListBox() {
		System.out.println("Role");
		this.role.click();
		Select sc = new Select(roleList);
		sc.selectByVisibleText("Agent");
	}
	
	//12. Click on Add New User button
	@FindBy(id = "createusersub")
	private WebElement createusersub;

	public void createUsers() throws InterruptedException {
		System.out.println("New User is created");
		this.createusersub.click();
		Thread.sleep(3000);
	}
	//13 To verify the added user with successful message.
	@FindBy(xpath="//*[@id='message']/p")
	private WebElement editUser;

	public String AssertUser() {
		String str1=editUser.getText();
		System.out.println(str1);
		return str1;
	}
	
	
}










