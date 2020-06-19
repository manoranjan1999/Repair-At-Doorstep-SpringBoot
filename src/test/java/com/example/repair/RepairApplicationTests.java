package com.example.repair;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.repair.dto.ServiceProviderDTO;
import com.example.repair.dto.ServiceRequestDTO;
import com.example.repair.dto.UserDTO;
import com.example.repair.model.Address;
import com.example.repair.model.Category;
import com.example.repair.model.ServiceProvider;
import com.example.repair.model.ServiceRequest;
import com.example.repair.model.Status;
import com.example.repair.model.User;
import com.example.repair.repo.ServiceProviderRepo;
import com.example.repair.repo.ServiceRequestRepo;
import com.example.repair.repo.UserRepo;
import com.example.repair.service.RepairService;

@SpringBootTest
class RepairApplicationTests {

	@Autowired
	RepairService repairService;

	@MockBean
	UserRepo userRepo;

	@MockBean
	ServiceProviderRepo serviceProviderRepo;
	
	@MockBean
	ServiceRequestRepo serviceRequestRepo;

	@Test
	void loginTest() {
		String emailId = "bhushan@gmail.com";
		UserDTO userDTO = new UserDTO();
		userDTO.setEmailId(emailId);

		when(userRepo.findByEmailId(emailId)).thenReturn(Optional.of(new User()));
		assertEquals(true, repairService.login(userDTO).isPresent());
	}

	@Test
	void serviceProviderLoginTest() {
		String emailId = "bhushan@gmail.com";
		ServiceProviderDTO serviceProviderDTO = new ServiceProviderDTO();
		serviceProviderDTO.setEmailId(emailId);

		when(serviceProviderRepo.findByEmailId(emailId)).thenReturn(Optional.of(new ServiceProvider()));
		assertEquals(true, repairService.serviceProviderLogin(serviceProviderDTO).isPresent());
	}

	@Test
	void createTest() {
		UserDTO userDTO = new UserDTO();

		userDTO.setCompleteAddress("KIIT Square");
		userDTO.setCurrentLocation("Bhubaneswar");
		userDTO.setPinCode(752436);

		userDTO.setFirstName("Bhushan");
		userDTO.setLastName("Singh");
		userDTO.setEmailId("bhushan@gmail.com");
		userDTO.setPhoneNumber("9835819055");
		userDTO.setRoles("CUSTOMER");
		userDTO.setPassword("12345");
		User user = new User();

		Address address = new Address();
		address.setCompleteAddress(userDTO.getCompleteAddress());
		address.setCurrentLocation(userDTO.getCurrentLocation());
		address.setPinCode(userDTO.getPinCode());

		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setEmailId(userDTO.getEmailId());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		user.setRoles("ROLE_" + userDTO.getRoles());

		List<Address> list = new ArrayList<>();
		list.add(address);

		user.setAddress(list);

		String password = userDTO.getPassword();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(password);

		user.setPassword(encodedPassword);

		when(userRepo.save(any(User.class))).thenReturn(user);
		assertEquals(user, repairService.create(userDTO));
	}

	@Test
	void registerRequestTest() {
		ServiceProviderDTO serviceProviderDTO = new ServiceProviderDTO();
		serviceProviderDTO.setCompleteAddress("Ranchi Jharkhand");
		serviceProviderDTO.setCurrentLocation("Ranchi");
		serviceProviderDTO.setPinCode(825103);

		serviceProviderDTO.setProductName("TV");
		serviceProviderDTO.setProductType("Electronics");

		serviceProviderDTO.setServiceProviderName("Mindfire Solutions");
		serviceProviderDTO.setEmailId("bhushans@mindfiresolutions.com");

		Address address = new Address();
		address.setCompleteAddress(serviceProviderDTO.getCompleteAddress());
		address.setCurrentLocation(serviceProviderDTO.getCurrentLocation());
		address.setPinCode(serviceProviderDTO.getPinCode());

		Category category = new Category();
		category.setProductName(serviceProviderDTO.getProductName());
		category.setProductType(serviceProviderDTO.getProductType());

		ServiceProvider serviceProvider = new ServiceProvider();
		serviceProvider.setServiceProviderName(serviceProviderDTO.getServiceProviderName());
		serviceProvider.setEmailId(serviceProviderDTO.getEmailId());
		serviceProvider.setStatus(false);
		serviceProvider.setRoles("ROLE_SERVICEPROVIDER");

		List<Address> list = new ArrayList<>();
		list.add(address);

		List<Category> list1 = new ArrayList<>();
		list1.add(category);

		serviceProvider.setAddress(list);
		serviceProvider.setCategory(list1);

		when(serviceProviderRepo.save(any(ServiceProvider.class))).thenReturn(serviceProvider);
		assertEquals(serviceProvider, repairService.registerRequest(serviceProviderDTO));
	}

//	@Test
//	void addServiceRequestTest() {
//		ServiceRequestDTO serviceRequestDTO = new ServiceRequestDTO();
//		serviceRequestDTO.setCompleteAddress("Patia Bhubaneswar");
//		serviceRequestDTO.setCurrentLocation("Bhubaneswar");
//		serviceRequestDTO.setPinCode(754236);
//		
//		serviceRequestDTO.setCompanyName("LG");
//		serviceRequestDTO.setDescription("problem on display");
//		serviceRequestDTO.setModelNumber("LG123");
//		serviceRequestDTO.setProductName("TV");
//		serviceRequestDTO.setProductType("Electronics");
//		serviceRequestDTO.setUserId(78);
//		serviceRequestDTO.setAddressId(83);
//		
//		
//
//		
//		ServiceRequest serviceRequest = new ServiceRequest();
//		serviceRequest.setCompanyName(serviceRequestDTO.getCompanyName());
//		serviceRequest.setDescription(serviceRequestDTO.getDescription());
//		serviceRequest.setModelNumber(serviceRequestDTO.getModelNumber());
//		serviceRequest.setProductName(serviceRequestDTO.getProductName());
//		serviceRequest.setProductType(serviceRequestDTO.getProductType());
//		serviceRequest.setUserId(serviceRequestDTO.getUserId());
//		serviceRequest.setAddressId(serviceRequestDTO.getAddressId());
//		serviceRequest.setStatus(Status.OPEN);
//		LocalDate localDate = LocalDate.now();
//		serviceRequest.setLocalDate(localDate);
//		
//		when(serviceRequestRepo.save(serviceRequest)).thenReturn(serviceRequest);
//		assertEquals("add", repairService.addServiceRequest(serviceRequestDTO));
//	}
	
	@Test
	void findAddressTest() {
		String userId="123";
		when(userRepo.findAllByUserId(123)).thenReturn(Stream.of(new Address()).collect(Collectors.toList()));
		assertEquals(1, repairService.findAddress(userId).size());
		
		Optional<User> objectList = Optional.of(new User());                         
//        given(userRepo.findByUserId((Mockito.anyInt()))).willReturn(objectList); 
        Object returnedObject = repairService.findAddress("123");
        Mockito.verify(userRepo).findByUserId(Mockito.anyInt());
        assertNotNull(returnedObject);
	}


	@Test
	void adminTest() {
		assertEquals("admin login", repairService.admin());
	}

}
