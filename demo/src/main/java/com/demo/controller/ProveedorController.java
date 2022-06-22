package com.demo.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Proveedor;
import com.demo.repository.ProveedorRepository;


@RestController
@RequestMapping("/api/v1")
public class ProveedorController {
	
	@Autowired
	  ProveedorRepository prov;
	
	 @GetMapping("/all")
	 public List<Proveedor> index(){
		 return prov.findAll(); 
	 }
	 
	 @PostMapping("/insert")
	 public ResponseEntity<Proveedor> createProveedor(@RequestBody Proveedor proveedor) {
		 try {
		    	Proveedor _proveedor = prov
		          .save(new Proveedor(proveedor.getCodproveedor(), proveedor.getNombre_ape(), proveedor.getTelefono(), proveedor.getCorreo(),proveedor.getDireccion(), proveedor.getFecha_carga()));
		      return new ResponseEntity<>(_proveedor, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		 
	 }
	 
	 
	/*
	@GetMapping("/tutorials")
	  public ResponseEntity<List<Proveedor>> getAllProveedor(@RequestParam(required = false) String codproveedor) {
	    try {
	      List<Proveedor> tutorials = new ArrayList<Proveedor>();
	      if (codproveedor == null)
	    	  prov.findAll().forEach(tutorials::add);
	      else
	    	  prov.findByCodProveedor(codproveedor).forEach(tutorials::add);
	      if (tutorials.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(tutorials, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @GetMapping("/tutorials/{id}")
	  public ResponseEntity<Proveedor> getProveedorById(@PathVariable("id") long id) {
	    Optional<Proveedor> tutorialData = prov.findById(id);
	    if (tutorialData.isPresent()) {
	      return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  @PostMapping("/tutorials")
	  public ResponseEntity<Proveedor> createTutorial(@RequestBody Proveedor tutorial) {
	    try {
	    	Proveedor _tutorial = prov
	          .save(new Proveedor(tutorial.getCodproveedor(), tutorial.getNombre_ape(), tutorial.getTelefono(), tutorial.getCorreo(),tutorial.getDireccion(), tutorial.getFecha_carga()));
	      return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  @PutMapping("/tutorials/{id}")
	  public ResponseEntity<Proveedor> updateTutorial(@PathVariable("id") long id, @RequestBody Proveedor tutorial) {
	    Optional<Proveedor> tutorialData = prov.findById(id);
	    if (tutorialData.isPresent()) {
	    	Proveedor _tutorial = tutorialData.get();
	      _tutorial.setCodproveedor(tutorial.getCodproveedor());
	      _tutorial.setCorreo(tutorial.getCorreo());
	      _tutorial.setDireccion(tutorial.getDireccion());
	      _tutorial.setFecha_carga(tutorial.getFecha_carga());
	      _tutorial.setNombre_ape(tutorial.getNombre_ape());
	      _tutorial.setTelefono(tutorial.getTelefono());
	      
	      return new ResponseEntity<>(prov.save(_tutorial), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  @DeleteMapping("/tutorials/{id}")
	  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
	    try {
	      prov.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  @DeleteMapping("/tutorials")
	  public ResponseEntity<HttpStatus> deleteAllTutorials() {
	    try {
	      prov.deleteAll();
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
*/
}
