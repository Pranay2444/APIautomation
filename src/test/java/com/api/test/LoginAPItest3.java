package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class LoginAPItest3 {
	
	@Test(description = "Verify if login API is working..")
	
 	public void loginTest()
	{
		LoginRequest loginRequest = new LoginRequest("uday1234", "uday1234");
		AuthService authService = new AuthService() ;
		//Response response = authService.login("{\"username\": \"uday1234\", \"password\": \"uday1234\"}");
		Response response = authService.login(loginRequest);
		 
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getEmail());
		System.out.println(loginResponse.getUsername());
	    System.out.println(loginResponse.getId());
	
	
	    Assert.assertTrue(loginResponse.getToken() !=null);
	    Assert.assertEquals(loginResponse.getEmail(), "raj@gmail.com");
	
	}
}
// deserialising token/email/id/un from response