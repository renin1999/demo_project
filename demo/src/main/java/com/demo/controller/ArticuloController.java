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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.demo.model.Articulo;
import com.demo.model.Marca;
import com.demo.model.Proveedor;
import com.demo.repository.ArticuloRepository;

@RestController
@RequestMapping("api/v1/articulo")
public class ArticuloController {
	
	@Autowired
	ArticuloRepository articuloRepository;
	
	@GetMapping("/listAll")
	public List<Articulo> listArticulo(){
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
							articulo.getFecha_carga(), articulo.getVentas(), articulo.getCompras()));
			
			return new ResponseEntity<>(_articulo, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/edit/{id}")
	ResponseEntity<Articulo> replaceArticulo(@RequestBody Articulo articulo, @PathVariable Integer id) {
		if (articuloRepository.existsById(id)) {
			return new ResponseEntity<Articulo>(articuloRepository.findById(id).map(_articulo -> {
				_articulo.setTipo(articulo.getTipo());
				_articulo.setMarca(articulo.getMarca());
				_articulo.setCod_articulo(articulo.getCod_articulo());
				_articulo.setDetalle(articulo.getDetalle());
				_articulo.setValor_compra(articulo.getValor_compra());
				_articulo.setValor_venta(articulo.getValor_compra());
				_articulo.setStock_final(articulo.getStock_final());
				_articulo.setFecha_carga(articulo.getFecha_carga());
				return articuloRepository.save(_articulo);
			}).get(), HttpStatus.OK);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor not found");
	}
	
	@DeleteMapping("/delete/{id}")
	ResponseEntity<Proveedor> deleteArticulo(@PathVariable Integer id) {
		boolean existsUserById = articuloRepository.existsById(id);
		if (existsUserById) {
			articuloRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor not found");
	}
	
	
}
