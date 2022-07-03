package com.demo.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

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

import com.demo.model.Articulo;
import com.demo.model.Compra;
import com.demo.repository.ArticuloRepository;
import com.demo.repository.CompraRepository;

@RestController
@RequestMapping("/api/v1/compra")
public class CompraController {
	
	@Autowired
		CompraRepository compraRepository;
		ArticuloRepository arti;
		ArticuloController artic;
	
	
	@GetMapping("/listAll")
	public List<Compra> listCompra(){
		return compraRepository.findAll();
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Compra> createCompra(@Valid @RequestBody Compra compra){
		try {
			LocalDate date = LocalDate.now();
			if(compra.getIdarticulo().compraaddstock(compra.getCantidad(),compra.getIdarticulo())!=null) {
				Compra _compra = compraRepository.save(
						new Compra(
								compra.getIdcompra(),
							    compra.getCodcompra(),
								compra.getIdarticulo(),
								compra.getIdproveedor(),
								compra.getCantidad(),
								compra.getValor(),
								compra.getCantidad()*compra.getValor(),
								compra.getFecha_compra(),
								date
								));
				
				artic.replaceArticulo(compra.getIdarticulo(), compra.getIdarticulo().getIdarticulo());
				return new ResponseEntity<>(_compra, HttpStatus.CREATED);
			}
			else {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			
		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PutMapping("/edit/{id}")
	ResponseEntity<Compra> replaceCompra(@Valid @RequestBody Compra compra, @PathVariable Integer id) {
		
		if (compraRepository.existsById(id)) {
			LocalDate fecha = LocalDate.now();
			
			if(compra.getIdarticulo().compraaddstock(compra.getCantidad(),compra.getIdarticulo())!=null) {
				return new ResponseEntity<Compra>(compraRepository.findById(id).map(_compra -> {
					_compra.setCodcompra(compra.getCodcompra());
					_compra.setIdarticulo(compra.getIdarticulo());
					_compra.setIdproveedor(compra.getIdproveedor());
					_compra.setCantidad(compra.getCantidad());
					_compra.setValor(compra.getValor());
					_compra.setTotal_compra(compra.getCantidad()*compra.getValor());
					_compra.setFecha_compra(compra.getFecha_compra());
					_compra.setFecha_carga(fecha);
					return compraRepository.save(_compra);
				}).get(), HttpStatus.OK);
			}
			
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Compra not found");
	}
	

	@DeleteMapping("/delete/{id}")
	ResponseEntity<Compra> deleteCompra(@PathVariable Integer id) {
		boolean existsUserById = compraRepository.existsById(id);
		if (existsUserById) {
			compraRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Compra not found");
	}
	
	@GetMapping("/list/{id}")
	public ResponseEntity<Compra> searchCompras(@PathVariable Integer id) {
		try {
			return new ResponseEntity<>(compraRepository.findById(id).get(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
