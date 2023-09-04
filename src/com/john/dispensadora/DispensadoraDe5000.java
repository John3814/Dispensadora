package com.john.dispensadora;



public class DispensadoraDe5000 extends Dispensadora {
	
	/**
	 * Método para dispensar billetes en denominaciones de $5,000 solamente si la cantidad es múltiplo de $5,000.
	 * 
	 * @param cantidad La cantidad de dinero que se desea dispensar en forma de billetes.
	 * @param mensaje  Un mensaje que se utilizará para registrar los billetes dispensados o mensajes de error.
	 * @return Un mensaje que contiene la cantidad de billetes de $5,000 dispensados si la cantidad es válida,
	 *         o un mensaje de error si la cantidad no es múltiplo de $5,000.
	 */
	@Override
	public String dispensarBilletes(Integer cantidad, String mensaje) {
		if (cantidad % 5000 == 0) {
			int numDeBilletes = cantidad / 5000;
			mensaje += numDeBilletes + " de $5.000 \n";
			
			return mensaje;
			
		} else {
			// Si la cantidad no es múltiplo de $5,000, se devuelve un mensaje de error.
			return "Error, Cantidad no permitida.";
			
		}
	}
	
	
	

}
