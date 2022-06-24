package com.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "articulo")
public class Articulo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idarticulo;

	@ManyToOne
	@JoinColumn(name = "idtipo")
	@NotNull
	private Tipo tipo;

	@ManyToOne
	@JoinColumn(name = "idmarca")
	@NotNull
	private Marca marca;
	
	
	
	@NotEmpty(message = "Codigo articulo es requerido")
	@Size(min = 1, max = 20, message = "Longuitud pasado")
	@Column(name = "cod_articulo")
	private String cod_articulo;
	
	
	@Column(name = "detalle")
	@NotEmpty(message = "Detalle articulo es requerido")
	@Size(min=2, max=20, message = "Pasado del limite de caracteres")
	private String detalle;
	
	@NotNull
	@NotEmpty(message = "Valor compra articulo es requerido")
	@Column(name = "valor_compra")
	@DecimalMax("100000.0") 
	@DecimalMin("0.1")
	private double valor_compra;
	
	@NotEmpty(message = "Valor venta articulo es requerido")
	@DecimalMax("100000.0") 
	@DecimalMin("0.1")
	@Column(name = "valor_venta")
	private double valor_venta;
	
	@NotEmpty(message = "Valor venta articulo es requerido")
	@Column(name = "stock_final")
	@Min(0)
	private int stock_final;
	
	
	@Column(name = "fecha_carga")
	@NotEmpty(message = "Fecha carga articulo es requerido")
	private LocalDate fecha_carga;
	
	public Articulo() {
		super();
	}

	public Articulo(Tipo tipo, Marca marca, String cod_articulo, String detalle, double valor_compra,
			double valor_venta, int stock_final, LocalDate fecha_carga) {
		super();
		this.tipo = tipo;
		this.marca = marca;
		this.cod_articulo = cod_articulo;
		this.detalle = detalle;
		this.valor_compra = valor_compra;
		this.valor_venta = valor_venta;
		this.stock_final = stock_final;
		this.fecha_carga = fecha_carga;
	}

	public Integer getIdarticulo() {
		return idarticulo;
	}

	public void setIdarticulo(Integer idarticulo) {
		this.idarticulo = idarticulo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public String getCod_articulo() {
		return cod_articulo;
	}

	public void setCod_articulo(String cod_articulo) {
		this.cod_articulo = cod_articulo;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public double getValor_compra() {
		return valor_compra;
	}

	public void setValor_compra(double valor_compra) {
		this.valor_compra = valor_compra;
	}

	public double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}

	public int getStock_final() {
		return stock_final;
	}

	public void setStock_final(int stock_final) {
		this.stock_final = stock_final;
	}

	public LocalDate getFecha_carga() {
		return fecha_carga;
	}

	public void setFecha_carga(LocalDate fecha_carga) {
		this.fecha_carga = fecha_carga;
	}

	@Override
	public String toString() {
		return "Articulo [" + (idarticulo != null ? "idarticulo=" + idarticulo + ", " : "")
				+ (tipo != null ? "tipo=" + tipo + ", " : "") + (marca != null ? "marca=" + marca + ", " : "")
				+ (cod_articulo != null ? "cod_articulo=" + cod_articulo + ", " : "")
				+ (detalle != null ? "detalle=" + detalle + ", " : "") + "valor_compra=" + valor_compra
				+ ", valor_venta=" + valor_venta + ", stock_final=" + stock_final + ", "
				+ (fecha_carga != null ? "fecha_carga=" + fecha_carga : "") + "]";
	}

	
	
	
	
}
