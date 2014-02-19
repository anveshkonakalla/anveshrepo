package com.otv;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.otv.util.HibernateUtil;


public class UserManagedBean implements Serializable{
private static final long serialVersionUID = 1L;
private static Logger log = Logger.getLogger(UserManagedBean.class);
private static final String SUCCESS = "success";
private static final String ERROR   ="error";
private String name;
private String surname=null;
private String message;
private List<User> userList;
	 
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
	 	 
 public List<User> getUserList() {
		return userList;
	}
 public void setUserList(List<User> userList) {
		this.userList = userList;
	}
 public String getMessage() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("Name : ").append(this.getName());
		strBuff.append(", Surname : ").append(this.getSurname());
		this.setMessage(strBuff.toString());
		return this.message;
	 }
 public void setMessage(String message) {
	 	this.message = message;
	 }
	 
	 public String save() {
	 
	    String result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
	    User user = new User();
	    user.setName(this.getName());
	    user.setSurname(this.getSurname());
	    Transaction tx = null;
	   try {
			   tx = session.beginTransaction();
			   session.save(user);
			   tx.commit();
			   log.debug("New Record : " + user + ", wasCommitted : " + tx.wasCommitted());
			   result = SUCCESS;
			   getUsers();
	       } catch (Exception e) {
			   if (tx != null) {
				    tx.rollback();
				    result = ERROR;
				    System.out.println(e);
			   }
	       } finally {
	    	   session.close();
	       }
	   		return result;
	 }
	 
 public void getUsers() {
		log.debug("getUsers() method Called");
	    Session session = HibernateUtil.getSessionFactory().openSession();
		userList = session.createCriteria(User.class).list();
	 }
	 
 public void reset() {
		 this.name=null;
		 this.surname=null;
	 }

}