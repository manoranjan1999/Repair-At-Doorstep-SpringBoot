package com.example.repair.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.repair.model.ServiceProvider;

@Transactional
public interface ServiceProviderRepo extends CrudRepository<ServiceProvider, Integer>{

	List<ServiceProvider> findByStatus(boolean status);
	@Modifying
	@Query(value="update service_provider set password=?2,status=true where service_provider_id=?1 ",nativeQuery = true)
	public void update(int id,String password);
	Optional<ServiceProvider> findByEmailId(String emailId);
	ServiceProvider findByServiceProviderId(int spId);
	
	@Query("select serviceProviderName, emailId from ServiceProvider where serviceProviderId=?1")
	String[] getSPDetails(int spId);

}
