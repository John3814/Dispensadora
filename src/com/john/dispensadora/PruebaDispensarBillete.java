package com.john.dispensadora;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class PruebaDispensarBillete {

	public static void main(String[] args) {

		// Creación de instancias de dispensadoras de billetes.
		Dispensadora dispensadoraDe100000 = new DispensadoraDe100000();
		Dispensadora dispensadoraDe50000 = new DispensadoraDe50000();
		Dispensadora dispensadoraDe20000 = new DispensadoraDe20000();
		Dispensadora dispensadoraDe10000 = new DispensadoraDe10000();
		Dispensadora dispensadoraDe5000 = new DispensadoraDe5000();

		// Configuración de la cadena de responsabilidad.
		dispensadoraDe100000.setSiguiente(dispensadoraDe50000);
		dispensadoraDe50000.setSiguiente(dispensadoraDe20000);
		dispensadoraDe20000.setSiguiente(dispensadoraDe10000);
		dispensadoraDe10000.setSiguiente(dispensadoraDe5000);
		
		boolean bandera = true;
		
		do {
			Integer cantidad = leerValor("Ingresa la cantidad a dispensar en miles de pesos colombianos.");

			if (cantidad != null) {
				
				// Llama a la dispensadora de billetes de $100,000 para iniciar el proceso de dispensación.
				String mensaje = dispensadoraDe100000.dispensarBilletes(cantidad, "");
				JOptionPane.showMessageDialog(null, mensaje);
				
			} else {
				bandera = confirmarContinuacion(); 
			}
			
		}while(bandera);

	}

	
	 /**
     * Muestra un cuadro de diálogo para confirmar la continuación del programa.
     *
     * @return true si el usuario desea cerrar el programa, false si desea continuar.
     */
	private static boolean confirmarContinuacion() {
		Integer opcion = JOptionPane.showConfirmDialog(null, "¿Desea cerrar el programa?");
		return opcion != 0;
	}
	
	
	/**
	 * Método estático para solicitar al usuario un valor numérico entero a través de una ventana emergente de entrada.
	 * 
	 * @param mensaje Un mensaje que se mostrará al usuario en la ventana de entrada.
	 * @return El valor numérico entero ingresado por el usuario, o null si el usuario cancela la entrada.
	 */
	public static Integer leerValor(String mensaje) {
		String entrada = JOptionPane.showInputDialog(null, mensaje, "Input", JOptionPane.QUESTION_MESSAGE);

		if (entrada != null) {
			entrada = entrada.replace(".", "");
			entrada = entrada.replace(",", "");

			// Valida la entrada para asegurarse de que sea un número entero válido.
			if (validarEntrada(entrada)) {
				return Integer.valueOf(entrada);
			} else {
				JOptionPane.showMessageDialog(null, "Valor no válido", "Error", JOptionPane.INFORMATION_MESSAGE);
				return leerValor(mensaje);
			}
		}
		return null;
	}
	

	/**
	 * Método estático para validar si una cadena de entrada es un número válido (entero o decimal).
	 * 
	 * @param entrada La cadena que se va a validar.
	 * @return true si la cadena representa un número válido, false en caso contrario.
	 */
	public static boolean validarEntrada(String entrada) {
		String patronNumerico = "^[0-9]+(\\.[0-9]+)?$";
		Pattern pattern = Pattern.compile(patronNumerico);
		Matcher matcher = pattern.matcher(entrada);
		return matcher.matches();
	}

}
