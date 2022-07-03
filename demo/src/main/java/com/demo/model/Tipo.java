package com.demo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tipo", uniqueConstraints=
@UniqueConstraint(columnNames={"codtipo"}))
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
	
	@OneToMany(mappedBy = "idtipo", cascade = CascadeType.MERGE)
	@JsonIgnore
	List<Articulo> arti;
	
	
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
	public List<Articulo> getArti() {
		return arti;
	}
	public void setArti(List<Articulo> arti) {
		this.arti = arti;
		arti.forEach(entity -> arti.set(idtipo, entity));
	}
	
	public Tipo(
			@Size(min = 1, max = 20, message = "Se pasado de la longuitud") @NotNull(message = "No se permite valores nulos") @NotEmpty(message = "El codigo del tipo es requerida") String codtipo,
			@Size(min = 1, max = 150, message = "Se pasado de la longuitud") @NotNull(message = "No se permite valores nulos") @NotEmpty(message = "El detalle es requerida") String detalles,
			LocalDate fecha_carga, List<Articulo> arti) {
		super();
		this.codtipo = codtipo;
		this.detalles = detalles;
		this.fecha_carga = fecha_carga;
		this.arti = arti;
	}
	@Override
	public String toString() {
		return "Tipo [" + (idtipo != null ? "idtipo=" + idtipo + ", " : "")
				+ (codtipo != null ? "codtipo=" + codtipo + ", " : "")
				+ (detalles != null ? "detalles=" + detalles + ", " : "")
				+ (fecha_carga != null ? "fecha_carga=" + fecha_carga + ", " : "")
				+ (arti != null ? "arti=" + arti : "") + "]";
	}
	public Tipo(Integer idtipo,
			@Size(min = 1, max = 20, message = "Se pasado de la longuitud") @NotNull(message = "No se permite valores nulos") @NotEmpty(message = "El codigo del tipo es requerida") String codtipo,
			@Size(min = 1, max = 150, message = "Se pasado de la longuitud") @NotNull(message = "No se permite valores nulos") @NotEmpty(message = "El detalle es requerida") String detalles,
			LocalDate fecha_carga, List<Articulo> arti) {
		super();
		this.idtipo = idtipo;
		this.codtipo = codtipo;
		this.detalles = detalles;
		this.fecha_carga = fecha_carga;
		this.arti = arti;
	}
	

	
	
	
	

}
