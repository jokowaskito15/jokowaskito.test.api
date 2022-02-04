package jokowaskito.api.test.run;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test03_PUT {
	
	@Test
	public void test03_put() {
		
		JSONObject request = new JSONObject();
		
		request.put("gender", "female");
		request.put("status", "active");
		
		System.out.println(request.toJSONString());
		
		given()
		.auth().oauth2("5d1966849d6cd0f51a62cba982e05eddf7e33d60f1d4c325b0069f6049c3458f")
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.put("https://gorest.co.in/public/v1/users/4264")
		.then()
		.statusCode(200)
		.log().all();
	}
}
