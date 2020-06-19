package com.example.repair.service;

import java.util.List;
import java.util.Optional;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.stereotype.Service;

import com.example.repair.dto.AssignTechnicianDTO;
import com.example.repair.dto.ChangePasswordDTO;
import com.example.repair.dto.OrderDTO;
import com.example.repair.dto.PaymentStatusDTO;
import com.example.repair.dto.ServiceProviderDTO;
import com.example.repair.dto.ServiceRequestDTO;
import com.example.repair.dto.TechnicianAddingDto;
import com.example.repair.dto.UserDTO;
import com.example.repair.dto.VisitDTO;
import com.example.repair.model.Order;
import com.example.repair.model.ServiceProvider;
import com.example.repair.model.ServiceRequest;
import com.example.repair.model.SpQuery;
import com.example.repair.model.Technician;
import com.example.repair.model.User;
import com.example.repair.model.Visit;
@Service
public interface RepairService{
	
	public Optional<User> login(UserDTO userDTO);
	public String admin();
	public Optional<ServiceProvider> serviceProviderLogin(ServiceProviderDTO serviceProviderDTO);
	public User create(UserDTO userDTO);
	public ServiceProvider registerRequest(ServiceProviderDTO serviceProviderDTO);
	public String addServiceRequest( ServiceRequestDTO serviceRequestDTO);
	public List findAddress(String userId);
	public List<ServiceRequest> getServiceRequest(String userId);
	public List serviceProvided(String serviceProviderId);
	public List openRequest();
	public ServiceRequest update(ServiceRequestDTO serviceRequestDTO);
	public Order parts(OrderDTO[] orderDTO);
	public Visit visiting(VisitDTO visitDTO) ;
	public Visit reVisiti(VisitDTO visitDTO);
	public String sendPassword(ServiceProviderDTO serviceProviderDTO);
	public String genrate();
	public List<ServiceProvider> varifyServiceProviderDetails();
	public List getReviewOfServiceRequest(String userId) ;
	public List countType();
	public List countTypeOfRequestForUser(String userId);
	public ServiceProvider getSpProfile(int spId);
	public void saveTechieData(TechnicianAddingDto technicianDtoObj);
	public ServiceProvider getTechnicianData(int spId);
	public List getInvoice(String serviceRequestId);
	public List<ServiceRequest> getPaymentStatus(String userId);
	public String changePassword(ChangePasswordDTO changePasswordDTO) throws NotFound;
	public List<ServiceProvider> getAllServiceProviderDetails();
	public List<User> getAllUserDetails();
	public List<ServiceRequest> getAllServiceRequestDetails();
	public String saveFeedback(int srId, int starValue, String feedbackText) ;
	public List<ServiceRequest> getAllFeedback(int spId);
	public void savePaymentStatus(PaymentStatusDTO payment);
	public String addProduct(int spId, String productName);
	public String getUserName(int userId);
	public String[] getSpDetails(int spId);
	public String saveQuery(SpQuery query);
	public List<SpQuery> getAllQuery();
	public String sendMail(int queryId, String adminMailText);
	public List getPortfolioDetails(int userId);
	public String addTechnican(AssignTechnicianDTO assignTechnicianDTO);
	public Technician getTechnicianDetails(String technicianId);
	
	

}
