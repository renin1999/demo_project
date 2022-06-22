package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Marca;
import com.demo.model.Tipo;
import com.demo.repository.MarcaRepository;
import com.demo.repository.TipoRepository;

@RestController
@RequestMapping("/api/v1/tipo")
public class TipoController {
	
	@Autowired
	  TipoRepository tiporepository;
	
	 @GetMapping("/all")
	 public List<Tipo> index(){
		 return tiporepository.findAll(); 
	 }
	 
	 @PostMapping("/insert")
	 public ResponseEntity<Tipo> createProveedor(@RequestBody Tipo tipo) {
		 try {
		    	Tipo _tiporepository = tiporepository
		    			.save(new Tipo (tipo.getCodtipo(),tipo.getDetalles(),tipo.getFecha_carga()));
		    			
		    			
		      return new ResponseEntity<>(_tiporepository, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		 
	 }
}
