package com.idat.restapientelgy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.idat.restapientelgy.model.Cliente;

@Service
public class ClienteService {
	
	private final RestTemplate restTemplate;

	@Autowired
	public ClienteService(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}
	
	
	public Cliente consumeAPI() {
		return restTemplate.getForObject("https://reqres.in/api/users",Cliente.class);
	
	}
	
	
	public Cliente guardarAPI() {
	return	restTemplate.postForObject("https://reqres.in/api/users", toString(), Cliente.class);
	}

}
