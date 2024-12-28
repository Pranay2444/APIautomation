package com.api.test;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LoginAPITest2 {
	
	@Test
	public void logintest2(){
		
	//RestAssured.baseURI ="http://64.227.160.186:8080";
	
	Response response = RestAssured.given().baseUri("http://64.227.160.186:8080")
	.header("Content-type", "application/json")
	.body("{\"username\": \"Pranay2\", \"password\": \"Dontaskme@2\"}")
	.post("/api/auth/login");
		
	System.out.println(response.asPrettyString());
	
	Assert.assertEquals(response.getStatusCode(), 200);

}
}
