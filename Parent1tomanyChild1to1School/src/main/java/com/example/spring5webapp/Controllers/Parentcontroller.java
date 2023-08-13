package com.example.spring5webapp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring5webapp.DTO.ResponseDTO;
import com.example.spring5webapp.Entities.Children;
import com.example.spring5webapp.Entities.Parent;
import com.example.spring5webapp.Repository.Childrepo;

@RestController
@RequestMapping("/parent")
public class Parentcontroller {
	
	@Autowired
	private Childrepo childrepo;
	
	@GetMapping("/get")
	public List<Children> getParent() {
//		Parent parent = parentrepo.findById(id).get();
//		List<Children> child = parent.getChildren();
//		for(Children children: child) {
//			children.getSchool();
//		}
		List<Children> children = childrepo.findAll();
	
		return children;
	}
	
	@GetMapping("/{id}")
	public Children getParentById(@PathVariable int id) {
//		Parent parent = parentrepo.findById(id).get();
//		List<Children> child = parent.getChildren();
//		for(Children children: child) {
//			children.getSchool();
//		}
		Children children = childrepo.findById(id).get();
//		children.getSchool().getChildren().getName();
		System.out.println(children.getSchool().getChildren().getName());
		return children;
	}
	
	@PostMapping
	public ResponseEntity<Children> postDetails(@RequestBody Children children){
//		
//		parentrepo.save(parent);
//		Parent parent1 = getParentById(parent.getPid());
//		ResponseDTO dto = new ResponseDTO();
//		List<String> childrenlist = new ArrayList<String>();
//		
//		dto.setParent_id(parent1.getPid());
//		dto.setParent_name(parent1.getName());
//		dto.setContact(parent1.getPhoneno());
//		
//		for(Children children2: parent.getChildren()) {
//			StringBuffer children = new StringBuffer();
//			
//			children.append("Name: "+children2.getName());
//			children.append("\\n");
//			children.append("School Name: "+children2.getSchool().getSchool_name());
//			children.append("\\n");
//			children.append("Location: "+ children2.getSchool().getState());
//			
//			childrenlist.add(children.toString());
//		}
//		dto.setChildren_school_location(childrenlist);
//		return new ResponseEntity<>(dto,HttpStatus.OK);
		childrepo.save(children);
		return new ResponseEntity<>(children,HttpStatus.OK);
	}

}
