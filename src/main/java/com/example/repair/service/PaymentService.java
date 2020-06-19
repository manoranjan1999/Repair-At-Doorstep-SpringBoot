package com.example.repair.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.repair.model.Payment;
import com.example.repair.model.PaymentStatus;
import com.example.repair.model.ServiceRequest;
import com.example.repair.repo.ServiceRequestRepo;
import com.paytm.pg.merchant.CheckSumServiceHelper;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;

@Component
public class PaymentService {
	private String paytmMerchantKey = "STcctWSmAYW_cQpO";

	@Autowired
	ServiceRequestRepo serviceRequestRepo;

	@Autowired
	PaymentService() {
		Stripe.apiKey = "sk_test_NI2GhDLbSsJqLFoQ7fGcavmx00aZ4EWZWK";
	}

	/* This method is for stripe payment gateway */
	public Charge chargeCreditCard(String token, double amount) throws InvalidRequestException, AuthenticationException,
			APIConnectionException, CardException, APIException {
		Map<String, Object> chargeParams = new HashMap<String, Object>();
		chargeParams.put("amount", (int) (amount * 100));
		chargeParams.put("currency", "inr");
		chargeParams.put("source", token);
		Charge charge = Charge.create(chargeParams);
		return charge;
	}

	/*
	 * This method is used for get CheckSum for paytm payment gateway
	 */
	public String getCheckSum(TreeMap<String, String> parameters) throws Exception {
		return CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(paytmMerchantKey, parameters);
	}

	/*
	 * This method is send response and redirect to front end
	 */
	public void getResponseRedirect(Map<String, String[]> mapData, HttpServletResponse httpServletResponse)
			throws IOException {

		TreeMap<String, String> parameters = new TreeMap<String, String>();
		mapData.forEach((key, val) -> parameters.put(key, val[0]));
		String paytmChecksum = "";
		if (mapData.containsKey("CHECKSUMHASH")) {
			paytmChecksum = mapData.get("CHECKSUMHASH")[0];
		}
		String result;

		boolean isValideChecksum = false;
		System.out.println("RESULT : " + parameters.toString());
		try {
			isValideChecksum = validateCheckSum(parameters, paytmChecksum);
			if (isValideChecksum && parameters.containsKey("RESPCODE")) {
				if (parameters.get("RESPCODE").equals("01")) {
					result = "Payment Successful";

					ServiceRequest sr = new ServiceRequest();
					Payment payment1 = new Payment();
					int srId = Integer.parseInt(parameters.get("ORDERID"));
					sr = serviceRequestRepo.findByServiceRequestId(srId);
					payment1.setTransactionId(parameters.get("TXNID"));
					String[] amount = parameters.get("TXNAMOUNT").split(Pattern.quote("."));
					payment1.setTotalAmount(Integer.parseInt(amount[0]));
					payment1.setPaymentStatus(PaymentStatus.COMPLETED);
					payment1.setPaymentGatewayType(PaymentStatus.PAYTM);

					sr.setPayment(payment1);

					serviceRequestRepo.save(sr);
					System.out.println(result);

				} else {
					result = "Payment Failed";
				}
			} else {
				result = "Checksum mismatched";
			}
		} catch (Exception e) {
			result = e.toString();
		}
		httpServletResponse.sendRedirect("http://localhost:4200/repairinvoice");
	}

	/*
	 * This method is for validate checkSum
	 */
	private boolean validateCheckSum(TreeMap<String, String> parameters, String paytmChecksum) throws Exception {
		return CheckSumServiceHelper.getCheckSumServiceHelper().verifycheckSum(paytmMerchantKey, parameters,
				paytmChecksum);
	}

}