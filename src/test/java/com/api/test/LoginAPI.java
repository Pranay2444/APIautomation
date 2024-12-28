package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPI {
	
	@Test(description = "Verify if Login API is working...")
	public void logintest() {
		
		RestAssured.baseURI = "http://64.227.160.186:8080";
		 
		RequestSpecification x = RestAssured.given();
	
		RequestSpecification y= x.header("Content-type", "application/json");
		
		RequestSpecification z = y.body("{\"username\": \"uday1234\", \"password\": \"uday1234\"}");
		
		Response res=z.post("/api/auth/login");
		
		System.out.println(res.asPrettyString());
		
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	

}
