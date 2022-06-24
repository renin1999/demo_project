package com.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "administrador")
public class Administrador {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idadministrador;
	
	
	@JoinColumn(name = "idusuario" )
	@OneToOne(cascade = CascadeType.ALL)
	private Usuario idusuario;
	
	public Administrador(Integer idadministrador, Usuario idusuario, String fecha_carga) {
		super();
		this.idadministrador = idadministrador;
		this.idusuario = idusuario;
		this.fecha_carga = fecha_carga;
	}

	@Column(name= "fecha_carga")
	private String fecha_carga;

	public Integer getIdadministrador() {
		return idadministrador;
	}

	public void setIdadministrador(Integer idadministrador) {
		this.idadministrador = idadministrador;
	}

	public Usuario getIdusuario() {
		return idusuario;
	}
	
	
	
	
	

	public void setIdusuario(Usuario idusuario) {
		this.idusuario = idusuario;
	}

	public String getFecha_carga() {
		return fecha_carga;
	}

	public void setFecha_carga(String fecha_carga) {
		this.fecha_carga = fecha_carga;
	}

	public Administrador(Usuario idusuario, String fecha_carga) {
		super();
		this.idusuario = idusuario;
		this.fecha_carga = fecha_carga;
	}

	@Override
	public String toString() {
		return "Administrador [" + (idadministrador != null ? "idadministrador=" + idadministrador + ", " : "")
				+ (idusuario != null ? "idusuario=" + idusuario + ", " : "")
				+ (fecha_carga != null ? "fecha_carga=" + fecha_carga : "") + "]";
	}

	public Administrador() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	
	
	
	
}
