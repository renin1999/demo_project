package com.demo.controller;

import java.net.http.HttpResponse;
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

import com.demo.model.Administrador;
import com.demo.model.Persona;
import com.demo.model.Proveedor;
import com.demo.repository.MarcaRepository;
import com.demo.repository.PersonaRepository;


@RestController
@RequestMapping("/api/v1/persona")
public class PersonaController {

	@Autowired
	PersonaRepository personaepository;
	ComprasValidations validations;


	@GetMapping("/listAll")
	public List<Persona> listPersona() {
		return personaepository.findAll();
	}

	@PostMapping("/insert")
	public ResponseEntity<Persona> createPersona(@Valid @RequestBody Persona persona) {
		
		try {
			ComprasValidations validations = new ComprasValidations();
		
			LocalDate date = LocalDate.now();
			
			if(validations.validateCi(persona.getCedula())==true) {
				Persona _persona = personaepository
						.save(new Persona( persona.getCedula(), persona.getNombre_ape(), persona.getEdad(),
								persona.getSexo(), persona.getTelefono(), persona.getCorreo(),date, persona.getUsuarios()));
				return new ResponseEntity<>(_persona, HttpStatus.CREATED);
			}
			else
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/edit/{id}")
	ResponseEntity<Persona> replacePersona(@Valid @RequestBody Persona persona, @PathVariable Integer id) {

		if (personaepository.existsById(id)) {
			LocalDate fecha = LocalDate.now();
			return new ResponseEntity<Persona>(personaepository.findById(id).map(_persona -> {
				_persona.setCedula(persona.getCedula());
				_persona.setNombre_ape(persona.getNombre_ape());
				_persona.setEdad(persona.getEdad());
				_persona.setSexo(persona.getSexo());
				_persona.setTelefono(persona.getTelefono());
				_persona.setCorreo(persona.getCorreo());
				_persona.setFecha_carga(fecha);
				return personaepository.save(_persona);
			}).get(), HttpStatus.OK);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor not found");
	}

	
	@DeleteMapping("/delete/{id}")
	ResponseEntity<Persona> deletePersona(@PathVariable Integer id) {
		boolean existsUserById = personaepository.existsById(id);
		if (existsUserById) {
			personaepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor not found");
	}
	
	@GetMapping("/list/{id}")
	public ResponseEntity<Persona> searchPersona(@PathVariable Integer id) {
		try {
			return new ResponseEntity<>(personaepository.findById(id).get(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
