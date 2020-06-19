package com.example.repair.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.repair.model.Order;

@Repository
public interface OrderRepo extends  CrudRepository<Order, Integer>{

}
