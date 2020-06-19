package com.example.repair.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.repair.model.Technician;

public interface TechnicianRepo extends CrudRepository<Technician, Integer>{

	Technician findByTechnicianId(int id);


}
