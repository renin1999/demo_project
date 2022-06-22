package com.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "ventas")
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idventas;
	@Column(name= "codventas")
	private String codventas;
	
	
	@JoinColumn()
	private Articulo idarticulo;
	
	@JoinColumn()
	private Gerente idgerente;
	
	@Column(name= "codventas")
	private int cantidad;
	@Column(name= "valor")
	private double valor;
	@Column(name= "total_ventas")
	private double total_ventas;
	@Column(name= "fecha_venta")
	private LocalDate fecha_venta;
	@Column(name= "fecha_carga")
	private LocalDate fecha_carga;
}
