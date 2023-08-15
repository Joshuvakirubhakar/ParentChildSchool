package com.example.spring5webapp.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring5webapp.Builder.ResponseBuilder;
import com.example.spring5webapp.DTO.ResponseDTO;
import com.example.spring5webapp.Entities.Children;
import com.example.spring5webapp.Exception.IdNotFoundException;
import com.example.spring5webapp.Repository.Childrepo;
import com.example.spring5webapp.Service.ChildService;

@Service
public class ChildServiceImpl implements ChildService {

	@Autowired
	private Childrepo childrepo;
	@Autowired
	private ResponseBuilder responseBuilder;

	@Override
	public List<Children> getChildren() {
		List<Children> children = childrepo.findAll();
		return children;
	}

	@Override
	public Children getChildrenById(int id) {
		Optional<Children>	children = childrepo.findById(id);
		return children.orElseThrow(()->new IdNotFoundException("Children with id: " + id + ", Not found !!!"));
	}

	@Override
	public ResponseDTO postDetails(Children children) {
		children = childrepo.save(children);
		ResponseDTO responseDTO = responseBuilder.getResponseDto(children);
		return responseDTO;
	}

	@Override
	public String deleteChildrenById(int id) {
		Children children = null;
		try {
			children = getChildrenById(id);
//			childrepo.deleteById(children.getCid());
			childrepo.deleteById(id); 
		} catch (Exception e) {
			throw new IdNotFoundException("Cannot delete children with Id: " + id + " --> ID Not found !!!");
		}
		System.out.println(children.getSchool().getChildren().getParent().getName());
		return "Child with id: " + id + " was Deleted successfully";
	}

}
