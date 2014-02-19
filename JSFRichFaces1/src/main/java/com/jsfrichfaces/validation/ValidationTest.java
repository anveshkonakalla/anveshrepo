package com.jsfrichfaces.validation;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.hibernate.Query;
import org.hibernate.Session;

import com.richfaces.hibernate.HibernateUtil;

public class ValidationTest implements  Validator {
	
	private Session session;
	public ValidationTest() {
		session=HibernateUtil.getSessionFactory().openSession();
	}
	public void validate(FacesContext context, UIComponent component,Object value) throws ValidatorException {
		String name=(String)value;
		System.out.println(name);
		
		Query query=session.getNamedQuery("getusername");
		List<String> list=query.list();
		try {
			  Thread.sleep(2000);			
		} catch (Exception e) {
			// TODO: handle exception
		}
		if((list!=null)&&(list.contains(name.trim()))){
			FacesMessage msg=new FacesMessage("User Exist","username is already exist");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
		else
		{
			FacesMessage msg=new FacesMessage("User Available","username available");
		    msg.setSeverity(FacesMessage.SEVERITY_INFO);
		    throw new ValidatorException(msg);
		   
		}
			
			
	}

}
