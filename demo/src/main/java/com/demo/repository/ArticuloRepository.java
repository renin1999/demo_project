package com.demo.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.demo.model.Articulo;



public interface ArticuloRepository extends JpaRepository<Articulo, Integer> {
	
	@Modifying 
	@Transactional
	@Query(value= "UPDATE [articulo]\n"
			+ "   SET \n"
			+ "      [stockfinal] = ?1\n"
			+ " WHERE [idarticulo] = ?2"
			, nativeQuery = true)
	public void replaceStock(int stock,int id);
}
