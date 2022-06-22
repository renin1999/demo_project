package com.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idusuario;
	
	@OneToOne
	@JoinColumn(name = "idpersona")
	private Persona persona;
	
	@Column(name = "username")
	private String username;
	@Column(name = "userpassword")
	private String userpassword;
	@Column(name = "fecha_carga")
	private LocalDate fecha_carga;
	
	public Usuario() {
		super();
	}

	public Usuario(Persona persona, String username, String userpassword, LocalDate fecha_carga) {
		super();
		this.persona = persona;
		this.username = username;
		this.userpassword = userpassword;
		this.fecha_carga = fecha_carga;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getUsername() {
		return username;
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

	@Override
	public String toString() {
		return "Usuario [" + (idusuario != null ? "idusuario=" + idusuario + ", " : "")
				+ (persona != null ? "persona=" + persona + ", " : "")
				+ (username != null ? "username=" + username + ", " : "")
				+ (userpassword != null ? "userpassword=" + userpassword + ", " : "")
				+ (fecha_carga != null ? "fecha_carga=" + fecha_carga : "") + "]";
	}
	
	
	
	
	
}
