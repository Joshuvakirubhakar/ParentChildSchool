package com.example.spring5webapp.Service;

import java.util.List;
import java.util.Optional;

import com.example.spring5webapp.DTO.ResponseDTO;
import com.example.spring5webapp.Entities.Children;

public interface ChildService {
	public List<Children> getChildren() ;
	public Children getChildrenById(int id);
	public ResponseDTO postDetails(Children children);
	public String deleteChildrenById(int id);
	public List<Children> getChildrenbyname(String name);

}
