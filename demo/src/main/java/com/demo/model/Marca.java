package com.demo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marca")
public class Marca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idmarca;
	@Column(name = "codmarca")
	private String codmarca;
	@Column(name = "detalle")
	private String detalle;
	@Column(name = "fecha_carga")
	private LocalDate fecha_carga;
	
	public String getCodmarca() {
		return codmarca;
	}

	public Integer getIdmarca() {
		return idmarca;
	}

	public void setIdmarca(Integer idmarca) {
		this.idmarca = idmarca;
	}

	public void setCodmarca(String codmarca) {
		this.codmarca = codmarca;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public LocalDate getFecha_carga() {
		return fecha_carga;
	}

	public void setFecha_carga(LocalDate fecha_carga) {
		this.fecha_carga = fecha_carga;
	}

	public Marca() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param codmarca
	 * @param detalle
	 * @param fecha_carga
	 */
	public Marca(String codmarca, String detalle, LocalDate fecha_carga) {
		super();
		this.codmarca = codmarca;
		this.detalle = detalle;
		this.fecha_carga = fecha_carga;
	}

	@Override
	public String toString() {
		return "MarcaArticulo [idmarca=" + idmarca + ", codmarca=" + codmarca + ", detalle=" + detalle
				+ ", fecha_carga=" + fecha_carga + "]";
	}

}
