package com.wiley.project.ems.service;

import java.util.List;
import java.util.Optional;

import com.wiley.project.ems.entity.Consumer;
import com.wiley.project.ems.exceptions.ResourceNotFoundException;

public interface ConsumerService {
	Consumer saveConsumer(Consumer consumer);

	List<Consumer> getAll();

	Optional<Consumer> getById(Integer id) throws ResourceNotFoundException;

	Consumer update(Consumer consumer, Integer id) throws ResourceNotFoundException;

	void deleteById(Integer id) throws ResourceNotFoundException;
}
