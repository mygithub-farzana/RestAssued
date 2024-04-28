package Rest_Test;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
public class PostExampleForRegisterSuccess {

	//package Rest_Test;

	

	public class PostRegisterSuccess {
		@Test
		public void postTest() {
			JSONObject js=new JSONObject();
			js.put("name","RestAssured");
			js.put("job","Automation Tester");
			RestAssured.baseURI="https://reqres.in/api/register";
			RestAssured.given().header("Content-Type","application/json").contentType(ContentType.JSON).body(js.toJSONString())
			.when()
				.post()
			.then()
				.statusCode(400)
				.log().all();
		}

	}

}
