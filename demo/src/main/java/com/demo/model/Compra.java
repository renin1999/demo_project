package com.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "compras",  uniqueConstraints=
@UniqueConstraint(columnNames={"codcompra"}))
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcompra;
	
	
	@Column(name = "codcompra", columnDefinition = "TEXT")
	@Lob
	@Size(min = 1, max = 20, message =  "Se pasado de la longuitud")
	@NotNull(message = "No se permite valores nulos")
	@NotEmpty(message = "El codigo del compra es requerida")
	private String codcompra;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idarticulo")
	private Articulo idarticulo;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idproveedor")
	private Proveedor idproveedor;
	
	@NotNull
	@Min(0)
	@Column(name = "cantidad")
	private Integer cantidad;
	
	@Column(name = "valor")
	@DecimalMin(value = "0.01", message = "Valor debe ser positivo...")
	private double valor;
	
	@Column(name = "totalcompra")
	@DecimalMin(value = "0.01", message = "Valor debe ser positivo...")
	private double total_compra;
	
	@Column(name = "fechacompra")
	private LocalDate fecha_compra;
	
	@Column(name = "fechacarga")
	private LocalDate fecha_carga;
	
	
	public Compra() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getIdcompra() {
		return idcompra;
	}


	public void setIdcompra(Integer idcompra) {
		this.idcompra = idcompra;
	}


	public String getCodcompra() {
		return codcompra;
	}


	public void setCodcompra(String codcompra) {
		this.codcompra = codcompra;
	}


	public Articulo getIdarticulo() {
		return idarticulo;
	}


	public void setIdarticulo(Articulo idarticulo) {
		this.idarticulo = idarticulo;
	}


	public Proveedor getIdproveedor() {
		return idproveedor;
	}


	public void setIdproveedor(Proveedor idproveedor) {
		this.idproveedor = idproveedor;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public double getTotal_compra() {
		return total_compra;
	}


	public void setTotal_compra(double total_compra) {
		this.total_compra = total_compra;
	}


	public LocalDate getFecha_compra() {
		return fecha_compra;
	}


	public void setFecha_compra(LocalDate fecha_compra) {
		this.fecha_compra = fecha_compra;
	}


	public LocalDate getFecha_carga() {
		return fecha_carga;
	}


	public void setFecha_carga(LocalDate fecha_carga) {
		this.fecha_carga = fecha_carga;
	}


	/**
	 * @param idcompra
	 * @param codcompra
	 * @param idarticulo
	 * @param idproveedor
	 * @param cantidad
	 * @param valor
	 * @param total_compra
	 * @param fecha_compra
	 * @param fecha_carga
	 */
	public Compra(Integer idcompra,
			@Size(min = 1, max = 20, message = "Se pasado de la longuitud") @NotNull(message = "No se permite valores nulos") @NotEmpty(message = "El codigo del compra es requerida") String codcompra,
			Articulo idarticulo, Proveedor idproveedor, @NotNull @Min(0) Integer cantidad,
			@DecimalMin(value = "0.01", message = "Valor debe ser positivo...") double valor,
			@DecimalMin(value = "0.01", message = "Valor debe ser positivo...") double total_compra,
			LocalDate fecha_compra, LocalDate fecha_carga) {
		super();
		this.idcompra = idcompra;
		this.codcompra = codcompra;
		this.idarticulo = idarticulo;
		this.idproveedor = idproveedor;
		this.cantidad = cantidad;
		this.valor = valor;
		this.total_compra = total_compra;
		this.fecha_compra = fecha_compra;
		this.fecha_carga = fecha_carga;
	}


	@Override
	public String toString() {
		return "Compra [idcompra=" + idcompra + ", codcompra=" + codcompra + ", idarticulo=" + idarticulo
				+ ", idproveedor=" + idproveedor + ", cantidad=" + cantidad + ", valor=" + valor + ", total_compra="
				+ total_compra + ", fecha_compra=" + fecha_compra + ", fecha_carga=" + fecha_carga + "]";
	}
	
	
	
	
}
