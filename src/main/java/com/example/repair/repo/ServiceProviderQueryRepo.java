package com.example.repair.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.repair.model.SpQuery;

public interface ServiceProviderQueryRepo extends CrudRepository<SpQuery, Integer>{
	
	@Query("select s from SpQuery s where s.isSolved = false")
	List<SpQuery> findQuery();
	
	SpQuery findByQueryId(int queryId);

}