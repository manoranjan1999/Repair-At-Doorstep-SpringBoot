package com.example.repair.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.repair.model.ServiceRequest;
import com.example.repair.model.Status;

@Repository
@Transactional
public interface ServiceRequestRepo extends CrudRepository<ServiceRequest, Integer> {

	List findByUserId(int userId);

	ServiceRequest findByServiceRequestId(int srId);

	List findByStatus(Status open);

	/*
	 * This query for get all service request details for a particular service
	 * provider
	 */
	@Query(value = "select s.service_request_id,s.company_name,s.product_name,s.description,s.address_id,"
			+ "s.model_number,s.product_type,s.status,a.complete_address,a.current_location,"
			+ "a.pin_code,s.user_id,u.first_name,u.last_name,u.email_id,u.phone_number"
			+ " from service_request s INNER JOIN address a ON s.address_id=a.address_id INNER JOIN user u ON u.user_id=s.user_id and s.service_provider_id=?1", nativeQuery = true)
	List findByServiceProviderId(int serviceProviderId);

	/*
	 * This query is for get all open request with address
	 */
	@Query(value = "select s.service_request_id,s.company_name,s.product_name,s.description,s.address_id,"
			+ "s.model_number,s.product_type,s.status,a.complete_address,a.current_location,"
			+ "a.pin_code,s.user_id,s.date_time "
			+ "from service_request s INNER JOIN address a ON s.address_id=a.address_id and (status=0)", nativeQuery = true)
	List getOpenRequestWithAddress();

	/*
	 * This query is for get visiting details of a request for a particular user
	 */
	@Query(value = "select s.service_request_id,s.company_name,s.product_name,s.description,"
			+ "s.model_number,s.product_type,s.status,v.visiting_message,v.date_time from service_request s INNER JOIN visiting_details v ON s.service_request_id=v.service_request_id and user_id=?1 ORDER BY s.service_request_id DESC", nativeQuery = true)
	List requestDetails(int id);

	/*
	 * This query is for count number of request type means how many electronics,
	 * mechanics and so on
	 */
	@Query(value = " select sum(case when product_type = 'Electronics' then 1 else 0 end) as prod_1_count,   sum(case when product_type = 'Furniture' then 1 else 0 end) as prod_2_count,   sum(case when product_type = 'Plumbing' then 1 else 0 end) as prod_3_count,   sum(case when product_type = 'Mechanic' then 1 else 0 end) as prod_4_count from service_request;\n"
			+ "", nativeQuery = true)
	List countRequestType();

	/*
	 * This query is for count number of request type means how many electronics,
	 * mechanics and so on for a particular user
	 */
	@Query(value = " select sum(case when product_type = 'Electronics' then 1 else 0 end) as prod_1_count,  "
			+ " sum(case when product_type = 'Furniture' then 1 else 0 end) as prod_2_count, "
			+ "  sum(case when product_type = 'Plumbing' then 1 else 0 end) as prod_3_count, "
			+ "  sum(case when product_type = 'Mechanic' then 1 else 0 end) as prod_4_count"
			+ " from service_request where user_id=?1", nativeQuery = true)
	List countRequestTypeOfUser(int id);

	/*
	 * This query is to get invoice details for a particular service request,
	 * retrieving details using inner join
	 */
	@Query(value = "select s.service_request_id,s.company_name,s.product_name,"
			+ "a.complete_address,a.current_location,"
			+ "a.pin_code,s.user_id,u.first_name,u.last_name,u.email_id,u.phone_number,p.parts_name,p.price,p.service_charge,p.qty,p.parts_description"
			+ " from service_request s INNER JOIN address a ON s.address_id=a.address_id INNER JOIN user u ON u.user_id=s.user_id INNER JOIN order_details o ON o.service_request_id=s.service_request_id INNER JOIN parts p ON p.order_id=o.order_id and s.service_request_id=?1", nativeQuery = true)
	List getInvoiceDetails(int serviceRequestId);

	/*
	 * This query for find the service request details which has service status is
	 * completed but payment is not completed
	 */
	@Query(value = "select *from service_request,payment where service_request.payment_id=payment.payment_id and user_id=?1 and status=2 and payment.payment_status=1", nativeQuery = true)
	List<ServiceRequest> findByUserIdWithPaymentStaus(int id);

	/*
	 * This query is for get all the details of user
	 */
	@Query(value = "select s.service_request_id,s.company_name,s.product_name,s.description,s.address_id,"
			+ "s.model_number,s.product_type,s.status,a.complete_address,a.current_location,"
			+ "a.pin_code,s.user_id,s.date_time  "
			+ "from service_request s INNER JOIN address a On s.address_id=a.address_id and s.user_id=?1", nativeQuery = true)
	List getDetails(int userId);

	/*
	 * This query is for update the assign technician in service request table for a
	 * particular request
	 */
	@Modifying
	@Query(value = "update service_request set technician_id=?2 where service_request_id=?1", nativeQuery = true)
	void updateTechnician(int serviceRequestId, int technicianId);

	@Query(value = "select *from service_request where service_request.service_provider_id=?1", nativeQuery = true)
	List<ServiceRequest> findByServiceProviderId1(int spid);

}
