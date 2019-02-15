package com.training.bean;

public class AddMultipleUserBean {
	private String userlogin;
	private String email;
	private String first_name;
	private String last_name;
	private String url;
	private String passwordtext;
	private String roleList;
	

	public AddMultipleUserBean() {
	}

	public AddMultipleUserBean(String userlogin, String email,String first_name,String last_name, String url, String passwordtext, String roleList) {
		super();
		this.userlogin = userlogin;
		this.email = email;
		this.first_name = first_name;
		this.last_name=last_name;
		this.url = url;
		this.passwordtext = passwordtext;
		this.roleList = roleList;
	}

	public String getuserlogin() {
		return userlogin;
	}

	public void setuserlogin(String userlogin) {
		this.userlogin = userlogin;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
	public String getfirst_name() {
		return first_name;
	}

	public void setfirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getlast_name() {
		return last_name;
	}

	public void setlast_name(String last_name) {
		this.last_name = last_name;
	}
	public String geturl() {
		return url;
	}

	public void seturl(String url) {
		this.url = url;
	}
	public String getpasswordtext() {
		return passwordtext;
	}

	public void setpasswordtext(String passwordtext) {
		this.passwordtext = passwordtext;
	}
	public String getroleList() {
		return roleList;
	}

	public void setroleList(String roleList) {
		this.roleList = roleList;
	}

	@Override
	public String toString() {
		return "AddMultipleRegionBean [userlogin=" + userlogin + ", email=" + email + ",first_name=" + first_name + ",last_name=" + last_name + ",url=" + url + ",passwordtext=" + passwordtext + ",roleList=" + roleList + ",]";
		
	}

}
