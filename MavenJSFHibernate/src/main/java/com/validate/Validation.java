package com.validate;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class Validation implements Validator {
	
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		String name=(String)value;
		if (name.charAt(2)=='a') {
				System.out.println("validate()");
				FacesMessage msg=new FacesMessage("name","the third character of the name should not contain a");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(msg);
		}
			
				
			
	}
}

