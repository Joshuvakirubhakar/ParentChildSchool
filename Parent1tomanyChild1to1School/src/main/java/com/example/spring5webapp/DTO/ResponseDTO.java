package com.example.spring5webapp.DTO;

public class ResponseDTO {

	private int child_ID;
	private String child_name;
	private String parent_name;
	private String Contact;
	private String school_name;
	private String state;
	public ResponseDTO(int child_ID, String child_name, String parent_name, String contact, String school_name,
			String state) {
		super();
		this.child_ID = child_ID;
		this.child_name = child_name;
		this.parent_name = parent_name;
		Contact = contact;
		this.school_name = school_name;
		this.state = state;
	}
	public ResponseDTO() {
		super();
	}
	public int getChild_ID() {
		return child_ID;
	}
	public void setChild_ID(int child_ID) {
		this.child_ID = child_ID;
	}
	public String getChild_name() {
		return child_name;
	}
	public void setChild_name(String child_name) {
		this.child_name = child_name;
	}
	public String getParent_name() {
		return parent_name;
	}
	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}
	public String getContact() {
		return Contact;
	}
	public void setContact(String contact) {
		Contact = contact;
	}
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	
}
