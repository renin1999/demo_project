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

import org.springframework.web.bind.annotation.CrossOrigin;


@Entity
@Table(name = "compras")
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcompra;
	
	@Column(name = "codcompra")
	private String codcompra;
	
	@ManyToOne
	@JoinColumn()
	private Articulo idarticulo;
	
	@ManyToOne
	@JoinColumn()
	private Proveedor idproveedor;
	
	@Column(name = "cantidad")
	private Integer cantidad;
	@Column(name = "valor")
	private double valor;
	@Column(name = "total_compra")
	private double total_compra;
	@Column(name = "fecha_compra")
	private LocalDate fecha_compra;
	@Column(name = "fecha_carga")
	private LocalDate fecha_carga;
	public Compra(String codcompra, Articulo idarticulo, Proveedor idproveedor, Integer cantidad, double valor,
			double total_compra, LocalDate fecha_compra, LocalDate fecha_carga) {
		super();
		this.codcompra = codcompra;
		this.idarticulo = idarticulo;
		this.idproveedor = idproveedor;
		this.cantidad = cantidad;
		this.valor = valor;
		this.total_compra = total_compra;
		this.fecha_compra = fecha_compra;
		this.fecha_carga = fecha_carga;
	}
	public Compra() {
		super();
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
	@Override
	public String toString() {
		return "Compra [" + (idcompra != null ? "idcompra=" + idcompra + ", " : "")
				+ (codcompra != null ? "codcompra=" + codcompra + ", " : "")
				+ (idarticulo != null ? "idarticulo=" + idarticulo + ", " : "")
				+ (idproveedor != null ? "idproveedor=" + idproveedor + ", " : "")
				+ (cantidad != null ? "cantidad=" + cantidad + ", " : "") + "valor=" + valor + ", total_compra="
				+ total_compra + ", " + (fecha_compra != null ? "fecha_compra=" + fecha_compra + ", " : "")
				+ (fecha_carga != null ? "fecha_carga=" + fecha_carga : "") + "]";
	}
	
	
}
