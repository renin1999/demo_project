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

import com.demo.model.Marca;
import com.demo.model.Proveedor;
import com.demo.model.Usuario;
import com.demo.model.Venta;
import com.demo.repository.ProveedorRepository;
import com.demo.repository.VentaRepository;

@RestController
@RequestMapping("/api/v1/venta")
public class VentaController {

	
	@Autowired
	  VentaRepository ventaRepository;
	
	 @GetMapping("/listAll")
	 public List<Venta> listVenta(){
		 return ventaRepository.findAll(); 
	 }
	 
	 @PostMapping("/insert")
	 public ResponseEntity<Venta> createVenta(@RequestBody Venta venta) {
		 try {
			 Venta _venta = ventaRepository
		          .save(new Venta(
		        		  venta.getCodventas(),
		        		  venta.getIdarticulo(),
		        		  venta.getIdgerente(),
		        		  venta.getCantidad(),
		        		  venta.getValor(),
		        		  venta.getTotal_ventas(),
		        		  venta.getFecha_venta(),
		        		  venta.getFecha_carga()));
		      return new ResponseEntity<>(_venta, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		 
	 }
	 
	 @PutMapping("/edit/{id}")
		ResponseEntity<Venta> replaceVenta(@RequestBody Venta venta, @PathVariable Integer id) {
			
			if (ventaRepository.existsById(id)) {
				return new ResponseEntity<Venta>(ventaRepository.findById(id).map(_venta -> {
					_venta.setCodventas(venta.getCodventas());
					_venta.setIdarticulo(venta.getIdarticulo());
					_venta.setIdgerente(venta.getIdgerente());
					_venta.setCantidad(venta.getCantidad());
					_venta.setValor(venta.getValor());
					_venta.setTotal_ventas(venta.getTotal_ventas());
					_venta.setFecha_venta(venta.getFecha_venta());
					_venta.setFecha_carga(venta.getFecha_carga());
					return ventaRepository.save(_venta);
				}).get(), HttpStatus.OK);
			}
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Venta not found");
		}
	 
	 @DeleteMapping("/delete/{id}")
		ResponseEntity<Venta> deleteVenta(@PathVariable Integer id) {
			boolean existsUserById = ventaRepository.existsById(id);
			if (existsUserById) {
				ventaRepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Venta not found");
		}
}
