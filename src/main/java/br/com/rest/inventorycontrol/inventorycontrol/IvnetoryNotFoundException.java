package br.com.rest.inventorycontrol.inventorycontrol;

class IvnetoryNotFoundException extends RuntimeException {
	IvnetoryNotFoundException(Long id) {
		super("Could not find employee " + id);
	}
	/*
	 * o super se refere a superclasse do RuntimeException
	 */
}