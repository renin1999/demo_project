package com.demo.controller;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Administrador;
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
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
