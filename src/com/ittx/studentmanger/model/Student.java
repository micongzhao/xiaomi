package com.ittx.studentmanger.model;

public class Student {
	private String name;
	private int number;
	private int age;	
	private boolean sex;
	private String img;
	
	
	public Student(String name, int number,int age, boolean sex,String img) {
		super();
		this.name = name;
		this.number = number;
		this.age = age;	
		this.sex = sex;
		this.img=img;
	}






	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getImg() {
		return img;
	}
	
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", img=" + img + ", number=" + number
				+ ", age=" + age + ", sex=" + sex + "]";
	}
	
	
}
