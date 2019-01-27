package com.training.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginAdmin {
	private WebDriver driver; 
	
	public LoginAdmin(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement signin; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.signin.click(); 
	}
	
	/*
	public void login(String userNames, String Passwords)
	{
		this.userName.clear();
		this.userName.sendKeys(userName);
		
		this.password.clear(); 
		this.password.sendKeys(password); 
		
		this.signin.click(); 
		
	}
		*/
		
	
}
