package com.example.spring5webapp.DTO;

import java.util.List;

public class ResponseDTO {

	private int parent_id;
	private String parent_name;
	private String contact;
	private List<String> children_school_location;
	public ResponseDTO(int parent_id, String parent_name, String contact, List<String> children_school_location) {
		super();
		this.parent_id = parent_id;
		this.parent_name = parent_name;
		this.contact = contact;
		this.children_school_location = children_school_location;
	}
	public ResponseDTO() {
		super();
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getParent_name() {
		return parent_name;
	}
	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public List<String> getChildren_school_location() {
		return children_school_location;
	}
	public void setChildren_school_location(List<String> children_school_location) {
		this.children_school_location = children_school_location;
	}
	
}
