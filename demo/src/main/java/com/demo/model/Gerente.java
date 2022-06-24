package com.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gerente")
public class Gerente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idgerente;
	
	@ManyToOne
	@JoinColumn()
	private Usuario idusuario;
	
	@Column(name = "fecha_carga")
	private LocalDate fecha_carga;

	public Gerente(Usuario idusuario, LocalDate fecha_carga) {
		super();
		this.idusuario = idusuario;
		this.fecha_carga = fecha_carga;
	}

	public Gerente() {
		super();
	}

	public Integer getIdgerente() {
		return idgerente;
	}

	public void setIdgerente(Integer idgerente) {
		this.idgerente = idgerente;
	}

	public Usuario getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Usuario idusuario) {
		this.idusuario = idusuario;
	}
	
	public LocalDate getFecha_carga() {
		return fecha_carga;
	}

	public void setFecha_carga(LocalDate fecha_carga) {
		this.fecha_carga = fecha_carga;
	}

	@Override
	public String toString() {
		return "Gerente [" + (idgerente != null ? "idgerente=" + idgerente + ", " : "")
				+ (idusuario != null ? "idusuario=" + idusuario + ", " : "")
				+ (fecha_carga != null ? "fecha_carga=" + fecha_carga : "") + "]";
	}

	

	
	
	
}
