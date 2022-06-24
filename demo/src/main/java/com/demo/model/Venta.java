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
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity
@Table(name = "ventas")
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idventas;
	
	@Column(name= "codventas", unique = true, nullable = false)
	private String codventas;
	
	@ManyToOne
	@JoinColumn(name = "idarticulo")
	private Articulo idarticulo;
	
	@ManyToOne
	@JoinColumn(name = "idgerente")
	private Gerente idgerente;
	
	@Min(0)
	@Column(name= "cantidad")
	private Integer cantidad;
	
	@DecimalMin("0.1")
	@DecimalMax("100000.0")
	@Column(name= "valor")
	private double valor;
	
	@DecimalMin("0.1")
	@DecimalMax("100000.0")
	@Column(name= "total_ventas")
	private double total_ventas;
	
	
	@Column(name= "fecha_venta")
	private LocalDate fecha_venta;
	
	
	@Column(name= "fecha_carga")
	private LocalDate fecha_carga;
	
	public Venta(String codventas, Articulo idarticulo, Gerente idgerente, Integer cantidad, double valor,
			double total_ventas, LocalDate fecha_venta, LocalDate fecha_carga) {
		super();
		this.codventas = codventas;
		this.idarticulo = idarticulo;
		this.idgerente = idgerente;
		this.cantidad = cantidad;
		this.valor = valor;
		this.total_ventas = total_ventas;
		this.fecha_venta = fecha_venta;
		this.fecha_carga = fecha_carga;
	}

	public Venta() {
		super();
	}

	public Integer getIdventas() {
		return idventas;
	}

	public void setIdventas(Integer idventas) {
		this.idventas = idventas;
	}

	public String getCodventas() {
		return codventas;
	}

	public void setCodventas(String codventas) {
		this.codventas = codventas;
	}

	public Articulo getIdarticulo() {
		return idarticulo;
	}

	public void setIdarticulo(Articulo idarticulo) {
		this.idarticulo = idarticulo;
	}

	public Gerente getIdgerente() {
		return idgerente;
	}

	public void setIdgerente(Gerente idgerente) {
		this.idgerente = idgerente;
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

	public double getTotal_ventas() {
		return total_ventas;
	}

	public void setTotal_ventas(double total_ventas) {
		this.total_ventas = total_ventas;
	}

	public LocalDate getFecha_venta() {
		return fecha_venta;
	}

	public void setFecha_venta(LocalDate fecha_venta) {
		this.fecha_venta = fecha_venta;
	}

	public LocalDate getFecha_carga() {
		return fecha_carga;
	}

	public void setFecha_carga(LocalDate fecha_carga) {
		this.fecha_carga = fecha_carga;
	}

	@Override
	public String toString() {
		return "Venta [" + (idventas != null ? "idventas=" + idventas + ", " : "")
				+ (codventas != null ? "codventas=" + codventas + ", " : "")
				+ (idarticulo != null ? "idarticulo=" + idarticulo + ", " : "")
				+ (idgerente != null ? "idgerente=" + idgerente + ", " : "") + "cantidad=" + cantidad + ", valor="
				+ valor + ", total_ventas=" + total_ventas + ", "
				+ (fecha_venta != null ? "fecha_venta=" + fecha_venta + ", " : "")
				+ (fecha_carga != null ? "fecha_carga=" + fecha_carga : "") + "]";
	}
}
