package com.mysql.module;

public class Scores {
	private int id;
	private String studentid;
	private String name;
	private int linux;
	private int html;
	private int mysql;
	private int all;

	public Scores(int id, String studentid, String name, int linux, int html, int mysql, int all) {
		super();
		this.id = id;
		this.studentid = studentid;
		this.name = name;
		this.linux = linux;
		this.html = html;
		this.mysql = mysql;
		this.all = all;
	}

	public Scores(String studentid, String name, int linux, int html, int mysql) {
		super();
		this.studentid = studentid;
		this.name = name;
		this.linux = linux;
		this.html = html;
		this.mysql = mysql;
	}

	public int getAll() {
		return all;
	}

	public void setAll(int all) {
		this.all = all;
	}

	public Scores() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public int getLinux() {
		return linux;
	}

	public void setLinux(int linux) {
		this.linux = linux;
	}

	public int getHtml() {
		return html;
	}

	public void setHtml(int html) {
		this.html = html;
	}

	public int getMysql() {
		return mysql;
	}

	public void setMysql(int mysql) {
		this.mysql = mysql;
	}

	@Override
	public String toString() {
		return "Scores [id=" + id + ", studentid=" + studentid + ", name=" + name + ", linux=" + linux + ", html="
				+ html + ", mysql=" + mysql + ", all=" + all + "]";
	}
}
