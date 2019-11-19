package com.chex.registration;

import java.util.ArrayList;
import java.util.List;

public class RegistrationMessageBuilder {
	private class Message_record{	
		public Message_record(boolean is_message, String text) {
			this.is_message = is_message;
			this.text = text;
		}
		private boolean is_message;
		private String text;
	};
	
	private String message;
	private List<Message_record> message_list;
	private DataRegistrationChecker dataregistrationChecker;
	
	public RegistrationMessageBuilder() {
		message_list = new ArrayList<RegistrationMessageBuilder.Message_record>();
		message_list.add(new Message_record(true, "Hasło musi mieć conajmniej 6 znaków\n"));
		message_list.add(new Message_record(true, "Hasło musi zawierac conajmniej jedna literę i cyfrę\n"));
		message_list.add(new Message_record(true, "Pole login nie może być puste\n"));
		message_list.add(new Message_record(true, "Pole imię nie może być puste\n"));
		message_list.add(new Message_record(true, "Pole nazwisko nie może być puste\n"));
		message_list.add(new Message_record(true, "Taki login już istnieje\n"));
		message_list.add(new Message_record(true, "hasła nie są takie same\n"));
		dataregistrationChecker = new DataRegistrationChecker();
	}
	
	public boolean data_is_correct() {
		for(Message_record rgb : message_list) {
			if(rgb.is_message == false)
				return false;
		}
		message = "Dane poprawne";
		return true;
	}
	
	public String build_message() {
		message = "";
		for(Message_record rgb : message_list) {
			if(rgb.is_message == false)
				message += rgb.text;
		}
		return message;
	}

	public void check_password(String password) {
		message_list.get(0).is_message = dataregistrationChecker.check_password_size(password);
		message_list.get(1).is_message = dataregistrationChecker.check_password_alfdig(password);
	}
	
	public void check_login(String login) {
		message_list.get(2).is_message = dataregistrationChecker.check_login(login);
	}
	
	public void check_firstname(String firstname) {
		message_list.get(3).is_message = dataregistrationChecker.check_firstname(firstname);
	}
	
	public void check_lastname(String lastname) {
		message_list.get(4).is_message = dataregistrationChecker.check_lastname(lastname);
	}
	
	public void check_isnt_exist(boolean isnt_exist) {
		message_list.get(5).is_message = isnt_exist;
	}
	
	public void check_two_password(String pass1, String pass2) {
		message_list.get(6).is_message = dataregistrationChecker.check_two_passord(pass1, pass2);
	}
}
