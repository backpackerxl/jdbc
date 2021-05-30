package com.mysql.module;

public class Student {
	private int id;
	private String name;
	private String age;
	private String sex;
	private String birthday;
	private String class1;

	public int getId() {
		return id;
	}

	public Student(int id, String name, String age, String sex, String birthday, String class1) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.birthday = birthday;
		this.class1 = class1;
	}

	public Student(String name, String age, String sex, String birthday, String class1) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.birthday = birthday;
		this.class1 = class1;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getClass1() {
		return class1;
	}

	public void setClass1(String class1) {
		this.class1 = class1;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", birthday=" + birthday
				+ ", class1=" + class1 + "]";
	}

}
