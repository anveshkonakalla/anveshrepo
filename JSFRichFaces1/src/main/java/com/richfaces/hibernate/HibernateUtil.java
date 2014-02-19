package com.richfaces.hibernate;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory = null;
	
	public static SessionFactory getSessionFactory() {
		 
		 if(sessionFactory == null) {
			   try {
			          sessionFactory = new Configuration().configure().buildSessionFactory();
		   		   } catch (HibernateException e) {
						System.out.println(e);
		           }//catch
		  }//if
		     return sessionFactory;
		 }
	public static void setSessionFactory(SessionFactory sessionFactory) {
		  HibernateUtil.sessionFactory = sessionFactory;
		 }
}
