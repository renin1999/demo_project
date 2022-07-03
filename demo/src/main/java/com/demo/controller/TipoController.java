package com.demo.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
import com.demo.model.Tipo;
import com.demo.repository.MarcaRepository;
import com.demo.repository.TipoRepository;

@RestController
@RequestMapping("/api/v1/tipo")
public class TipoController {
	
	@Autowired
	  TipoRepository tiporepository;
	
	 @GetMapping("/listAll")
	 public List<Tipo> index(){
		 return tiporepository.findAll(); 
	 }
	 
	 @PostMapping("/insert")
	 public ResponseEntity<Tipo> createTipo(@Valid @RequestBody Tipo tipo) {
		 try {
			 LocalDate date = LocalDate.now();
		    	Tipo _tiporepository = tiporepository
		    			.save(new Tipo ( tipo.getCodtipo(),tipo.getDetalles(),date, tipo.getArti()));
		    			
		    			
		      return new ResponseEntity<>(_tiporepository, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		 
	 }
	 
	 
	 @PutMapping("/edit/{id}")
		ResponseEntity<Tipo> replaceTipo(@Valid @RequestBody Tipo tipo, @PathVariable Integer id) {
			
			if (tiporepository.existsById(id)) {
				LocalDate fecha = LocalDate.now();
				return new ResponseEntity<Tipo>(tiporepository.findById(id).map(_tipo -> {
					_tipo.setCodtipo(tipo.getCodtipo());
					_tipo.setDetalles(tipo.getDetalles());
					_tipo.setFecha_carga(fecha);
					return tiporepository.save(_tipo);
				}).get(), HttpStatus.OK);
			}
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo not found");
		}
	 
	 
	 @DeleteMapping("/delete/{id}")
		ResponseEntity<Tipo> deleteTipo(@PathVariable Integer id) {
			boolean existsTipoById = tiporepository.existsById(id);
			if (existsTipoById) {
				tiporepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo not found");
		}
	 

	 
	 @GetMapping("/list/{id}")
		public ResponseEntity<Tipo> searchTipo(@PathVariable Integer id) {
			try {
				return new ResponseEntity<>(tiporepository.findById(id).get(), HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
}
