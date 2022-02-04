package jokowaskito.api.test.run;

import static org.testng.Assert.assertEquals;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test01_GET {

	
	String endpoint = "https://gorest.co.in/public/v1/users";
	
	@Test
	public void test_01() {
		
		Response response = RestAssured.get(endpoint);
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		
		int statusCode = response.getStatusCode();
		
		assertEquals(statusCode, 200);
	}
	
	@Test
	public void test_02() {
		
		given()
		.header("Content-Type", "application/json")
		.auth().oauth2("5d1966849d6cd0f51a62cba982e05eddf7e33d60f1d4c325b0069f6049c3458f")
		.get(endpoint)
		.then()
		.statusCode(200)
		.body("data.id[0]", equalTo(4264));
	}
}
