package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.models.request.LoginRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
//import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	
	
	//base service -> request specification
	//Creating request & handling response
	private static final String BASE_URL ="http://64.227.160.186:8080";
	private RequestSpecification requestSpecification;
	
	
	public BaseService() {
		 
		requestSpecification = given().baseUri(BASE_URL);
		
	}
	
	//protected Response postRequest(LoginRequest payload, String endpoint) {
		protected Response postRequest(Object payload, String endpoint) {

		return requestSpecification.contentType(ContentType.JSON).
		body(payload).post(endpoint);
		
		
	}
		protected Response postRequest(String baseUrl, Object payload, String endpoint) {
			return requestSpecification.baseUri(baseUrl).contentType(ContentType.JSON).body(payload).post(endpoint);
			
		}
}
// Created object of LoginRequest class, but avoid it for the tight coupling 
// Instead put Object class ref , so it can call all the method related to the service ==> loosely coupled
// This is called , "Polymorphism".
// all the classes extends to Object class