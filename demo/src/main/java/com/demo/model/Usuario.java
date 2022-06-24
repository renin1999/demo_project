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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idusuario;
	
	@JoinColumn(nullable = false, name = "idpersona")
    @OneToOne()
	private Persona idpersona;
	
	@Size(min = 1, max = 20, message =  "Se pasado de la longuitud")
	@NotNull(message = "No se permite valores nulos")
	@NotEmpty(message = "El detalle es requerida")
	@Column(name = "username")
	private String username;
	
	@Size(min = 1, max = 16, message =  "Se pasado de la longuitud")
	@NotNull(message = "No se permite valores nulos")
	@NotEmpty(message = "El detalle es requerida")
	@Column(name = "userpassword")
	private String userpassword;
	
	
	@Column(name = "fecha_carga")
	private LocalDate fecha_carga;
	
	public Usuario() {
		super();
	}


	
	public Usuario(Persona idpersona, String username, String userpassword, LocalDate fecha_carga) {
		super();
		this.idpersona = idpersona;
		this.username = username;
		this.userpassword = userpassword;
		this.fecha_carga = fecha_carga;
	}

	
	
	
	public String getUsername() {
		return username;
	}

	public Persona getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(Persona idpersona) {
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
