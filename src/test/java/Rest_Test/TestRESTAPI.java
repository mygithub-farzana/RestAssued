package Rest_Test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
@Test
public class TestRESTAPI {
	public void testlistUserAPI() {
	
		Response res=RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(res.getStatusCode());
		System.out.println(res.getTime());
		int actCode=res.getStatusCode();
		Assert.assertEquals(actCode,200); 
	}
	@Test
	public void testAPI() {
		RequestSpecification req=RestAssured.given();
		
		req.baseUri("https://reqres.in");
		req.basePath("/api/users?page=2");
		Response res=req.get();
		System.out.println(res.getStatusCode());
		System.out.println(res.getTime());
		
		ResponseBody rb=res.getBody();
		System.out.println(rb.jsonPath());
}

}
