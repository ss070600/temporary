package com.wiley.project.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.project.ems.entity.Connections;
import com.wiley.project.ems.exceptions.ResourceNotFoundException;
import com.wiley.project.ems.service.ConnectionsService;

@RestController
public class ConnectionsController {
	@Autowired
	private ConnectionsService connectionsService;

	// For Connections

	@PostMapping("/connections")
	public Connections save(@RequestBody Connections connections) {
		return connectionsService.saveConnection(connections);
	}

	@GetMapping("/connections")
	public List<Connections> getAllConnection() {
		return connectionsService.getAll();
	}

	@GetMapping("/connections/{id}")
	public Optional<Connections> getByIdConnection(@PathVariable Integer id) throws ResourceNotFoundException {
		return connectionsService.getById(id);
	}

	@DeleteMapping("/connections/{id}")
	public void delete(@PathVariable Integer id) throws ResourceNotFoundException {
		connectionsService.deleteById(id);
	}
}
