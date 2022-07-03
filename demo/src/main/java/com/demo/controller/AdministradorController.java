package com.demo.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	public ResponseEntity<Administrador> createAdministrador(@Valid @RequestBody Administrador administrador){
		try {
			LocalDate date = LocalDate.now();
			Administrador _administrador = administradorRepository.save(
					new Administrador(administrador.getIdadministrador(),administrador.getIdusuario(),date));
			
			return new ResponseEntity<>(_administrador, HttpStatus.CREATED);
			
		} catch (Exception e) {
			Administrador _administrador = administradorRepository.save(
					new Administrador(administrador.getIdadministrador(),administrador.getIdusuario(),administrador.getFecha_carga()));
			// TODO: handle exception
			return new ResponseEntity<>(_administrador, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/edit/{id}")
	ResponseEntity<Administrador> replaceProveedor(@RequestBody Administrador administrador, @PathVariable Integer id) {
		
		if (administradorRepository.existsById(id)) {
			return new ResponseEntity<Administrador>(administradorRepository.findById(id).map(_administrador -> {
				_administrador.setIdadministrador(administrador.getIdadministrador());
				_administrador.setFecha_carga(administrador.getFecha_carga());
				_administrador.setIdusuario(administrador.getIdusuario());
				return administradorRepository.save(_administrador);
			}).get(), HttpStatus.OK);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Administrador not found");
	}
	
	@DeleteMapping("/delete/{id}")
	ResponseEntity<Administrador> deletePersona(@PathVariable Integer id) {
		boolean existsUserById = administradorRepository.existsById(id);
		if (existsUserById) {
			administradorRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Administrador not found");
	}
	
	
	
}

