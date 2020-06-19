package com.example.repair.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.repair.model.Visit;

@Repository
public interface VisitRepo extends CrudRepository<Visit, Integer> {

}
