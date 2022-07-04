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
	@Autowired
	Services service;
	
	 @GetMapping("/listAll")
	 public List<Venta> listVenta(){
		 return ventaRepository.findAll(); 
	 }
	 
	 @PostMapping("/insert")
	 public ResponseEntity<Venta> createVenta(@Valid @RequestBody Venta venta) {
		 try {
			 LocalDate date = LocalDate.now();
			 if(venta.getIdarticulo().ventaaddstock(venta.getCantidad(),venta.getIdarticulo())!=null) {
				 Venta _venta = ventaRepository
				          .save(new Venta(
				        		  venta.getIdventas(),
				        		  venta.getCodventas(),
				        		  venta.getIdarticulo(),
				        		  venta.getIdgerente(),
				        		  venta.getCantidad(),
				        		  venta.getValor(),
				        		  (venta.getCantidad()*venta.getValor()),
				        		  venta.getFecha_venta(),
				        		  date));
				 	
				 System.out.println(venta.getCantidad()+"___"+venta.getIdarticulo().getStock_final());
				    int stock= venta.getIdarticulo().getStock_final();
					Integer x = venta.getIdarticulo().getIdarticulo();
					
					  service.updatestock(stock, x);
				      return new ResponseEntity<>(_venta, HttpStatus.CREATED);
			 }
			
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			 
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		 
	 }
	 
	 @PutMapping("/edit/{id}")
		ResponseEntity<Venta> replaceVenta(@Valid @RequestBody Venta venta, @PathVariable Integer id) {
			
		 
			if (ventaRepository.existsById(id)) {
				LocalDate fecha = LocalDate.now();
				 if(venta.getIdarticulo().ventaaddstock(venta.getCantidad(),venta.getIdarticulo())!=null) {
					 return new ResponseEntity<Venta>(ventaRepository.findById(id).map(_venta -> {
							_venta.setCodventas(venta.getCodventas());
							_venta.setIdarticulo(venta.getIdarticulo());
							_venta.setIdgerente(venta.getIdgerente());
							_venta.setCantidad(venta.getCantidad());
							_venta.setValor(venta.getValor());
							_venta.setTotal_ventas(venta.getCantidad()*venta.getValor());
							_venta.setFecha_venta(venta.getFecha_venta());
							_venta.setFecha_carga(fecha);
							return ventaRepository.save(_venta);
						}).get(), HttpStatus.OK);
				 }
				
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
	 
	 @GetMapping("/list/{id}")
		public ResponseEntity<Venta> searchUsuario(@PathVariable Integer id) {
			try {
				return new ResponseEntity<>(ventaRepository.findById(id).get(), HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
}
