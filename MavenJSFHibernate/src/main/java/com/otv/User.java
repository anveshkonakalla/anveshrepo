package com.otv;

public class User {

	private int id;
	private String name;
	private String surname;
	public int getId() {
		return id;
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		
		this.surname = surname;
	}
	
	@Override
	public String toString() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("id:").append(id);
		strBuff.append("name :").append(name);
		strBuff.append(", surname : ").append(surname);
		return strBuff.toString();
	}
}
