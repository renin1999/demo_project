package com.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tipo")
public class Tipo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idtipo;
	
	@Size(min = 1, max = 20, message =  "Se pasado de la longuitud")
	@NotNull(message = "No se permite valores nulos")
	@NotEmpty(message = "El codigo del tipo es requerida")
	@Column(name = "codtipo")
	private String codtipo;
	
	
	@Column(name = "detalles")
	@Size(min = 1, max = 150, message =  "Se pasado de la longuitud")
	@NotNull(message = "No se permite valores nulos")
	@NotEmpty(message = "El detalle es requerida")
	private String detalles;
	
	
	@Column(name = "fecha_carga")
	private LocalDate fecha_carga;
	
	
	
	public Tipo(String codtipo, String detalles, LocalDate fecha_carga) {
		super();
		this.codtipo = codtipo;
		this.detalles = detalles;
		this.fecha_carga = fecha_carga;
	}
	public Tipo() {
		super();
	}
	public Integer getIdtipo() {
		return idtipo;
	}
	public void setIdtipo(Integer idtipo) {
		this.idtipo = idtipo;
	}
	public String getCodtipo() {
		return codtipo;
	}
	public void setCodtipo(String codtipo) {
		this.codtipo = codtipo;
	}
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	public LocalDate getFecha_carga() {
		return fecha_carga;
	}
	public void setFecha_carga(LocalDate fecha_carga) {
		this.fecha_carga = fecha_carga;
	}
	@Override
	public String toString() {
		return "Tipo [" + (idtipo != null ? "idtipo=" + idtipo + ", " : "")
				+ (codtipo != null ? "codtipo=" + codtipo + ", " : "")
				+ (detalles != null ? "detalles=" + detalles + ", " : "")
				+ (fecha_carga != null ? "fecha_carga=" + fecha_carga : "") + "]";
	}
	
	
	

}
