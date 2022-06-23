package com.demo.controller;

import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Persona;
import com.demo.repository.MarcaRepository;
import com.demo.repository.PersonaRepository;

@RestController
@RequestMapping("/api/v1/persona")
public class PersonaController {
	
	@Autowired
	  PersonaRepository personaepository;
	
	@GetMapping("/listAll")
	public List<Persona> index(){
		return personaepository.findAll();
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Persona> createPersona(@RequestBody Persona persona){
		try {
			Persona _persona = personaepository.save(new Persona(
					persona.getCedula(),
					persona.getNombre_ape(),
					persona.getEdad(),
					persona.getSexo(),
					persona.getTelefono(),
					persona.getCorreo(),
					persona.getFecha_carga()
					));
			return new ResponseEntity<>(_persona, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
