package com.wiley.project.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

import com.wiley.project.ems.entity.Bill;
import com.wiley.project.ems.exceptions.ResourceNotFoundException;

public interface BillService {
	Bill saveBill(Bill bill);

	List<Bill> getAll();

	Optional<Bill> getById(Integer id);

	void deleteById(Integer id);

	@Transactional
	Bill update(Bill bill, Integer id) throws ResourceNotFoundException;

	@Procedure(procedureName = "billOfAllConsumers")
	List<Bill> billsOfAllConsumers();

	@Procedure(procedureName = "billsByMonthAndYear")
	List<Bill> billsByMonthAndYear(String iyear, String imonth);

	@Procedure(procedureName = "generateBillByConnectionId")
	int generateBillByConnectionId(int inputId, int currentReading);

	@Procedure(procedureName = "billsByCityAndArea")
	List<Bill> billsByCityAndArea(String iarea, String icity);

}
