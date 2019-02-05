package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PropertiesPage {
	private WebDriver driver;

	public PropertiesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// 3. Click on All Dates list box
	@FindBy(xpath = "//select[@id='filter-by-date']")
	private WebElement allDates;

	public void addDates() {
		this.allDates.click();
	}

	// 4. Select valid credentials in All Dates list box
	@FindBy(xpath = "//select[@id='filter-by-date']")
	private WebElement date;

	public void validCredentialsInDateBox() {
		this.date.click();
		Select sc = new Select(date);
		sc.selectByVisibleText("March 2018");
	}

	// 5. Click on Filter button
	@FindBy(id = "post-query-submit")
	private WebElement filter;

	public void filterResult() {
		this.filter.click();
	}
	
	//6 To verify the properties for filter search result as Admin
		@FindBy(linkText="admin")
		private WebElement adminProperties;

		public String AdminProperties() {
			String str1=adminProperties.getText();
			return str1;
		}


	
}