package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Gerente;

public interface GerenteRepository extends JpaRepository<Gerente, Integer> {

}
