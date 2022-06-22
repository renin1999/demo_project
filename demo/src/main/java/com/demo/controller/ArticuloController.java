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

import com.demo.model.Articulo;
import com.demo.model.Marca;
import com.demo.repository.ArticuloRepository;

@RestController
@RequestMapping("api/v1/articulo")
public class ArticuloController {
	
	@Autowired
	ArticuloRepository articuloRepository;
	
	@GetMapping("/all")
	public List<Articulo> index(){
		return articuloRepository.findAll();
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Articulo> createArticulo(@RequestBody Articulo articulo){
		try {
			Articulo _articulo = articuloRepository.save(
					new Articulo(
							articulo.getTipo(),
							articulo.getMarca(),
							articulo.getCod_articulo(),
							articulo.getDetalle(),
							articulo.getValor_compra(),
							articulo.getValor_venta(),
							articulo.getStock_final(),
							articulo.getFecha_carga()));
			return new ResponseEntity<>(_articulo, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	 
	
	
}
