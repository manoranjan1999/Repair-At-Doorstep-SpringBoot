package com.example.repair.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
import com.example.repair.service.PaymentService;
import com.example.repair.service.RepairService;
import com.stripe.model.Charge;

@RestController
@CrossOrigin
public class RepairController {

	@Autowired
	@Qualifier("repairServiceImpl")
	RepairService repairService;

	@Autowired
	PaymentService paymentService;

	/**
	 * This url is for customer login
	 *
	 * @param userDTO
	 * @return user details
	 */
	@PostMapping("/signIn")
	public Optional<User> home(@RequestBody UserDTO userDTO) {
		return repairService.login(userDTO);
	}

	/**
	 * This url is for service provider login
	 *
	 * @param serviceProviderDTO
	 * @return serviceProvider details
	 */
	@PostMapping("/serviceProviderLogin")
	public Optional<ServiceProvider> login(@RequestBody ServiceProviderDTO serviceProviderDTO) {
		return repairService.serviceProviderLogin(serviceProviderDTO);
	}

	/**
	 * This url is for registration of user
	 *
	 * @param userDTO
	 * @return user details
	 */
	@PostMapping("/signUp")
	public User create(@RequestBody @Valid UserDTO userDTO) {
		return repairService.create(userDTO);
	}

	/**
	 * This url is for registration request for service provider
	 *
	 * @param serviceProviderDTO
	 * @return service provider details
	 */
	@PostMapping("/serviceProviderRequest")
	public ServiceProvider request(@RequestBody ServiceProviderDTO serviceProviderDTO) {
		return repairService.registerRequest(serviceProviderDTO);

	}

	/**
	 * This url is for add new service request
	 *
	 * @param serviceRequestDTO
	 * @return String
	 */
	@PostMapping("/addProblem")
	public String addProblem(@RequestBody ServiceRequestDTO serviceRequestDTO) {
		return repairService.addServiceRequest(serviceRequestDTO);
	}

	/**
	 * This url is for get address for a particular user
	 *
	 * @param userId
	 * @return List of address
	 */
	@GetMapping("/getAddress")
	public List getAddress(String userId) {
		return repairService.findAddress(userId);
	}

	/**
	 * This url is for get all service request for a particular user
	 *
	 * @param userId
	 * @return List of service request
	 */
	@GetMapping("/getProblem")
	public List<ServiceRequest> getProblem(String userId) {
		return repairService.getServiceRequest(userId);
	}

	/**
	 * This url is for get all service request for a particular service provider
	 *
	 * @param serviceProviderId
	 * @return List of service request
	 */
	@GetMapping("/getServices")
	public List getServices(String serviceProviderId) {
		return repairService.serviceProvided(serviceProviderId);
	}

	/**
	 * This url is for get all open service request
	 *
	 * @param nothing
	 * @return List of open request
	 */
	@GetMapping("/openRequest")
	public List getOpenRequest() {
		return repairService.openRequest();
	}

	/**
	 * This url is for assign service provider for a particular service request
	 *
	 * @param serviceRequestDTO
	 * @return service request
	 */
	@PostMapping("/assignServiceProvider")
	public ServiceRequest update(@RequestBody ServiceRequestDTO serviceRequestDTO) {
		return repairService.update(serviceRequestDTO);
	}

	/**
	 * This url is for save all the details of a particular service request like
	 * parts details and all
	 *
	 * @param orderDTO
	 * @return order details
	 */
	@PostMapping("/orderDetails")
	public Order orderDetails(@RequestBody OrderDTO[] orderDTO) {
		return repairService.parts(orderDTO);

	}

	/**
	 * This url is for save the visiting message and status
	 *
	 * @param visitDTO
	 * @return Visit details
	 */
	@PostMapping("/visitingDetails")
	public Visit visitingDetails(@RequestBody VisitDTO visitDTO) {
		return repairService.visiting(visitDTO);
	}

	/**
	 *
	 * This url is for save re-visit message
	 * 
	 * @param visitDTO
	 * @return Visit details
	 */
	@PostMapping("/reVisitingDetails")
	public Visit reVisitingDetails(@RequestBody VisitDTO visitDTO) {
		return repairService.reVisiti(visitDTO);
	}

	/**
	 * This url is for send password to the particular service provider using mail
	 *
	 * @param serviceProviderDTO
	 * @return String
	 */
	@PostMapping("/sendPassword")
	public String sendMail(@RequestBody ServiceProviderDTO serviceProviderDTO) {
		return repairService.sendPassword(serviceProviderDTO);

	}

