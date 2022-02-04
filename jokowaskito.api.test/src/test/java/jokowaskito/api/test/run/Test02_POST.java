package jokowaskito.api.test.run;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test02_POST {

	
	@Test
	public void test02_post() {
		
		JSONObject request = new JSONObject();
		
		request.put("id", "1");
		request.put("name", "joko waskitotest");
		request.put("email", "jokowaskitotest@gmail.com");
		request.put("gender", "male");
		request.put("status", "active");
		
		
		System.out.println(request.toJSONString());
		
		given()
		.auth().oauth2("5d1966849d6cd0f51a62cba982e05eddf7e33d60f1d4c325b0069f6049c3458f")
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.post("https://gorest.co.in/public/v1/users")
		.then()
		.statusCode(201)
		.log().all();
	}
}
