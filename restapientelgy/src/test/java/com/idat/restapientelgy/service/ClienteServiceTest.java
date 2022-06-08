package com.idat.restapientelgy.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.RETURNS_MOCKS;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.idat.restapientelgy.controller.ClienteController;
import com.idat.restapientelgy.model.Cliente;

public class ClienteServiceTest {

	
	@Mock
	private ClienteController clienteController;
	
	@InjectMocks
	private ClienteService clienteService;
	
	private Cliente cliente;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		
		cliente = new Cliente();
		cliente.setId(new Integer(50));
		cliente.setEmail("nico@gmail.com");
		cliente.setFirstName("Nicolas");
		cliente.setLastName("Bravo");
		cliente.setAvatar("https://reqres.in/img/faces/1-image.jpg");
		
	}
	
	
	@Test
	void consumeAPI() {
		when(clienteController.getData()).thenReturn((ResponseEntity<Cliente>) Arrays.asList(cliente));
		assertNotNull(clienteService.consumeAPI());
		
	}
	
	@Test
	void guardarAPI() {
		when(clienteController.save(any(Cliente.class))).thenReturn((ResponseEntity<Cliente>) Arrays.asList(cliente));
		assertNotNull(clienteService.guardarAPI());
		
		
	}

}
