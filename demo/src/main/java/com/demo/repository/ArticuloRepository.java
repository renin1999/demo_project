package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Articulo;

public interface ArticuloRepository extends JpaRepository<Articulo, Long> {

}
