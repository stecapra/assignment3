package com.assignment3.actions.userArea;

import com.assignment3.actions.BaseAction;
import com.assignment3.actions.LoggedIn;
import com.assignment3.miscellaneous.DatabaseUtil;
import com.assignment3.models.Course;
import com.assignment3.models.User;

public class EditCourseAction extends BaseAction implements LoggedIn{
	
	private String name;
	private String cfu;
	
	public String getCfu() {
		return cfu;
	}

	public void setCfu(String cfu) {
		this.cfu = cfu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
	public void validate() {
		if(getName().isEmpty() | !isUniqueCourse(getName())) {
			addFieldError("name", "name is not valid");
		}
		if(getCfu().isEmpty()) {
			addFieldError("cfu", "cfu is not valid");
		}
	}
	
	public String execute() {
		createNewCourse(getName(), getCfu());
		return SUCCESS;
	}
	
	public void createNewCourse(String name, String cfu) {
		Course course = new Course(name, cfu);
		User user = DatabaseUtil.getNewInstance().findByField(User.class, "id", session.get("userId"));
		user.addCourse(course);
		course.addUser(user);
		DatabaseUtil.getNewInstance().save(course);
	}
	
	public boolean isUniqueCourse(String name) {
		return DatabaseUtil.getNewInstance().findByField(Course.class, "name", name) == null;
	}
	
}
