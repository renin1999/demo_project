package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Administrador;
import com.demo.repository.AdministradorRepository;

@RestController
@RequestMapping("/api/v1/administrador")
public class AdministradorController {

	@Autowired
		AdministradorRepository administradorRepository;
	
	@GetMapping("/listAll")
	public List<Administrador> listAdministrador(){
		return administradorRepository.findAll();
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Administrador> createAdministrador(@RequestBody Administrador administrador){
		try {
			Administrador _administrador = administradorRepository.save(
					new Administrador(
							administrador.getIdusuario(),
							administrador.getFecha_carga()));
			return new ResponseEntity<>(_administrador, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
