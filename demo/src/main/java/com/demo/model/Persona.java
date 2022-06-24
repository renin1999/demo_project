package com.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "persona")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idpersona;
	
	@Size(min = 10, max = 10, message = "Error digito de la cedula")
	@NotNull(message = "No se permite valores nulos")
	@NotEmpty(message = "La cedula es requerida")
	@Column(name = "cedula")
	private String cedula;
	
	
	
	@Column(name = "nombre_ape")
	@Size(min = 1, max = 150, message = "Se paso con los digitos para los nombre y apellidos")
	@NotNull(message = "No se permite valores nulos")
	@NotEmpty(message = "El nombre y apellido es requerido")
	private String nombre_ape;
	
	@Min(18)
	@Max(70)
	@NotNull(message = "No se permite valores nulos")
	@NotEmpty(message = "La edad es requerido")
	@Column(name = "edad")
	private int edad;
	
	@Size(min = 1, max=9, message = "Error se paso de la cantidad de caracteres")
	@NotNull(message = "No se permite valores nulos")
	@NotEmpty(message = "El sexo es requerido")
	@Column(name = "sexo")
	private String sexo;
	
	@Size(min = 10, max=10, message = "Error se paso de la cantidad de caracteres")
	@NotNull(message = "No se permite valores nulos")
	@NotEmpty(message = "El telefono es requerido")
	@Column(name = "telefono")
	private String telefono;
	
	
	@Column(name = "correo")
	@Email(message = "Error con el correo ingresado")
	@NotNull(message = "No se permite valores nulos")
	@NotEmpty(message = "El correo es requerido")
	private String correo;
	
	@Column(name = "fecha_carga")
	private LocalDate fecha_carga;
	
	
	public Persona(String cedula, String nombre_ape, int edad, String sexo, String telefono, String correo,
			LocalDate fecha_carga) {
		super();
		this.cedula = cedula;
		this.nombre_ape = nombre_ape;
		this.edad = edad;
		this.sexo = sexo;
		this.telefono = telefono;
		this.correo = correo;
		this.fecha_carga = fecha_carga;
	}
	public Persona() {
		super();
	}
	public Integer getIdpersona() {
		return idpersona;
	}
	public void setIdpersona(Integer idpersona) {
		this.idpersona = idpersona;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre_ape() {
		return nombre_ape;
	}
	public void setNombre_ape(String nombre_ape) {
		this.nombre_ape = nombre_ape;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
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
	public LocalDate getFecha_carga() {
		return fecha_carga;
	}
	public void setFecha_carga(LocalDate fecha_carga) {
		this.fecha_carga = fecha_carga;
	}
	
	@Override
	public String toString() {
		return "Persona [" + (idpersona != null ? "idpersona=" + idpersona + ", " : "")
				+ (cedula != null ? "cedula=" + cedula + ", " : "")
				+ (nombre_ape != null ? "nombre_ape=" + nombre_ape + ", " : "") + "edad=" + edad + ", "
				+ (sexo != null ? "sexo=" + sexo + ", " : "") + (telefono != null ? "telefono=" + telefono + ", " : "")
				+ (correo != null ? "correo=" + correo + ", " : "")
				+ (fecha_carga != null ? "fecha_carga=" + fecha_carga : "") + "]";
	}
	
	
	
}
