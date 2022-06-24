package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {

}
