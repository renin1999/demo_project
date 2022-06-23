package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {

	boolean existsById(Integer id);

}
