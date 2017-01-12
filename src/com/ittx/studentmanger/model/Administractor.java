package com.ittx.studentmanger.model;

public class Administractor {
	private String name;
	private String userName;
	private String passWord;

	public Administractor(String name, String userName, String passWord) {

		this.name = name;
		this.userName = userName;
		this. passWord = passWord;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		passWord = passWord;
	}

	@Override
	public String toString() {
		return "AddAdministractor [name=" + name + ", userName=" + userName
				+ ", PassWord=" + passWord + "]";
	}
}
