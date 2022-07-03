package com.demo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "gerente")
public class Gerente {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name="idgerente", unique = true, nullable = false)
	private Integer idgerente;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idusuario")
	private Usuario idusuario;
	
	@Column(name = "fechacarga")
	private LocalDate fecha_carga;
	
	@OneToMany(mappedBy = "idgerente", cascade = CascadeType.MERGE)
	@JsonIgnore
	private List<Venta> ventas;

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

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
		ventas.forEach(entity -> ventas.set(idgerente, entity));
	}

	public Gerente(Integer idgerente, Usuario idusuario, LocalDate fecha_carga, List<Venta> ventas) {
		super();
		this.idgerente = idgerente;
		this.idusuario = idusuario;
		this.fecha_carga = fecha_carga;
		this.ventas = ventas;
	}

	public Gerente() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
