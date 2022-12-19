package com.wiley.project.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.project.ems.entity.Consumer;
import com.wiley.project.ems.exceptions.ResourceNotFoundException;
import com.wiley.project.ems.service.ConsumerService;

@RestController
public class ConsumerController {

	@Autowired
	private ConsumerService consumerService;

	// create rest api to save consumer
	@PostMapping("/consumer")
	public Consumer save(@RequestBody Consumer consumer) {
		return consumerService.saveConsumer(consumer);
	}

	// rest api to get All consumers
	@GetMapping("/consumer")
	public List<Consumer> getAllConsumers() {
		return consumerService.getAll();
	}

	// rest api to get consumer by id
	@GetMapping("/consumer/{id}")
	public Optional<Consumer> getById(@PathVariable Integer id) throws ResourceNotFoundException {
		return consumerService.getById(id);
	}

	// rest api to delete by id
	@DeleteMapping("/consumer/{id}")
	public void deleteById(@PathVariable Integer id) throws ResourceNotFoundException {
		consumerService.deleteById(id);
	}

	// rest api to update consumer
	@PutMapping("/consumer/{id}")
	public Consumer update(@RequestBody Consumer consumer, @PathVariable Integer id) throws ResourceNotFoundException {
		return consumerService.update(consumer, id);
	}
}
