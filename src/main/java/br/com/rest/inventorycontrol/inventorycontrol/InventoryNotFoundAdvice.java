package br.com.rest.inventorycontrol.inventorycontrol;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class InventoryNotFoundAdvice {
	@ResponseBody
	@ExceptionHandler(IvnetoryNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String employeeNotFoundHandler(IvnetoryNotFoundException ex) {
		return ex.getMessage();
	}
}
