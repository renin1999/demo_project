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
import com.demo.model.Usuario;

import com.demo.repository.UsuarioRespository;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
	@Autowired
	UsuarioRespository usuarioRespository;
	
	
	@GetMapping("/listAll")
	public List<Usuario> listUsuario(){
		return usuarioRespository.findAll();
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
		try {
			LocalDate date = LocalDate.now();
			Usuario _usuario = usuarioRespository.save(
					new Usuario(
							usuario.getIdpersona(),usuario.getUsername(),usuario.getUserpassword(),date, usuario.getAdmin(), usuario.getGerente()
							));
			return new ResponseEntity<>(_usuario, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/edit/{id}")
	ResponseEntity<Usuario> replaceUsuario(@RequestBody Usuario usuario, @PathVariable Integer id) {
		
		if (usuarioRespository.existsById(id)) {
			return new ResponseEntity<Usuario>(usuarioRespository.findById(id).map(_usuario -> {
				_usuario.setIdpersona(usuario.getIdpersona());
				_usuario.setUsername(usuario.getUsername());
				_usuario.setUserpassword(usuario.getUserpassword());
				_usuario.setFecha_carga(usuario.getFecha_carga());
				return usuarioRespository.save(_usuario);
			}).get(), HttpStatus.OK);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario not found");
	}
	
	
	@DeleteMapping("/delete/{id}")
	ResponseEntity<Usuario> deleteProveedor(@PathVariable Integer id) {
		boolean existsUserById = usuarioRespository.existsById(id);
		if (existsUserById) {
			usuarioRespository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario not found");
	}
}
