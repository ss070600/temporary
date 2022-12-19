package com.wiley.project.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wiley.project.ems.entity.Connections;
@Repository
public interface ConnectionsRepository extends JpaRepository<Connections, Integer>{

}
