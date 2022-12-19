package com.wiley.project.ems.service;

import java.util.List;
import java.util.Optional;

import com.wiley.project.ems.entity.Address;
import com.wiley.project.ems.exceptions.ResourceNotFoundException;

public interface AddressService {
	Address saveAddress(Address address);

	List<Address> getAll();

	Optional<Address> getById(Integer id) throws ResourceNotFoundException;

	// @Transactional
	Address updateAddress(Address address, int id) throws ResourceNotFoundException;

	void deleteAddressById(int id);
}
