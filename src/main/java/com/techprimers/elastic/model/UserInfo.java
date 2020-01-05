package com.techprimers.elastic.model;

public class UserInfo {

	private String fname;
	private String lname;
	private String password;
	private String emailId;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "UserInfo [fname=" + fname + ", lname=" + lname + ", password=" + password + ", emailId=" + emailId
				+ "]";
	}

	
}
