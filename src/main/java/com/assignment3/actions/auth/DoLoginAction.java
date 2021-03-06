package com.assignment3.actions.auth;

import com.assignment3.actions.BaseAction;
import com.assignment3.interfaces.NotLoggedIn;
import com.assignment3.models.User;

public class DoLoginAction extends BaseAction implements NotLoggedIn {
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	
	public void validate() {
		if(getUsername() == null || getUsername().equals("")) addFieldError("username", "The username field is required");
		if(getPassword() == null || getPassword().equals("")) addFieldError("password", "The username field is required");
	}
	
	public String execute() {
		User user = LoginService.authenticate(getUsername(), getPassword());
		
		if(user != null) {
			String bannedeMessage = LoginService.checkIfBanned(user);
			if(bannedeMessage != null) {
				addFieldError("", "The user is banned " + bannedeMessage);
				return INPUT;
			}
			
			LoginService.saveUserIntoSession(user.getId(), session);
			
			return SUCCESS;
		}
		
		addFieldError("", "Wrong credentials");
		return INPUT;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
