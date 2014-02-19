package com.jsfrichfaces.registation;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.richfaces.hibernate.HibernateUtil;

public class RegistationService {
	
	
	/**
	 * Home Page member variables
	 */
	private int rid;
	private String uname;
	private String fname;
	private String lname;
	private String pwd;
	private String conformpwd;
	private String email;
	private String phoneno;
	
	/**
	 * 	
	 * Getter and Setter methods
	 */
	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}

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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getConformpwd() {
		return conformpwd;
	}

	public void setConformpwd(String conformpwd) {
		this.conformpwd = conformpwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	/**
	 * Hibernate Member Variables
	 */
	private static String RESULT;
	private Session session;
	private Transaction transaction;
	
	public String registationsave()
	{
		session=HibernateUtil.getSessionFactory().openSession();	
		transaction=session.beginTransaction();
		Registation register=new Registation();
		register.setRid(this.getRid());
		register.setUname(this.getUname());
		register.setFname(this.getFname());
		register.setLname(this.getLname());
		register.setPwd(this.getPwd());
		register.setConformpwd(this.getConformpwd());
		register.setEmail(this.getEmail());
		register.setPhoneno(this.getPhoneno());
		
		try {
				session.save(register);
				transaction.commit();
				RESULT="success";
			
		    } catch (Exception e) {
				System.out.println(e);
				RESULT="fail";
		    }
		return RESULT;
	 }
	public void registationclear()
	{
		System.out.println("clear");
		uname=null;
		setUname(null);
		fname=null;
		lname=null;
		pwd=null;
		conformpwd=null;
		email=null;
	}
	 

}
