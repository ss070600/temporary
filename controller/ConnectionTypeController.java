package com.wiley.project.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.project.ems.entity.ConnectionType;
import com.wiley.project.ems.exceptions.ResourceNotFoundException;
import com.wiley.project.ems.service.ConnectionTypeService;

@RestController
public class ConnectionTypeController {
	@Autowired
	private ConnectionTypeService connectionTypeService;
	// for connection type

	@PostMapping("/connectionType")
	public ConnectionType save(@RequestBody ConnectionType connectionType) {
		return connectionTypeService.save(connectionType);
	}

	@GetMapping("/connectionType")
	public List<ConnectionType> getAllConnectionType() {
		return connectionTypeService.getAll();
	}

	@GetMapping("/connectionType/{id}")
	public Optional<ConnectionType> getByIdConnectionType(@PathVariable Integer id) throws ResourceNotFoundException {
		return connectionTypeService.getById(id);
	}

	@PutMapping("/connectionType/{id}")
	public ConnectionType update(@RequestBody ConnectionType connectionType, @PathVariable Integer id)
			throws ResourceNotFoundException {
		return connectionTypeService.update(connectionType, id);
	}
}
