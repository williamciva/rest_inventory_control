package br.com.rest.inventorycontrol.inventorycontrol;

class InvetoryNotFoundException extends RuntimeException {
	InvetoryNotFoundException(Long id) {
		super("Could not find product " + id);
	}
	/*
	 * o super se refere a superclasse do RuntimeException
	 */
}