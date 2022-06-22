package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Usuario;

public interface UsuarioRespository extends JpaRepository<Usuario, Long> {

}
