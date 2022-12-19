package com.wiley.project.ems.service;

import java.util.List;
import java.util.Optional;

import com.wiley.project.ems.entity.ConnectionType;
import com.wiley.project.ems.exceptions.ResourceNotFoundException;

public interface ConnectionTypeService {
	ConnectionType save(ConnectionType type);

	List<ConnectionType> getAll();

	Optional<ConnectionType> getById(Integer id) throws ResourceNotFoundException;

	ConnectionType update(ConnectionType connectionType, Integer id) throws ResourceNotFoundException;

}
