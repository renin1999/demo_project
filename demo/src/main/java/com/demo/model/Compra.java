package com.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "compras")
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcompra;
	private String codcompra;
	private int idarticulo; 
	private int idproveedor;
	private int cantidad;
	private double valor;
	private double total_compra;
	private LocalDate fecha_compra;
	private LocalDate fecha_carga;
	
}
