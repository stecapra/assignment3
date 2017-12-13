package com.assignment3.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.assignment3.models.Course;
import com.assignment3.models.User;
import com.assignment3.models.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public abstract class BaseAction extends ActionSupport implements SessionAware, Preparable {
	
	private static final long serialVersionUID = 1L;
	
	protected Map<String, Object> session;
	protected User user;
	protected Course course;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void prepare() throws Exception {
		Integer id = (Integer)session.get("userId");
		if(id != null) {
			User user = UserDAO.find(id);
			
			setUser(user);
		}
	}
}
