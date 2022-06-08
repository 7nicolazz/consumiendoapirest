package com.idat.restapientelgy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.restapientelgy.model.Cliente;
import com.idat.restapientelgy.service.ClienteService;

@RestController
public class ClienteController {
	
	private final ClienteService clienteService;
	
	@Autowired
	public ClienteController(ClienteService clienteService) {
		super();
		this.clienteService = clienteService;
	}

	@GetMapping("/")
	public ResponseEntity<Cliente> getData() {
		return new ResponseEntity<>(clienteService.consumeAPI(), HttpStatus.OK);
			
	}
	
	/*
	@PostMapping("/api/users")
	public String postCliente(@RequestBody Cliente cliente) {
		return cliente.toString();	
	}
    */
	
	@PostMapping("api/users")
	public ResponseEntity<Cliente> save(@RequestBody(required=true)Cliente cliente){
		return new ResponseEntity<Cliente>(clienteService.guardarAPI(), HttpStatus.CREATED);
	}

}