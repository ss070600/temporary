package com.wiley.project.ems.serviceImplementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiley.project.ems.entity.Consumer;
import com.wiley.project.ems.exceptions.ResourceNotFoundException;
import com.wiley.project.ems.repository.ConsumerRepository;
import com.wiley.project.ems.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService {

	@Autowired
	private ConsumerRepository consumerRepository;

	@Override
	public Consumer saveConsumer(Consumer consumer) {
		return consumerRepository.save(consumer);
	}

	@Override
	public List<Consumer> getAll() {
		return (List<Consumer>) consumerRepository.findAll();
	}

	@Override
	public Optional<Consumer> getById(Integer id) throws ResourceNotFoundException {
		Optional<Consumer> c = consumerRepository.findById(id);
		if (c.isPresent())
			return c;
		else
			throw new ResourceNotFoundException("There is no consumer corresponding to id : " + id);
	}

	@Override
	public Consumer update(Consumer consumer, Integer id) throws ResourceNotFoundException {
		Consumer c = consumerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("There is no consumer corresponding to id : " + id));
		c.setFirstName(consumer.getFirstName());
		c.setLastName(consumer.getLastName());
		consumerRepository.save(c);
		return c;
	}

	@Override
	public void deleteById(Integer id) throws ResourceNotFoundException {
		if (consumerRepository.existsById(id)) {
			consumerRepository.deleteById(id);
		} else {
			throw new ResourceNotFoundException("There is no consumer corresponding to id : " + id);
		}
	}
}