	/**
	 * This is url get all the service provide request which is not verified
	 *
	 * @param nothing
	 * @return List of service provider
	 */
	@GetMapping("/varify")
	public List<ServiceProvider> varifyServiceProvider() {
		return repairService.varifyServiceProviderDetails();
	}

	/**
	 * This url is for get all details of visiting message for a particular user
	 *
	 * @param userId
	 * @return List of visit details
	 */
	@GetMapping("/review")
	public List review(String userId) {
		return repairService.getReviewOfServiceRequest(userId);
	}

	/*
	 *
	*/

	/**
	 * This url is for get how many request is register of which type till now
	 *
	 * @param nothing
	 * @return List of number of request type
	 */
	@GetMapping("/countType")
	public List countRequestType() {
		return repairService.countType();
	}

	/**
	 * This url is for get how many request is register of which type till now for a
	 * particular user
	 *
	 * @param userId
	 * @return List of number of request type
	 */
	@GetMapping("/countTypeOfAUser")
	public List countRequestTypeOfUser(String userId) {
		return repairService.countTypeOfRequestForUser(userId);
	}

	/**
	 * This url is for service provider profile
	 *
	 * @param spId
	 * @return service provider details
	 */
	@PostMapping("/displayProfile")
	public ServiceProvider displayProfile(@RequestBody int spId) {
		return repairService.getSpProfile(spId);
	}

	/**
	 * This url is for add technician for a particular service provider
	 *
	 * @param technicianDtoObj
	 * @return nothing
	 */
	@PostMapping("/saveTechnician")
	public void saveTechnicianData(@RequestBody TechnicianAddingDto technicianDtoObj) {
		repairService.saveTechieData(technicianDtoObj);

	}

	/**
	 * This url fetch all the technician details for a particular service provider
	 *
	 * @param id
	 * @return service provider details
	 */
	@PostMapping("/displayTechnician")
	public ServiceProvider displayTechnician(@RequestBody int id) {
		return repairService.getTechnicianData(id);
	}

	/**
	 * This url get all the details for invoice
	 *
	 * @param serviceRequestId
	 * @return List of invoice details
	 */
	@GetMapping("/getInvoice")
	public List getInvoice(String serviceRequestId) {
		return repairService.getInvoice(serviceRequestId);
	}

	/**
	 * This url is for save all the details about charge
	 *
	 * @param grandTotal
	 * @param request
	 * @return Charge
	 * @throws Exception
	 */
	@PostMapping("/charge")
	public Charge chargeCard(@RequestBody int grandTotal, HttpServletRequest request) throws Exception {
		String token = request.getHeader("token");
		int amount = grandTotal;
		return this.paymentService.chargeCreditCard(token, amount);
	}

	/**
	 * This url is for get status of payment for a particular user
	 *
	 * @param userId
	 * @return List Service request details
	 */
	@GetMapping("/getPaymentStatus")
	public List<ServiceRequest> getPaymentStatus(String userId) {
		return repairService.getPaymentStatus(userId);
	}

	/**
	 * This url is for Change the password for all
	 *
	 * @param changePasswordDTO
	 * @return String
	 * @throws NotFound
	 */
	@PostMapping("/changePassword")
	public String change(@RequestBody ChangePasswordDTO changePasswordDTO) throws NotFound {
		return repairService.changePassword(changePasswordDTO);
	}

	/**
	 * This url is for get all service provider
	 *
	 * @param nothing
	 * @return List of service provider
	 */
	@GetMapping("/allServiceProvder")
	public List<ServiceProvider> getAllServiceProvider() {
		return repairService.getAllServiceProviderDetails();
	}

	/**
	 * This url is for get all user
	 *
	 * @param nothing
	 * @return List of user
	 */
	@GetMapping("/allCustomer")
	public List<User> getAllCustomer() {
		return repairService.getAllUserDetails();
	}

	/**
	 * This url is for get all service request
	 *
	 * @param nothing
	 * @return List of service request
	 */
	@GetMapping("/allServiceRequest")
	public List<ServiceRequest> getAllServiceRequest() {
		return repairService.getAllServiceRequestDetails();
	}

	/**
	 * This url is for add prduct name
	 *
	 * @param spId
	 * @param request
	 * @return String
	 */
	@PostMapping("/addProductName")
	public String addProduct(@RequestBody int spId, HttpServletRequest request) {
		String productName = request.getHeader("productName");
		return repairService.addProduct(spId, productName);

	}

