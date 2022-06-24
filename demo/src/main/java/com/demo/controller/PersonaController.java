package com.demo.controller;

import java.net.http.HttpResponse;
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

import com.demo.model.Persona;
import com.demo.model.Proveedor;
import com.demo.repository.MarcaRepository;
import com.demo.repository.PersonaRepository;

@RestController
@RequestMapping("/api/v1/persona")
public class PersonaController {

	@Autowired
	PersonaRepository personaepository;

	@GetMapping("/listAll")
	public List<Persona> listPersona() {
		return personaepository.findAll();
	}

	@PostMapping("/insert")
	public ResponseEntity<Persona> createPersona(@RequestBody Persona persona) {
		try {
			Persona _persona = personaepository
					.save(new Persona( persona.getCedula(), persona.getNombre_ape(), persona.getEdad(),
							persona.getSexo(), persona.getTelefono(), persona.getCorreo(),persona.getFecha_carga(), persona.getUsuarios()));
			return new ResponseEntity<>(_persona, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/edit/{id}")
	ResponseEntity<Persona> replacePersona(@RequestBody Persona persona, @PathVariable Integer id) {

		if (personaepository.existsById(id)) {
			return new ResponseEntity<Persona>(personaepository.findById(id).map(_persona -> {
				_persona.setCedula(persona.getCedula());
				_persona.setNombre_ape(persona.getNombre_ape());
				_persona.setEdad(persona.getEdad());
				_persona.setSexo(persona.getSexo());
				_persona.setTelefono(persona.getTelefono());
				_persona.setCorreo(persona.getCorreo());
				_persona.setFecha_carga(persona.getFecha_carga());
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
	
	
}
