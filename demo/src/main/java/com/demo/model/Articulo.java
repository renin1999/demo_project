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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "articulo", uniqueConstraints=
@UniqueConstraint(columnNames={"codarticulo"}))
public class Articulo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idarticulo;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idtipo")
	private Tipo idtipo;

	@ManyToOne(cascade = CascadeType.MERGE )
	@JoinColumn(name = "idmarca")
	private Marca idmarca;
	
		
	
	@Column(name = "detalle")
	@Size(min = 1, max = 200, message =  "Se pasado de la longuitud")
	@NotNull(message = "No se permite valores nulos")
	private String detalle;

	@Column(name = "codarticulo")
	@Size(min = 1, max = 25, message =  "Se pasado de la longuitud")
	@NotNull(message = "No se permite valores nulos")
	@NotEmpty(message = "El codigo del articulo es requerida")
	private String cod_articulo;
	
	
	@Column(name = "valorcompra")
	@DecimalMin(value = "0.01", message = "Valor debe ser positivo...")
	private float valor_compra;
	
	
	@Column(name = "valorventa")
	@DecimalMin(value = "0.01", message = "Valor debe ser positivo...")
	private float valor_venta;
	
	
	@Column(name = "stockfinal")
	@Min(value= 0, message = "Valor debe ser positivo...")
	private int stock_final;
	
	
	@Column(name = "fechacarga")
	private LocalDate fecha_carga;
	
	@OneToMany(mappedBy = "idarticulo", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Compra> compras;
	
	@OneToMany(mappedBy = "idarticulo", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Venta> ventas;
	
	
	




	@Override
	public String toString() {
		return "Articulo [idarticulo=" + idarticulo + ", idtipo=" + idtipo + ", idmarca=" + idmarca + ", detalle="
				+ detalle + ", cod_articulo=" + cod_articulo + ", valor_compra=" + valor_compra + ", valor_venta="
				+ valor_venta + ", stock_final=" + stock_final + ", fecha_carga=" + fecha_carga + ", compras=" + compras
				+ ", ventas=" + ventas + "]";
	}







	/**
	 * @param idarticulo
	 * @param idtipo
	 * @param idmarca
	 * @param detalle
	 * @param cod_articulo
	 * @param valor_compra
	 * @param valor_venta
	 * @param stock_final
	 * @param fecha_carga
	 * @param compras
	 * @param ventas
	 */
	public Articulo(Integer idarticulo, Tipo idtipo, Marca idmarca,
			@Size(min = 1, max = 200, message = "Se pasado de la longuitud") @NotNull(message = "No se permite valores nulos") String detalle,
			@Size(min = 1, max = 25, message = "Se pasado de la longuitud") @NotNull(message = "No se permite valores nulos") @NotEmpty(message = "El codigo del articulo es requerida") String cod_articulo,
			@DecimalMin(value = "0.01", message = "Valor debe ser positivo...") float valor_compra,
			@DecimalMin(value = "0.01", message = "Valor debe ser positivo...") float valor_venta,
			@Min(value = 0, message = "Valor debe ser positivo...") int stock_final, LocalDate fecha_carga,
			List<Compra> compras, List<Venta> ventas) {
		super();
		this.idarticulo = idarticulo;
		this.idtipo = idtipo;
		this.idmarca = idmarca;
		this.detalle = detalle;
		this.cod_articulo = cod_articulo;
		this.valor_compra = valor_compra;
		this.valor_venta = valor_venta;
		this.stock_final = stock_final;
		this.fecha_carga = fecha_carga;
		this.compras = compras;
		this.ventas = ventas;
	}







	public Integer getIdarticulo() {
		return idarticulo;
	}







	public void setIdarticulo(Integer idarticulo) {
		this.idarticulo = idarticulo;
	}







	public Tipo getIdtipo() {
		return idtipo;
	}







	public void setIdtipo(Tipo idtipo) {
		this.idtipo = idtipo;
	}







	public Marca getIdmarca() {
		return idmarca;
	}







	public void setIdmarca(Marca idmarca) {
		this.idmarca = idmarca;
	}







	public String getDetalle() {
		return detalle;
	}







	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}







	public String getCod_articulo() {
		return cod_articulo;
	}







	public void setCod_articulo(String cod_articulo) {
		this.cod_articulo = cod_articulo;
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







	public List<Compra> getCompras() {
		return compras;
	}







	public void setCompras(List<Compra> compras) {
		this.compras = compras;
		compras.forEach(entity -> compras.set(idarticulo, entity));
	}







	public List<Venta> getVentas() {
		return ventas;
	}







	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
		ventas.forEach(entity -> ventas.set(idarticulo, entity));
	}







	public Articulo() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
}
