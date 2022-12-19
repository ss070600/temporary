package com.wiley.project.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.project.ems.entity.Address;
import com.wiley.project.ems.exceptions.ResourceNotFoundException;
import com.wiley.project.ems.service.AddressService;

@RestController
public class AddressController {
	@Autowired
	private AddressService addressService;

	@PostMapping("/address")
	public Address save(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}

	@GetMapping("/address")
	public List<Address> getAllAddress() {
		return addressService.getAll();
	}

	@DeleteMapping("/address/{id}")
	public void deleteAddressById(@PathVariable("id") int id) {
		addressService.deleteAddressById(id);
	}

	@PutMapping("/address/{id}")
	public Address updateAddress(@RequestBody Address address, @PathVariable("id") int id)
			throws ResourceNotFoundException {
		return addressService.updateAddress(address, id);
	}
}
