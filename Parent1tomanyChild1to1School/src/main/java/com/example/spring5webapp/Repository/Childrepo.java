package com.example.spring5webapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring5webapp.Entities.Children;

@Repository
public interface Childrepo extends JpaRepository<Children, Integer> {
//	@EntityGraph(attributePaths = {"parent", "school"})
	List<Children> findByName(String name);
}
