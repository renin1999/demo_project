package com.demo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuario", uniqueConstraints=
@UniqueConstraint(columnNames={"username"}))
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idusuario;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idpersona")
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
	
	
	@Column(name = "fechacarga")
	private LocalDate fecha_carga;
	
	public Usuario() {
		super();
	}

	@OneToMany(mappedBy = "idusuario", cascade = CascadeType.MERGE)
	@JsonIgnore
	private List<Administrador> admin;
	
	@OneToMany(mappedBy = "idusuario", cascade = CascadeType.MERGE)
	@JsonIgnore
	private List<Gerente> gerente;

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public Persona getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(Persona idpersona) {
		this.idpersona = idpersona;
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

	public List<Administrador> getAdmin() {
		return admin;
	}

	public void setAdmin(List<Administrador> admin) {
		this.admin = admin;
	}

	public List<Gerente> getGerente() {
		return gerente;
	}

	public void setGerente(List<Gerente> gerente) {
		this.gerente = gerente;
	}

	/**
	 * @param idusuario
	 * @param idpersona
	 * @param username
	 * @param userpassword
	 * @param fecha_carga
	 * @param admin
	 * @param gerente
	 */
	public Usuario(Integer idusuario, Persona idpersona,
			@Size(min = 1, max = 20, message = "Se pasado de la longuitud") @NotNull(message = "No se permite valores nulos") @NotEmpty(message = "El detalle es requerida") String username,
			@Size(min = 1, max = 16, message = "Se pasado de la longuitud") @NotNull(message = "No se permite valores nulos") @NotEmpty(message = "El detalle es requerida") String userpassword,
			LocalDate fecha_carga, List<Administrador> admin, List<Gerente> gerente) {
		super();
		this.idusuario = idusuario;
		this.idpersona = idpersona;
		this.username = username;
		this.userpassword = userpassword;
		this.fecha_carga = fecha_carga;
		this.admin = admin;
		this.gerente = gerente;
	}

	@Override
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", idpersona=" + idpersona + ", username=" + username
				+ ", userpassword=" + userpassword + ", fecha_carga=" + fecha_carga + ", admin=" + admin + ", gerente="
				+ gerente + "]";
	}


	
	
	
	
}
