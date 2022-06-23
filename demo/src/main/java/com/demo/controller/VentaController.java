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

import com.demo.model.Proveedor;
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
}
