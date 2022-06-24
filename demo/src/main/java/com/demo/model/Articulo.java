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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "articulo")
public class Articulo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idarticulo;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idtipo")
	@JsonIgnore
	private Tipo idtipo;

	@ManyToOne(cascade = CascadeType.MERGE )
	@JoinColumn(name = "idmarca")
	@JsonIgnore
	private Marca idmarca;
	
		
	
	@Column(name = "cod_articulo")
	@Size(min = 1, max = 25, message =  "Se pasado de la longuitud")
	@NotNull(message = "No se permite valores nulos")
	@NotEmpty(message = "El codigo del articulo es requerida")
	private String cod_articulo;
	
	
	@Column(name = "detalle")
	private String detalle;
	
	
	@Column(name = "valor_compra")
	private float valor_compra;
	
	
	@Column(name = "valor_venta")
	private float valor_venta;
	
	
	@Column(name = "stock_final")
	private int stock_final;
	
	
	@Column(name = "fecha_carga")
	private LocalDate fecha_carga;
	
	@OneToMany(mappedBy = "idarticulo", cascade = CascadeType.MERGE)
	@JsonIgnore
	List<Venta> ventas;
	
	@OneToMany(mappedBy = "idarticulo", cascade = CascadeType.MERGE)
	@JsonIgnore
	List<Compra> compras;
	
	public Integer getIdarticulo() {
		return idarticulo;
	}
	public void setIdarticulo(Integer idarticulo) {
		this.idarticulo = idarticulo;
	}
	public Tipo getTipo() {
		return idtipo;
	}
	public void setTipo(Tipo tipo) {
		this.idtipo = tipo;
	}
	public Marca getMarca() {
		return idmarca;
	}
	public void setMarca(Marca marca) {
		this.idmarca = marca;
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
	public float getValor_compra() {
		return valor_compra;
	}
	public void setValor_compra(float valor_compra) {
		this.valor_compra = valor_compra;
	}
	public float getValor_venta() {
		return valor_venta;
	}
	public void setValor_venta(float valor_venta) {
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
	public List<Venta> getVentas() {
		return ventas;
	}
	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
		ventas.forEach(entity -> ventas.set(idarticulo, entity));
	}
	public List<Compra> getCompras() {
		return compras;
	}
	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	public Articulo( Tipo tipo, Marca marca,
			@Size(min = 1, max = 25, message = "Se pasado de la longuitud") @NotNull(message = "No se permite valores nulos") @NotEmpty(message = "El codigo del articulo es requerida") String cod_articulo,
			String detalle, float valor_compra, float valor_venta, int stock_final, LocalDate fecha_carga,
			List<Venta> ventas, List<Compra> compras) {
		super();
		this.idtipo = tipo;
		this.idmarca = marca;
		this.cod_articulo = cod_articulo;
		this.detalle = detalle;
		this.valor_compra = valor_compra;
		this.valor_venta = valor_venta;
		this.stock_final = stock_final;
		this.fecha_carga = fecha_carga;
		this.ventas = ventas;
		this.compras = compras;
	}
	
	
	public Articulo(Integer idarticulo, Tipo idtipo, Marca idmarca,
			@Size(min = 1, max = 25, message = "Se pasado de la longuitud") @NotNull(message = "No se permite valores nulos") @NotEmpty(message = "El codigo del articulo es requerida") String cod_articulo,
			String detalle, float valor_compra, float valor_venta, int stock_final, LocalDate fecha_carga,
			List<Venta> ventas, List<Compra> compras) {
		super();
		this.idarticulo = idarticulo;
		this.idtipo = idtipo;
		this.idmarca = idmarca;
		this.cod_articulo = cod_articulo;
		this.detalle = detalle;
		this.valor_compra = valor_compra;
		this.valor_venta = valor_venta;
		this.stock_final = stock_final;
		this.fecha_carga = fecha_carga;
		this.ventas = ventas;
		this.compras = compras;
	}
	public Articulo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
