package com.demo.controller;

import java.time.LocalDate;
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
			 LocalDate date = LocalDate.now();
		    	Marca _marca = marc
		    			.save(new Marca ( marca.getCodmarca(),marca.getDetalle(),date, marca.getArti()));
		    			
		    			
		      return new ResponseEntity<>(_marca, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		 
	 }
	 
	 
	 @PutMapping("/edit/{id}")
		ResponseEntity<Marca> replaceMarca(@RequestBody Marca marca, @PathVariable Integer id) {
			
			if (marc.existsById(id)) {
				return new ResponseEntity<Marca>(marc.findById(id).map(mar -> {
					mar.setCodmarca(marca.getCodmarca());
					mar.setDetalle(marca.getDetalle());
					mar.setFecha_carga(marca.getFecha_carga());
					return marc.save(mar);
				}).get(), HttpStatus.OK);
			}
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Marca not found");
		}

	
	 @DeleteMapping("/delete/{id}")
		ResponseEntity<Marca> deleteMarca(@PathVariable Integer id) {
			boolean existsMarcaById = marc.existsById(id);
			if (existsMarcaById) {
				marc.deleteById(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Marca not found");
		}
}
