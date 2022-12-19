package com.wiley.project.ems.serviceImplementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiley.project.ems.entity.Connections;
import com.wiley.project.ems.exceptions.ResourceNotFoundException;
import com.wiley.project.ems.repository.ConnectionsRepository;
import com.wiley.project.ems.service.ConnectionsService;

@Service
public class ConnectionsServiceImpl implements ConnectionsService {
	@Autowired
	private ConnectionsRepository connectionRepository;

	@Override
	public Connections saveConnection(Connections connections) {
		return connectionRepository.save(connections);
	}

	@Override
	public List<Connections> getAll() {
		return (List<Connections>) connectionRepository.findAll();
	}

	@Override
	public Optional<Connections> getById(Integer id) throws ResourceNotFoundException {
		Optional<Connections> c = connectionRepository.findById(id);
		if (c.isPresent())
			return c;
		else
			throw new ResourceNotFoundException("There is no connection corresponding to id : " + id);
	}

	@Override
	public void deleteById(Integer id) throws ResourceNotFoundException {
		if (connectionRepository.existsById(id)) {
			connectionRepository.deleteById(id);
		} else {
			throw new ResourceNotFoundException("There is no connection corresponding to id : " + id);
		}
	}
}
