package com.demo.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.demo.model.Administrador;
import com.demo.model.Compra;
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
	
	@PutMapping("/edit/{id}")
	ResponseEntity<Gerente> replaceGerente(@RequestBody Gerente gerente, @PathVariable Long id) {
		
		if (gerenteRepository.existsById(id)) {
			return new ResponseEntity<Gerente>(gerenteRepository.findById(id).map(_gerente -> {
				_gerente.setIdusuario(gerente.getIdusuario());
				_gerente.setFecha_carga(gerente.getFecha_carga());
				return gerenteRepository.save(_gerente);
			}).get(), HttpStatus.OK);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Gerente not found");
	}
	
	@DeleteMapping("/delete/{id}")
	ResponseEntity<Gerente> deleteGerente(@PathVariable Long id) {
		boolean existsUserById = gerenteRepository.existsById(id);
		if (existsUserById) {
			gerenteRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Gerente not found");
	}
}
