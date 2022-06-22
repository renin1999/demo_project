package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
