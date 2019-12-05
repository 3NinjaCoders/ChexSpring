package com.chex.model.admin.newplace;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class NewPlaceValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return FormPlace.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		FormPlace place = (FormPlace)obj;
		
		ValidationUtils.rejectIfEmpty(errors, "x", "addnewplace.validation.x.empty");
		ValidationUtils.rejectIfEmpty(errors, "y", "addnewplace.validation.y.empty");
		ValidationUtils.rejectIfEmpty(errors, "name", "addnewplace.validation.name.empty");
		ValidationUtils.rejectIfEmpty(errors, "points", "addnewplace.validation.points.empty");
		
		try {
			int num = Integer.parseInt(place.getPoints());
			if(num < 0) {
				errors.rejectValue("points", "addnewplace.validation.points.wrongvalue");
			}
		}catch(NumberFormatException e) {
			errors.rejectValue("points", "addnewplace.validation.points.wrongtype");
		}
		
		try {
			Double.parseDouble(place.getX());
		}catch(NumberFormatException e) {
			errors.rejectValue("x", "addnewplace.validation.x.wrongtype");
		}
		
		try {
			Double.parseDouble(place.getY());
		}catch(NumberFormatException e) {
			errors.rejectValue("y", "addnewplace.validation.y.wrongtype");
		}
	}

}
