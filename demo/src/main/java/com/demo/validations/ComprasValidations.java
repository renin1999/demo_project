package com.demo.validations;

 import java.text.SimpleDateFormat;
 import java.util.Date; 
 import java.text.ParseException; 

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ComprasValidations {

	public Boolean validar(String cedula) { // valida cedula

		boolean cedulaCorrecta = false;

		try {

			if (cedula.length() == 10) // ConstantesApp.LongitudCedula
			{
				int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
				if (tercerDigito < 6) {
					int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
					int verificador = Integer.parseInt(cedula.substring(9, 10));
					int suma = 0;
					int digito = 0;
					for (int i = 0; i < (cedula.length() - 1); i++) {
						digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
						suma += ((digito % 10) + (digito / 10));
					}

					if ((suma % 10 == 0) && (suma % 10 == verificador)) {
						cedulaCorrecta = true;
					} else if ((10 - (suma % 10)) == verificador) {
						cedulaCorrecta = true;
					} else {
						cedulaCorrecta = false;
					}
				} else {
					cedulaCorrecta = false;
				}
			} else {
				cedulaCorrecta = false;
			}
		} catch (NumberFormatException nfe) {
			cedulaCorrecta = false;
		} catch (Exception err) {
			System.out.println("Una excepcion ocurrio en el proceso de validadcion");
			cedulaCorrecta = false;
		}

		if (!cedulaCorrecta) {
			System.out.println("La Cédula ingresada es Incorrecta");
		}
		return cedulaCorrecta;
	}

	public static boolean validateJavaDate(String strDate) { // valida formato de fecha

		if (strDate.trim().equals("")) {
			return true;
		} else {
			SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
			sdfrmt.setLenient(false);
			try {
				Date javaDate = sdfrmt.parse(strDate);
				return true;
			} catch (ParseException e) {

				return false;
			}
		}
	}

	private boolean valCorreo(String email) { // valida correo
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mather = pattern.matcher(email);
		if (mather.find() == true) {
			return true;
		} else {
			return false;
		}
	}

	private int tiene_numeros(String texto) {
		String numeros = "0123456789";
		for (int i = 0; i < texto.length(); i++) {
			if (numeros.indexOf(texto.charAt(i), 0) != -1) {
				return 1;
			}
		}
		return 0;
	}

	private int tiene_letras(String texto) {
		String letras = "abcdefghyjklmnñopqrstuvwxyz";
		texto = texto.toLowerCase();
		for (int i = 0; i < texto.length(); i++) {
			if (letras.indexOf(texto.charAt(i), 0) != -1) {
				return 1;
			}
		}
		return 0;
	}

	private int tiene_minusculas(String texto) {

		String letras = "abcdefghyjklmnñopqrstuvwxyz";
		for (int i = 0; i < texto.length(); i++) {
			if (letras.indexOf(texto.charAt(i), 0) != -1) {
				return 1;
			}
		}
		return 0;
	}

	private int tiene_mayusculas(String texto) {
		String letras_mayusculas = "ABCDEFGHYJKLMNÑOPQRSTUVWXYZ";

		for (int i = 0; i < texto.length(); i++) {
			if (letras_mayusculas.indexOf(texto.charAt(i), 0) != -1) {
				return 1;
			}
		}
		return 0;
	}

	private boolean seguridad_clave(String clave) { /// seguridad contraseña
		int seguridad = 0;
		if (clave.length() != 0) {
			if (tiene_numeros(clave) == 1 && tiene_letras(clave) == 1) {
			} else {
				seguridad += 30;
			}
			if (tiene_minusculas(clave) == 1 && tiene_mayusculas(clave) == 1) {
				seguridad += 30;
			}
			if (clave.length() >= 4 && clave.length() <= 5) {
				seguridad += 10;
			} else {
				if (clave.length() >= 6 && clave.length() <= 8) {
					seguridad += 30;
				} else {
					if (clave.length() > 8) {
						seguridad += 40;
					}
				}
			}
		}
		if (seguridad >= 50) {

			return true;
		} else {
			return false;
		}

	}

	private boolean valCodigo(String codigo) { // valida longitud de codigo
		if (codigo.length() <= 20 && codigo.length() > 0)
			return true;
		else {
			return false;
		}
	}

	private boolean valDetalle(String detalle) { // valida longitud del detalle marca
		if (detalle.length() <= 200 && detalle.length() > 5)
			return true;
		else {
			return false;
		}
	}

	private boolean validaNum(String numero) { // valida si es numero
		boolean isNumeric = numero.chars().allMatch(Character::isDigit);
		if (isNumeric == true) {
			return true;
		} else {
			return false;
		}
	}

	public boolean esDecimal(String cad) // valida si es numero decimal
	{
		try {
			Double.parseDouble(cad);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	public boolean validadFecha(String date) { // valida fecha
		boolean validoFecha = false;
		int dia, mes, anio;
		String diaD, mesM, anioA;
		diaD = date.substring(0, 2);
		mesM = date.substring(3, 5);
		anioA = date.substring(6);
		dia = Integer.parseInt(diaD);
		mes = Integer.parseInt(mesM);
		anio = Integer.parseInt(anioA);

		if (dia < 1 || dia > 31) {
			validoFecha = true;
		}

		if (mes < 1 || mes > 12) {
			validoFecha = true;
		}

		if (mes == 2 && dia == 29 && anio % 400 == 0 || (anio % 4 == 0 && anio % 100 != 0)) {
			validoFecha = true;
		}
		return validoFecha;
	}

	/*
	 * public static boolean validarFecha(String fecha) { try { SimpleDateFormat
	 * formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
	 * formatoFecha.setLenient(false); formatoFecha.parse(fecha); } catch
	 * (ParseException e) { return false; } return true; }
	 */

	public boolean validaEdad(int edad) { // valida rango de edad
		if (edad < 65 && edad > 18) {
			return true;
		} else {
			return false;
		}
	}

	private boolean valida_tel(String cadena) {//// valida tlefono si es numero entero
		if (cadena.matches("[0-9]*")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean valida_telefono(String telefono) {// valida el numero de telefono correcto
		if (valida_tel(telefono) == true) {
			if (telefono.length() == 10 && telefono.substring(0, 2) == "09") {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}


}    
    
    
    
    
    
    
    
    
    
    
    
	
	




