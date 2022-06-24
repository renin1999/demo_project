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

import com.demo.model.Proveedor;
import com.demo.repository.ProveedorRepository;

@RestController
@RequestMapping("/api/v1/proveedor")
public class ProveedorController {

	@Autowired
	ProveedorRepository proveedorRepository;

	@GetMapping("/listAll")
	public List<Proveedor> listProveedor() {
		return proveedorRepository.findAll();
	}

	@PostMapping("/insert")
	public ResponseEntity<Proveedor> createProveedor(@RequestBody Proveedor proveedor) {
		try {
			LocalDate date = LocalDate.now();
			Proveedor _proveedor = proveedorRepository
					.save(new Proveedor(proveedor.getCodproveedor(), proveedor.getNombre_ape(), proveedor.getTelefono(),
							proveedor.getCorreo(), proveedor.getDireccion(), proveedor.getCompras(),date));
			return new ResponseEntity<>(_proveedor, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<Proveedor> SearchProveedor(@PathVariable Integer id) {
		try {
			return new ResponseEntity<>(proveedorRepository.findById(id).get(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/edit/{id}")
	ResponseEntity<Proveedor> replaceProveedor(@RequestBody Proveedor proveedor, @PathVariable Integer id) {
		
		if (proveedorRepository.existsById(id)) {
			return new ResponseEntity<Proveedor>(proveedorRepository.findById(id).map(prov -> {
				prov.setCodproveedor(proveedor.getCodproveedor());
				prov.setNombre_ape(proveedor.getNombre_ape());
				prov.setTelefono(proveedor.getTelefono());
				prov.setCorreo(proveedor.getCorreo());
				prov.setDireccion(proveedor.getDireccion());
				prov.setFecha_carga(proveedor.getFecha_carga());
				return proveedorRepository.save(prov);
			}).get(), HttpStatus.OK);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor not found");
	}

	@DeleteMapping("/delete/{id}")
	ResponseEntity<Proveedor> deleteProveedor(@PathVariable Integer id) {
		boolean existsUserById = proveedorRepository.existsById(id);
		if (existsUserById) {
			proveedorRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor not found");
	}
	
}
