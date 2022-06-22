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

import com.demo.model.Administrador;
import com.demo.model.Gerente;
import com.demo.repository.AdministradorRepository;
import com.demo.repository.GerenteRepository;

@RestController
@RequestMapping
public class GerenteController {

	
	@Autowired
	GerenteRepository gerenteRepository;
	
	@GetMapping("/listAll")
	public List<Gerente> listGerente(){
		return gerenteRepository.findAll();
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Gerente> createGerente(@RequestBody Gerente gerente){
		try {
			Gerente _gerente = gerenteRepository.save(
					new Gerente(
							gerente.getIdusuario(),
							gerente.getFecha_carga()));
			return new ResponseEntity<>(_gerente, HttpStatus.CREATED);
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
