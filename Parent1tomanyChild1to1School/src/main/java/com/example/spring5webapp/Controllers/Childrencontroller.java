package com.example.spring5webapp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.example.spring5webapp.Service.ChildService;

@RestController
@RequestMapping("/parent")
public class Childrencontroller {

	@Autowired
	private ChildService childService;

	@GetMapping("/get")
	public List<Children> getChildren() {
		return childService.getChildren();
	}

	@GetMapping("/{id}")
	public Children getChildrenById(@PathVariable int id) {
		return childService.getChildrenById(id);
	}

	@PostMapping
	public ResponseEntity<ResponseDTO> postDetails(@RequestBody Children children) {

		return new ResponseEntity<>(childService.postDetails(children), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public String deleteChildrenById(@PathVariable int id) {
		return childService.deleteChildrenById(id);
	}

}
