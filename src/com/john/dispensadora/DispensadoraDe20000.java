package com.john.dispensadora;

public class DispensadoraDe20000 extends Dispensadora {

	/**
	 * Método para dispensar billetes en denominaciones de $20,000.
	 * 
	 * @param cantidad La cantidad de dinero que se desea dispensar en forma de billetes.
	 * @param mensaje  Un mensaje que se utilizará para registrar los billetes dispensados.
	 * @return Un mensaje que contiene la cantidad de billetes de $20,000 dispensados y, si es necesario,
	 *         llama al método en el siguiente dispensador (si está configurado) para manejar el resto del dinero.
	 */
	@Override
	public String dispensarBilletes(Integer cantidad, String mensaje) {
		if (cantidad >= 20000) {
			int numDeBilletes = cantidad / 20000;
			mensaje += numDeBilletes + " de $20.000 \n";

			if (cantidad % 20000 == 0) {
				return mensaje;
			}

			// Llama al siguiente dispensador si está configurado para manejar la cantidad restante.
			return this.llamarSiguienteDispensador(cantidad % 20000, mensaje);

		} else {
			
			// Si la cantidad es menor a $20,000.
			// Llama al siguiente dispensador si está configurado.
			return this.llamarSiguienteDispensador(cantidad, mensaje);
			
		}
	}
}
