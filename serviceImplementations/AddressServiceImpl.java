package com.wiley.project.ems.serviceImplementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiley.project.ems.entity.Address;
import com.wiley.project.ems.entity.Consumer;
import com.wiley.project.ems.exceptions.ResourceNotFoundException;
import com.wiley.project.ems.repository.AddressRepository;
import com.wiley.project.ems.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public List<Address> getAll() {
		return (List<Address>) addressRepository.findAll();
	}

	@Override
	public void deleteAddressById(int id) {
		addressRepository.deleteById(id);
	}

	@Override
	public Address updateAddress(Address address, int id) throws ResourceNotFoundException {
		Address a = addressRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("There is no address corresponding to id : " + id));
		a.setArea(address.getArea());
		a.setCity(address.getCity());
		addressRepository.save(a);
		return a;
	}

	@Override
	public Optional<Address> getById(Integer id) throws ResourceNotFoundException {
		Optional<Address> c = addressRepository.findById(id);
		if (c.isPresent())
			return c;
		else
			throw new ResourceNotFoundException("There is no address corresponding to id : " + id);
	}

}
