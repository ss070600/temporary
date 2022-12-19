package com.wiley.project.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wiley.project.ems.entity.ConnectionType;

@Repository
public interface ConnectionTypeRepository extends JpaRepository<ConnectionType, Integer> {

}
