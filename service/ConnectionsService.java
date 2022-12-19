package com.wiley.project.ems.service;

import java.util.List;
import java.util.Optional;

import com.wiley.project.ems.entity.Connections;
import com.wiley.project.ems.exceptions.ResourceNotFoundException;

public interface ConnectionsService {

	Connections saveConnection(Connections connections);

	List<Connections> getAll();

	Optional<Connections> getById(Integer id) throws ResourceNotFoundException;

	void deleteById(Integer id) throws ResourceNotFoundException;
}
