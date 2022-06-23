package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.demo.model.Usuario;

import com.demo.repository.UsuarioRespository;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
	@Autowired
	UsuarioRespository usuarioRespository;
	
	
	@GetMapping("/listAll")
	public List<Usuario> listUsuario(){
		return usuarioRespository.findAll();
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
		try {
			Usuario _usuario = usuarioRespository.save(
					new Usuario(
							usuario.getIdpersona(),usuario.getUsername(),usuario.getUserpassword(),usuario.getFecha_carga()
							));
			return new ResponseEntity<>(_usuario, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
