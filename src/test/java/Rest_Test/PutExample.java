package Rest_Test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutExample {
	@Test
	public void putTest() {
	
		JSONObject js=new JSONObject();
		js.put("name","RestAssured");
		js.put("job","Automation Lead");
		RestAssured.baseURI="https://reqres.in/api/users/2";
		RestAssured.given().header("Content-Type","application/json").contentType(ContentType.JSON).body(js.toJSONString())
		.when()
			.put()
		.then()
			.statusCode(200)
			.log().all()
			.header("Server", "cloudflare");

	}

}
