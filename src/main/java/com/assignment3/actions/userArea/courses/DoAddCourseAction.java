package com.assignment3.actions.userArea.courses;

import com.assignment3.actions.BaseAction;
import com.assignment3.actions.userArea.WelcomeAction;
import com.assignment3.interfaces.LoggedAdmin;
import com.assignment3.models.helpers.CourseHelper;

public class DoAddCourseAction extends BaseAction implements LoggedAdmin {

	private static final long serialVersionUID = 1L;
	private String name;
	private String cfu;
	
	public void validate() {
		if(getName().isEmpty()) addFieldError("name", "Name required");
		else if(!CourseHelper.isUniqueName(getName())) addFieldError("name", "Course already added");
		
		if(getCfu().isEmpty()) addFieldError("cfu", "Cfu required");
		else if(!CourseHelper.isValidCfu(getCfu())) addFieldError("cfu", "Cfu must be a number");
	}
	
	public String execute() {
		CoursesService.createNewCourse(getName(), getCfu());
		
		setEdit_action(WelcomeAction.course_add);
		return SUCCESS;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCfu() {
		return cfu;
	}
	public void setCfu(String cfu) {
		this.cfu = cfu;
	}
}
