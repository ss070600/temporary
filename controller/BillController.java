package com.wiley.project.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.project.ems.entity.Bill;
import com.wiley.project.ems.service.BillService;

@RestController
public class BillController {
	@Autowired
	private BillService billService;

	@PostMapping("/bill")
	public Bill save(@RequestBody Bill bill) {
		return billService.saveBill(bill);
	}

	@GetMapping("/bill")
	public List<Bill> getAllBill() {
		return billService.getAll();
	}

	@GetMapping("/bill/{id}")
	public Optional<Bill> getBillById(@PathVariable("id") int id) {
		return billService.getById(id);
	}

	@DeleteMapping("/bill/{id}")
	public void deleteBillById(@PathVariable int id) {
		billService.deleteById(id);
	}
}
