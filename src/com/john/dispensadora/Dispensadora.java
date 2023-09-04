package com.john.dispensadora;

public abstract class Dispensadora {

	protected Dispensadora siguiente;

	public void setSiguiente(Dispensadora siguiente) {
		this.siguiente = siguiente;
	}
	
	
	/**
	 * Método para llamar al siguiente dispensador en la cadena de responsabilidad, si está configurado.
	 * 
	 * @param cantidad La cantidad de dinero que se desea dispensar en forma de billetes.
	 * @param mensaje  Un mensaje que se utilizará para registrar los billetes dispensados.
	 * @return Un mensaje que contiene la cantidad de billetes dispensados o un mensaje de error si no hay dispensador siguiente.
	 */
	public String llamarSiguienteDispensador(Integer cantidad, String mensaje) {
		if(this.siguiente != null) {
			return this.siguiente.dispensarBilletes(cantidad, mensaje);
		}
		return "Error, no hay dispensador siguiente configurado.";
	}

	public abstract String dispensarBilletes(Integer cantidad, String mensaje);
}