	/**
	 * This url is for save feedback
	 *
	 * @param srId
	 * @param request
	 * @return String
	 */
	@PostMapping("/savefeedback")
	public String saveFeedback(@RequestBody int srId, HttpServletRequest request) {
		int starValue = Integer.parseInt(request.getHeader("starValue"));
		String feedbackText = request.getHeader("feedbackText");
		return repairService.saveFeedback(srId, starValue, feedbackText);

	}

	/**
	 * This url is for get all feedback
	 *
	 * @param spId
	 * @return List of service request
	 */
	@PostMapping("/getallfeedback")
	public List<ServiceRequest> getAllFeedback(@RequestBody int spId) {
		return repairService.getAllFeedback(spId);
	}

	/**
	 * This url is for get user name for a particular user
	 *
	 * @param userId
	 * @return String user name
	 */
	@PostMapping("/getUserName")
	public String getUserName(@RequestBody int userId) {
		return repairService.getUserName(userId);
	}

	/**
	 * This url is for save payment data
	 *
	 * @param payment
	 * @return nothing
	 */
	@PostMapping("/savePaymentData")
	public void savePaymentStatus(@RequestBody PaymentStatusDTO payment) {
		repairService.savePaymentStatus(payment);
	}

	/**
	 * This url is for get service provider details
	 *
	 * @param spId
	 * @return array of string
	 */
	@PostMapping("/getspdetails")
	public String[] getSpDetail(@RequestBody int spId) {
		return repairService.getSpDetails(spId);
	}

	/**
	 * This url is for save query for a service provider
	 *
	 * @param query
	 * @return String
	 */
	@PostMapping("/savequery")
	public String saveQuery(@RequestBody SpQuery query) {
		return repairService.saveQuery(query);
	}

	/**
	 * This url is for admin login
	 *
	 * @param userDTO unused
	 * @return String
	 */
	@PostMapping("/adminLogin")
	public String adminLogin(@RequestBody UserDTO userDTO) {
		return repairService.admin();

	}

	/**
	 * This url is for get all query details
	 *
	 * @param nothing
	 * @return List of SpQuery
	 */
	@GetMapping("/getallquery")
	public List<SpQuery> getAllQuery() {
		return repairService.getAllQuery();
	}

	/**
	 * This url is for send mail to respond query
	 *
	 * @param queryId
	 * @param request
	 * @return String
	 */
	@PostMapping("/sendmail")
	public String sendMail(@RequestBody int queryId, HttpServletRequest request) {
		String adminMailText = request.getHeader("adminMailText");
		return repairService.sendMail(queryId, adminMailText);
	}

	/**
	 * This url is for get all register request with all the details for a
	 * particular user
	 *
	 * @param userId
	 * @return List of details of inner join table for portfolio details
	 */
	@GetMapping("/getPortfolioDetails")
	public List getAllDetails(String userId) {
		int id = Integer.parseInt(userId);
		return repairService.getPortfolioDetails(id);
	}

	/**
	 * This url is for create check sum for paytm payment gateway
	 *
	 * @param mapData
	 * @return String
	 * @throws Exception
	 */
	@PostMapping("/createchecksum")
	public String createCheckSum(@RequestBody TreeMap<String, String> mapData) throws Exception {
		return paymentService.getCheckSum(mapData);
	}

	/**
	 * This url is for save paytm payment details
	 *
	 * @param request
	 * @param httpServletResponse
	 * @return nothing
	 * @throws IOException
	 */
	@PostMapping(value = "/pgresponsepaytm")
	public void getResponseRedirect(HttpServletRequest request, HttpServletResponse httpServletResponse)
			throws IOException {

		Map<String, String[]> mapData = request.getParameterMap();
		paymentService.getResponseRedirect(mapData, httpServletResponse);
	}

	/**
	 * This url is for assign technician for a particular request
	 *
	 * @param assignTechnicianDTO
	 * @return String
	 */
	@PostMapping(value = "assignTechnician")
	public String assignTechnician(@RequestBody AssignTechnicianDTO assignTechnicianDTO) {
		return repairService.addTechnican(assignTechnicianDTO);
	}

	/**
	 * This url is for get technician details for a particular technician
	 *
	 * @param technicianId
	 * @return Technician
	 */
	@GetMapping(value = "getTechnician")
	public Technician getTechnician(String technicianId) {
		return repairService.getTechnicianDetails(technicianId);
	}

}
