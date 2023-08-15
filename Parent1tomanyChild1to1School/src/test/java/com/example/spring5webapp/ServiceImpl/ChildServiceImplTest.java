package com.example.spring5webapp.ServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spring5webapp.Builder.ResponseBuilder;
import com.example.spring5webapp.DTO.ResponseDTO;
import com.example.spring5webapp.Entities.Children;
import com.example.spring5webapp.Entities.Parent;
import com.example.spring5webapp.Entities.School;
import com.example.spring5webapp.Exception.IdNotFoundException;
import com.example.spring5webapp.Repository.Childrepo;
import com.example.spring5webapp.Service.ChildService;

@SpringBootTest
class ChildServiceImplTest {

	@Mock
	private Childrepo childrepo;
	@Mock
	private ResponseBuilder responseBuilder;

	@InjectMocks
	ChildService childService = new ChildServiceImpl();

	@DisplayName("getChildren success scenario")

	/***
	 * OUTLINE
	 * 
	 * @Test method(){ // Mocking // Calling actual method // Verification // Assert
	 *       }
	 ***/

	@Test
	void getChildren_success_test() {
		/** 1.GetChildrenByID **/
		// Mocking
		Children children = getMockChildren();
		when(childrepo.findById(anyInt())).thenReturn(Optional.of(children));

		// Calling actual method
		Children child = childService.getChildrenById(1);
		// Verification
		verify(childrepo, times(1)).findById(anyInt());
		// Assert
		assertEquals(children.getCid(), child.getCid());

		/** 2.GetALLChildren **/
		// Mocking
		List<Children> childs = getALLMockChildren();
		when(childrepo.findAll()).thenReturn(childs);
		// Calling actual method
		List<Children> childList = childService.getChildren();
		// Verification
		verify(childrepo, times(1)).findAll();
		// Assert
		assertEquals(childs.size(), childList.size());
	}

	/*******************************
	 * FAILURE SCENARIO
	 **************************************/
	@DisplayName("getChildren failure scenario")
	@Test
	void getChildren_failure_test() {
		// mocking
		int id = 1;
		when(childrepo.findById(anyInt())).thenReturn(Optional.ofNullable(null));
		// actual method call
		IdNotFoundException exception = assertThrows(IdNotFoundException.class, () -> childService.getChildrenById(id));
		// Verification
		verify(childrepo, times(1)).findById(anyInt());
//		verify(childrepo,times(1)).save(any(Children.class));
		// Assert
		assertEquals("Children with id: " + id + ", Not found !!!", exception.getMessage());
	}

	/***************************************************************************************/
	/*** POSTCHILDREN SUCCESS ***/
	@DisplayName("Post Children Success scenario")
	@Test
	void postchildrenSuccess() {
		Children child = getMockChildren();
		ResponseDTO dto = getpostRespDTO();

		/** for responseBuilder.getResponseDto() method **/
		when(responseBuilder.getResponseDto(any(Children.class))).thenReturn(dto);
//		ResponseDTO responseDTO = responseBuilder.getResponseDto(child);
//		verify(responseBuilder, times(1)).getResponseDto(any(Children.class));
//		assertEquals(dto.getChild_ID(), responseDTO.getChild_ID());

		/*** For childService.postDetails(child) ***/
		when(childrepo.save(any(Children.class))).thenReturn(child);
		ResponseDTO Child_Response = childService.postDetails(child);
		//verify
		verify(childrepo, times(1)).save(any(Children.class));
		//assert
		assertEquals(child.getCid(), Child_Response.getChild_ID());
		assertEquals(child.getName(), Child_Response.getChild_name());
		assertEquals(child.getParent().getName(), Child_Response.getParent_name());
		assertEquals(child.getParent().getPhoneno(), Child_Response.getContact());
		assertEquals(child.getSchool().getSchool_name(), Child_Response.getSchool_name());
		assertEquals(child.getSchool().getState(), Child_Response.getState());

	}
	/** 1.DeleteChildrenByID **/
	@DisplayName("delete Children Success scenario")
	@Test
	void deleteChildrenByID_success_test() {
	
		
		int id = 1;	
		String rest = "Child with id: " + id + " was Deleted successfully";
		// Mocking
//		when(childService.deleteChildrenById(anyInt()));
		//Actual
		String response = childService.deleteChildrenById(id);
		//verify
		verify(childrepo, times(1)).deleteById(anyInt());
		//assert
		assertEquals(rest, response);

	}

	/*******************************
	 * FAILURE SCENARIO
	 **************************************/
	@DisplayName("delete Children failure scenario")
	@Test
	void deleteChildrenByID_failure_test() {
		int id =1;
		// mocking
		doThrow(new IdNotFoundException("Cannot delete children with Id: " + id + " --> ID Not found !!!")).when(childrepo).deleteById(anyInt());
		
		assertThrows(IdNotFoundException.class, ()->childService.deleteChildrenById(id));
		verify(childrepo,times(1)).deleteById(anyInt());
			}
	

	private ResponseDTO getpostRespDTO() {
		ResponseDTO dto = new ResponseDTO();
		dto.setChild_ID(1);
		dto.setChild_name("Joshuva");
		dto.setParent_name("Victor");
		dto.setContact("9444471011");
		dto.setSchool_name("Ebenezer Marcus");
		dto.setState("TN");
		return dto;
	}

	private Children getMockChildren() {
		Children children = new Children();
			children.setCid(1);
			children.setName("Joshuva");
		Parent parent = new Parent();
			parent.setName("Victor");
			parent.setPhoneno("9444471011");
			children.setParent(parent);
		School school = new School();
			school.setSchool_name("Ebenezer Marcus");
			school.setState("TN");
			children.setSchool(school);
		return children;
	}

	private List<Children> getALLMockChildren() {
		List<Children> childrens = new ArrayList<>();
		Children children = new Children();
		children.setCid(1);
		children.setName("Joshuva");
		childrens.add(children);
		return childrens;
	}


}
