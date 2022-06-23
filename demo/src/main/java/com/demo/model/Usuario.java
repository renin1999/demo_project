package com.demo.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idusuario;
	
	@JoinColumn(name = "FK_usuario_persona", nullable = false)
    @ManyToOne()
	private Integer idpersona;
	
	@Column(name = "username")
	private String username;
	@Column(name = "userpassword")
	private String userpassword;
	@Column(name = "fecha_carga")
	private LocalDate fecha_carga;
	
	public Usuario() {
		super();
	}

	/*
	public Usuario(Persona idpersona, String username, String userpassword, LocalDate fecha_carga) {
		super();
		this.idpersona = idpersona;
		this.username = username;
		this.userpassword = userpassword;
		this.fecha_carga = fecha_carga;
	}*/
	
	public Usuario(Integer idpersona, String username, String userpassword, LocalDate fecha_carga) {
		super();
		this.idpersona = idpersona;
		this.username = username;
		this.userpassword = userpassword;
		this.fecha_carga = fecha_carga;
	}
	/*
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	*/

	
	
	
	public String getUsername() {
		return username;
	}

	public Integer getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(Integer idpersona) {
		this.idpersona = idpersona;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public LocalDate getFecha_carga() {
		return fecha_carga;
	}

	public void setFecha_carga(LocalDate fecha_carga) {
		this.fecha_carga = fecha_carga;
	}

	
	
	
	
	
}
