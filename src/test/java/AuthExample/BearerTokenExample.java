package AuthExample;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BearerTokenExample {
	@Test

	
public void BearerTest() {
		
		RequestSpecification req=RestAssured.given();
	   	 req.baseUri("https://gorest.co.in");
	   	 req.basePath("/public/v2/users");
	   	 JSONObject reqpayload=new JSONObject();
	   	 reqpayload.put("email", "farza1@gmail.com");
	   	reqpayload.put("name", "farza1");
	   	reqpayload.put("gender", "female");
	   	reqpayload.put("status", "active");
	   	String token="Bearer 876cd61cde930d44fb495f753c602abfc99905c02045e233438b7f5faee86936";
	   	req.headers("Authorization",token).contentType(ContentType.JSON).body(reqpayload.toJSONString(reqpayload));
	   	Response res=req.post();
	   	System.out.println(res.statusCode());
	}  	

}
