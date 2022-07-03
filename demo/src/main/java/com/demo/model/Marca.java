package com.demo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "marca", uniqueConstraints=
@UniqueConstraint(columnNames={"codmarca"}))
public class Marca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idmarca;
	
	

	@Size(min = 1, max = 20, message =  "Se pasado de la longuitud")
	@NotNull(message = "No se permite valores nulos")
	@NotEmpty(message = "El codigo es requerida")
	@Column(name = "codmarca")
	private String codmarca;
	
	
	@Size(min = 1, max = 150, message =  "Se pasado de la longuitud")
	@NotNull(message = "No se permite valores nulos")
	@NotEmpty(message = "El detalle es requerida")
	@Column(name = "detalle")
	private String detalle;
	

	@Column(name = "fecha_carga")
	private LocalDate fecha_carga;
	
	public String getCodmarca() {
		return codmarca;
	}

	@OneToMany(mappedBy= "idarticulo",cascade = CascadeType.MERGE )
	@JsonIgnore
	List<Articulo> arti;

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

	
	public List<Articulo> getArti() {
		return arti;
	}

	public void setArti(List<Articulo> arti) {
		this.arti = arti;
	}

	public Marca() {
		// TODO Auto-generated constructor stub
	}

	public Marca(Integer idmarca,
			@Size(min = 1, max = 20, message = "Se pasado de la longuitud") @NotNull(message = "No se permite valores nulos") @NotEmpty(message = "El codigo es requerida") String codmarca,
			@Size(min = 1, max = 150, message = "Se pasado de la longuitud") @NotNull(message = "No se permite valores nulos") @NotEmpty(message = "El detalle es requerida") String detalle,
			LocalDate fecha_carga, List<Articulo> arti) {
		super();
		this.idmarca = idmarca;
		this.codmarca = codmarca;
		this.detalle = detalle;
		this.fecha_carga = fecha_carga;
		this.arti = arti;
	}

	public Marca(
			@Size(min = 1, max = 20, message = "Se pasado de la longuitud") @NotNull(message = "No se permite valores nulos") @NotEmpty(message = "El codigo es requerida") String codmarca,
			@Size(min = 1, max = 150, message = "Se pasado de la longuitud") @NotNull(message = "No se permite valores nulos") @NotEmpty(message = "El detalle es requerida") String detalle,
			LocalDate fecha_carga, List<Articulo> arti) {
		super();
		this.codmarca = codmarca;
		this.detalle = detalle;
		this.fecha_carga = fecha_carga;
		this.arti = arti;
	}

	

}
