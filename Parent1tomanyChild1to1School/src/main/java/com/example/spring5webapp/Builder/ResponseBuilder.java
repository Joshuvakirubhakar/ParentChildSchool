package com.example.spring5webapp.Builder;

import org.springframework.stereotype.Component;

import com.example.spring5webapp.DTO.ResponseDTO;
import com.example.spring5webapp.Entities.Children;

@Component
public class ResponseBuilder {
	
//	@Autowired
//	ChildService childService;
	
	public ResponseDTO getResponseDto(Children children) {
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setChild_ID(children.getCid());
		responseDTO.setChild_name(children.getName());
		responseDTO.setContact(children.getParent().getPhoneno());
		responseDTO.setParent_name(children.getParent().getName());
		responseDTO.setSchool_name(children.getSchool().getSchool_name());
		responseDTO.setState(children.getSchool().getState());
		return responseDTO;
		
	}

}
