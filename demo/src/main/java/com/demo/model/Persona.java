package com.demo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
@Table(name = "persona")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idpersona;
	
	
	
	@Column(name = "cedula")
	@NotNull(message = "No se permite valores nulos")
	private String cedula;
	
	
	
	@Column(name = "nombre_ape")
	@NotNull(message = "No se permite valores nulos")
	@NotEmpty(message = "El nombre y apellido es requerido")
	private String nombre_ape;
	
	
	
	@Column(name = "edad")
	@NotNull(message = "No se permite valores nulos")
	@Min(18)
	@Max(70)
	private int edad;
	
	
	@NotNull(message = "No se permite valores nulos")
	@Column(name = "sexo")
	private String sexo;
	
	@NotNull(message = "No se permite valores nulos")
	@Column(name = "telefono")
	private String telefono;
	
	
	@Column(name = "correo")
	@Email(message = "Error con el correo ingresado")
	@NotNull(message = "No se permite valores nulos")
	private String correo;
	
	@Column(name = "fecha_carga")
	private LocalDate fecha_carga;
	
	@OneToMany(mappedBy = "idpersona", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Usuario> usuarios;

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

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
		
	}

	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Persona(Integer idpersona, @NotNull(message = "No se permite valores nulos") String cedula,
			@NotNull(message = "No se permite valores nulos") @NotEmpty(message = "El nombre y apellido es requerido") String nombre_ape,
			@NotNull(message = "No se permite valores nulos") @Min(18) @Max(70) int edad,
			@NotNull(message = "No se permite valores nulos") String sexo,
			@NotNull(message = "No se permite valores nulos") String telefono,
			@Email(message = "Error con el correo ingresado") @NotNull(message = "No se permite valores nulos") String correo,
			LocalDate fecha_carga, List<Usuario> usuarios) {
		super();
		this.idpersona = idpersona;
		this.cedula = cedula;
		this.nombre_ape = nombre_ape;
		this.edad = edad;
		this.sexo = sexo;
		this.telefono = telefono;
		this.correo = correo;
		this.fecha_carga = fecha_carga;
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Persona [" + (idpersona != null ? "idpersona=" + idpersona + ", " : "")
				+ (cedula != null ? "cedula=" + cedula + ", " : "")
				+ (nombre_ape != null ? "nombre_ape=" + nombre_ape + ", " : "") + "edad=" + edad + ", "
				+ (sexo != null ? "sexo=" + sexo + ", " : "") + (telefono != null ? "telefono=" + telefono + ", " : "")
				+ (correo != null ? "correo=" + correo + ", " : "")
				+ (fecha_carga != null ? "fecha_carga=" + fecha_carga + ", " : "")
				+ (usuarios != null ? "usuarios=" + usuarios : "") + "]";
	}

	public Persona(@NotNull(message = "No se permite valores nulos") String cedula,
			@NotNull(message = "No se permite valores nulos") @NotEmpty(message = "El nombre y apellido es requerido") String nombre_ape,
			@NotNull(message = "No se permite valores nulos") @Min(18) @Max(70) int edad,
			@NotNull(message = "No se permite valores nulos") String sexo,
			@NotNull(message = "No se permite valores nulos") String telefono,
			@Email(message = "Error con el correo ingresado") @NotNull(message = "No se permite valores nulos") String correo,
			LocalDate fecha_carga, List<Usuario> usuarios) {
		super();
		this.cedula = cedula;
		this.nombre_ape = nombre_ape;
		this.edad = edad;
		this.sexo = sexo;
		this.telefono = telefono;
		this.correo = correo;
		this.fecha_carga = fecha_carga;
		this.usuarios = usuarios;
	}
	
	
	
	
	
}
