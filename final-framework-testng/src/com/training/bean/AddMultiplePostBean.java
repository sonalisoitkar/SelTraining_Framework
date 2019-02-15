package com.training.bean;

public class AddMultiplePostBean {
	private String categoryName;
	private String slugName;
	private String parentCatagory;
	private String enterDescription;
	private String title;
	private String textBody;
	private String createdCategory;

	public AddMultiplePostBean() {
	}

public AddMultiplePostBean(String categoryName, String slugName, String parentCatagory, String enterDescription, String title, String textbody, String createdCategory) {
		super();
		this.categoryName = categoryName;
		this.slugName = slugName;
		this.parentCatagory = parentCatagory;
		this.enterDescription = enterDescription;
		this.title=title;
		this.textBody=textbody;
		this.createdCategory=createdCategory;
	}

	public String getcategoryName() {
		return categoryName;
	}

	public void setcategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getslugName() {
		return slugName;
	}

	public void setslugName(String slugName) {
		this.slugName = slugName;
	}

	public String getparentCatagory() {
		return parentCatagory;
	}

	public void setparentCatagory(String parentCatagory) {
		this.parentCatagory = parentCatagory;
	}

	public String getenterDescription() {
		return enterDescription;
	}

	public void setenterDescription(String enterDescription) {
		this.enterDescription = enterDescription;
	}
	
	public String gettitle() {
		return categoryName;
	}

	public void settitle(String title) {
		this.title = title;
	}
	
	public String gettextBody() {
		return textBody;
	}

	public void settextBody(String textBody) {
		this.textBody = textBody;
	}
	
	public String getcreatedCategory() {
		return createdCategory;
	}

	public void setcreatedCategory(String createdCategory) {
		this.createdCategory = createdCategory;
	}

	@Override
	public String toString() {
		return "AddMultiplePostBean [categoryName=" + categoryName + ", slugName=" + slugName + ",parentCategory="
				+ parentCatagory + ",enterDescription=" + enterDescription + ",title=" + title + ",textBody=" + textBody + ",createdCategory=" + createdCategory + ",]";

	}

}
