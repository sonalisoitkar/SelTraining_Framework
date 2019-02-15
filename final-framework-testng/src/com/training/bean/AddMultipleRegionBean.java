package com.training.bean;

public class AddMultipleRegionBean {
	private String regionName;
	private String slugName;
	private String parentRegion;
	private String enterDescription;

	public AddMultipleRegionBean() {
	}

	public AddMultipleRegionBean(String regionName, String slugName, String parentRegion, String enterDescription) {
		super();
		this.regionName = regionName;
		this.slugName = slugName;
		this.parentRegion = parentRegion;
		this.enterDescription = enterDescription;
	}

	public String getregionName() {
		return regionName;
	}

	public void setregionName(String regionName) {
		this.regionName = regionName;
	}

	public String getslugName() {
		return slugName;
	}

	public void setslugName(String slugName) {
		this.slugName = slugName;
	}

	public String getparentRegion() {
		return parentRegion;
	}

	public void setparentRegion(String parentRegion) {
		this.parentRegion = parentRegion;
	}

	public String getenterDescription() {
		return enterDescription;
	}

	public void setenterDescription(String enterDescription) {
		this.enterDescription = enterDescription;
	}

	@Override
	public String toString() {
		return "AddMultipleRegionBean [regionName=" + regionName + ", slugName=" + slugName + ",parentRegion="
				+ parentRegion + ",enterDescription=" + enterDescription + ",]";

	}

}
