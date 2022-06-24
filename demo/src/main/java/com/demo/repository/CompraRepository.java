package com.demo.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.demo.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Integer> {
	
	

}
