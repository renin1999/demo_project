package com.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
	

}
