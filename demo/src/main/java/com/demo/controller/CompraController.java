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

import com.demo.model.Compra;

import com.demo.repository.CompraRepository;

@RestController
@RequestMapping("/api/v1/compra")
public class CompraController {
	
	@Autowired
		CompraRepository compraRepository;
	
	
	@GetMapping("/listAll")
	public List<Compra> listCompra(){
		return compraRepository.findAll();
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Compra> createAdministrador(@RequestBody Compra compra){
		try {
			Compra _compra = compraRepository.save(
					new Compra(
						    compra.getCodcompra(),
							compra.getIdarticulo(),
							compra.getIdproveedor(),
							compra.getCantidad(),
							compra.getValor(),
							compra.getTotal_compra(),
							compra.getFecha_compra(),
							compra.getFecha_carga()
							));
			return new ResponseEntity<>(_compra, HttpStatus.CREATED);
		} catch (Exception e) {
			Compra _compra = compraRepository.save(
					new Compra(
							compra.getCodcompra(),
							compra.getIdarticulo(),
							compra.getIdproveedor(),
							compra.getCantidad(),
							compra.getValor(),
							compra.getTotal_compra(),
							compra.getFecha_compra(),
							compra.getFecha_carga()
							));
			// TODO: handle exception
			return new ResponseEntity<>(_compra, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PutMapping("/edit/{id}")
	ResponseEntity<Compra> replaceCompra(@RequestBody Compra compra, @PathVariable Integer id) {
		
		if (compraRepository.existsById(id)) {
			return new ResponseEntity<Compra>(compraRepository.findById(id).map(_compra -> {
				_compra.setCodcompra(compra.getCodcompra());
				_compra.setIdarticulo(compra.getIdarticulo());
				_compra.setIdproveedor(compra.getIdproveedor());
				_compra.setCantidad(compra.getCantidad());
				_compra.setValor(compra.getValor());
				_compra.setTotal_compra(compra.getTotal_compra());
				_compra.setFecha_compra(compra.getFecha_compra());
				_compra.setFecha_carga(compra.getFecha_carga());
				return compraRepository.save(_compra);
			}).get(), HttpStatus.OK);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Administrador not found");
	}
	

	@DeleteMapping("/delete/{id}")
	ResponseEntity<Compra> deleteCompra(@PathVariable Integer id) {
		boolean existsUserById = compraRepository.existsById(id);
		if (existsUserById) {
			compraRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Administrador not found");
	}
}
