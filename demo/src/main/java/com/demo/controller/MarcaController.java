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

import com.demo.model.Marca;
import com.demo.model.Proveedor;
import com.demo.repository.MarcaRepository;
import com.demo.repository.ProveedorRepository;
@RestController
@RequestMapping("/api/v1/marca")
public class MarcaController {
	
	@Autowired
	  MarcaRepository marc;
	
	 @GetMapping("/all")
	 public List<Marca> index(){
		 return marc.findAll(); 
	 }
	 
	 
	 @PostMapping("/insert")
	 public ResponseEntity<Marca> createProveedor(@RequestBody Marca marca) {
		 try {
		    	Marca _marca = marc
		    			.save(new Marca (marca.getCodmarca(),marca.getDetalle(),marca.getFecha_carga()));
		    			
		    			
		      return new ResponseEntity<>(_marca, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		 
	 }
	
}
