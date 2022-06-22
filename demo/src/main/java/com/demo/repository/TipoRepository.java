package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Tipo;

public interface TipoRepository extends JpaRepository<Tipo, Long> {

}
