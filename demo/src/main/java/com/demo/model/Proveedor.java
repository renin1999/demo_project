package com.demo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "proveedor", uniqueConstraints=
@UniqueConstraint(columnNames={"codproveedor"}))
public class Proveedor {
	
	public Proveedor(Integer idproveedor,
			@Size(min = 1, max = 20, message = "Se pasado de la longuitud") @NotNull(message = "No se permite valores nulos") @NotEmpty(message = "El codigo del proveedor es requerida") String codproveedor,
			@Size(min = 1, max = 150, message = "Se paso con los digitos para los nombre y apellidos") @NotNull(message = "No se permite valores nulos") @NotEmpty(message = "El nombre y apellido es requerido") String nombre_ape,
			@Size(min = 10, max = 10, message = "Error se paso de la cantidad de caracteres") @NotNull(message = "No se permite valores nulos") @NotEmpty(message = "El telefono es requerido") String telefono,
			@Email(message = "Error con el correo ingresado") @NotNull(message = "No se permite valores nulos") @NotEmpty(message = "El correo es requerido") String correo,
			@Size(min = 1, max = 200, message = "Se pasado de la longuitud") @NotNull(message = "No se permite valores nulos") @NotEmpty(message = "La direccion es requerida") String direccion,
			List<Compra> compras, LocalDate fecha_carga) {
		super();
		this.idproveedor = idproveedor;
		this.codproveedor = codproveedor;
		this.nombre_ape = nombre_ape;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
		this.compras = compras;
		this.fecha_carga = fecha_carga;
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer idproveedor;
	
	
	@Column(name = "codproveedor")
	@Size(min = 1, max = 20, message =  "Se pasado de la longuitud")
	@NotNull(message = "No se permite valores nulos")
	@NotEmpty(message = "El codigo del proveedor es requerida")
	private String codproveedor;
	
	@Column(name = "nombre_ape")
	@Size(min = 1, max = 150, message = "Se paso con los digitos para los nombre y apellidos")
	@NotNull(message = "No se permite valores nulos")
	@NotEmpty(message = "El nombre y apellido es requerido")
	private String nombre_ape;
	
	
	@Column(name = "telefono")
	@Size(min = 10, max=10, message = "Error se paso de la cantidad de caracteres")
	@NotNull(message = "No se permite valores nulos")
	@NotEmpty(message = "El telefono es requerido")
	private String telefono;
	
	@Email(message = "Error con el correo ingresado")
	@NotNull(message = "No se permite valores nulos")
	@NotEmpty(message = "El correo es requerido")
	@Column(name = "correo")
	private String correo;
	
	
	@Column(name = "direccion")
	@Size(min = 1, max = 200, message =  "Se pasado de la longuitud")
	@NotNull(message = "No se permite valores nulos")
	@NotEmpty(message = "La direccion es requerida")
	private String direccion;
	
	@OneToMany(mappedBy = "idproveedor", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Compra> compras;
	
	@Column(name = "fecha_carga")
	private LocalDate fecha_carga;

	public Integer getIdproveedor() {
		return idproveedor;
	}

	public void setIdproveedor(Integer idproveedor) {
		this.idproveedor = idproveedor;
	}

	public String getCodproveedor() {
		return codproveedor;
	}

	public void setCodproveedor(String codproveedor) {
		this.codproveedor = codproveedor;
	}

	public String getNombre_ape() {
		return nombre_ape;
	}

	public void setNombre_ape(String nombre_ape) {
		this.nombre_ape = nombre_ape;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public LocalDate getFecha_carga() {
		return fecha_carga;
	}

	public void setFecha_carga(LocalDate fecha_carga) {
		this.fecha_carga = fecha_carga;
	}

	@Override
	public String toString() {
		return "Proveedor [" + (idproveedor != null ? "idproveedor=" + idproveedor + ", " : "")
				+ (codproveedor != null ? "codproveedor=" + codproveedor + ", " : "")
				+ (nombre_ape != null ? "nombre_ape=" + nombre_ape + ", " : "")
				+ (telefono != null ? "telefono=" + telefono + ", " : "")
				+ (correo != null ? "correo=" + correo + ", " : "")
				+ (direccion != null ? "direccion=" + direccion + ", " : "")
				+ (compras != null ? "compras=" + compras + ", " : "")
				+ (fecha_carga != null ? "fecha_carga=" + fecha_carga : "") + "]";
	}

	public Proveedor(
			@Size(min = 1, max = 20, message = "Se pasado de la longuitud") @NotNull(message = "No se permite valores nulos") @NotEmpty(message = "El codigo del proveedor es requerida") String codproveedor,
			@Size(min = 1, max = 150, message = "Se paso con los digitos para los nombre y apellidos") @NotNull(message = "No se permite valores nulos") @NotEmpty(message = "El nombre y apellido es requerido") String nombre_ape,
			@Size(min = 10, max = 10, message = "Error se paso de la cantidad de caracteres") @NotNull(message = "No se permite valores nulos") @NotEmpty(message = "El telefono es requerido") String telefono,
			@Email(message = "Error con el correo ingresado") @NotNull(message = "No se permite valores nulos") @NotEmpty(message = "El correo es requerido") String correo,
			@Size(min = 1, max = 200, message = "Se pasado de la longuitud") @NotNull(message = "No se permite valores nulos") @NotEmpty(message = "La direccion es requerida") String direccion,
			List<Compra> compras, LocalDate fecha_carga) {
		super();
		this.codproveedor = codproveedor;
		this.nombre_ape = nombre_ape;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
		this.compras = compras;
		this.fecha_carga = fecha_carga;
	}

	public Proveedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
