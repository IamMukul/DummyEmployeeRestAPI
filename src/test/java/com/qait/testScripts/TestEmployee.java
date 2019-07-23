package com.qait.testScripts;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestEmployee {
	@Test
	public void verifyListOfDataIsComing() {
		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		RequestSpecification request = RestAssured.given();
		Response response = request.get("/employees");
		//String responseData = response.getBody().asString();
		//System.out.println(responseData);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		//System.out.println(response.getBody().asString());
	}
	@Test
	public void verifyDataOfSingleEmployeeIsComing() {
		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		RequestSpecification request = RestAssured.given();
		Response response = request.get("/employee/39559");
		//String responseData = response.getBody().asString();
		//System.out.println(responseData);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println(response.getBody().asString());
	}
	@SuppressWarnings("unchecked")
	@Test
	public void verifyNewEmployeeIsCreating() {
		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		RequestSpecification request = RestAssured.given();
		JSONObject data = new JSONObject();
		data.put("name", "Utsav");
		data.put("salary", "26000");
		data.put("age", "21");
		request.body(data);
		Response response = request.request(Method.POST, "/create");
		System.out.println(response.getBody().asString());
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
	}
	@SuppressWarnings("unchecked")
	@Test
	public void verifyEmployeeDataIsUpdatingForGivenId() {
		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		RequestSpecification request = RestAssured.given();
		//String responseData = response.getBody().asString();
		//System.out.println(responseData);
		JSONObject data = new JSONObject();
		data.put("name", "Delhi Wale");
		data.put("salary", "0");
		data.put("age", "0");
		request.body(data);
		Response response = request.request(Method.PUT, "/update/21");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println(response.getBody().asString());
	}
	@SuppressWarnings("unchecked")
	@Test
	public void verifyEmployeeDataIsDeletingForGivenId() {
		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		RequestSpecification request = RestAssured.given();
		//String responseData = response.getBody().asString();
		//System.out.println(responseData);
		JSONObject data = new JSONObject();
		data.put("name", "Delhi Wale");
		data.put("salary", "0");
		data.put("age", "0");
		request.body(data);
		Response response = request.request(Method.DELETE, "/delete/2");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println(response.getBody().asString());
	}
}
