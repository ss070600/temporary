package com.wiley.project.ems.serviceImplementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiley.project.ems.entity.ConnectionType;
import com.wiley.project.ems.exceptions.ResourceNotFoundException;
import com.wiley.project.ems.service.ConnectionTypeService;
import com.wiley.project.ems.repository.ConnectionTypeRepository;

@Service
public class ConnectionTypeServiceImpl implements ConnectionTypeService {

	@Autowired
	private ConnectionTypeRepository connectionTypeRepository;

	@Override
	public ConnectionType save(ConnectionType type) {
		return connectionTypeRepository.save(type);
	}

	@Override
	public List<ConnectionType> getAll() {
		return (List<ConnectionType>) connectionTypeRepository.findAll();
	}

	@Override
	public Optional<ConnectionType> getById(Integer id) throws ResourceNotFoundException {
		Optional<ConnectionType> c = connectionTypeRepository.findById(id);
		if (c.isPresent())
			return c;
		else
			throw new ResourceNotFoundException("There is no connection type corresponding to id : " + id);
	}

	@Override
	public ConnectionType update(ConnectionType connectionType, Integer id) throws ResourceNotFoundException {
		ConnectionType c = connectionTypeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("There is no connection type corresponding to id : " + id));
		c.setFixedCharge(connectionType.getFixedCharge());
		c.setPerUnitCharge(connectionType.getPerUnitCharge());
		return c;
	}

}
