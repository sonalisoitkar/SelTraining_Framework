package com.training.bean;

public class AddFeaturesBean {
	private String featureName; 
	private String slugName;
	private String enterDescription;
	
	public AddFeaturesBean() {
	}

	public AddFeaturesBean(String featureName, String slugName,String enterDescription) {
		super();
		this.featureName = featureName;
		this.slugName = slugName;
		this.enterDescription = enterDescription;
	}

	public String getfeatureName() {
		return featureName;
	}

	public void setfeatureName(String featureName) {
		this.featureName = featureName;
	}

	public String getslugName() {
		return slugName;
	}

	public void setslugName(String slugName) {
		this.slugName = slugName;
	}
	
	public String getenterDescription() {
		return enterDescription;
	}

	public void setenterDescription(String enterDescription) {
		this.enterDescription = enterDescription;
	}

	@Override
	public String toString() {
		return "LoginBean [featureName=" + featureName + ", slugName=" + slugName + ",enterDescription=" + enterDescription + "]";
	}

}
