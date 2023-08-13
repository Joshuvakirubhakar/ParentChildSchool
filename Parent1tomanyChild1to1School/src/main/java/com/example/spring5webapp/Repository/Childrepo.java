package com.example.spring5webapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring5webapp.Entities.Children;

@Repository
public interface Childrepo extends JpaRepository<Children, Integer> {

}
