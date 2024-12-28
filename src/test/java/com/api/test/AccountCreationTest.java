package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	
	@Test(description = "Verify if login API is working..")
	
	public void createAccountTest() {
		
		SignUpRequest signUpRequest=	new SignUpRequest.Builder().userName("Pranay123")
		.email("disha22@gmail.com")
		.firstName("Pranay")
		.lastName("patani")
		.password("disha@123")
		.mobileNumber("9936363578")
		.build();
		
		AuthService authService = new AuthService();
		Response response= authService.signUp(signUpRequest);
	System.out.println(response.asPrettyString());
	}

}
