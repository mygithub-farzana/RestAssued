package AuthExample;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasicAuthExample {
	@Test

	public void basicAuth() {
		RequestSpecification req=RestAssured.given();
	   	 req.baseUri("https://httpbin.org");
	   	 req.basePath("/basic-auth/farzana/123");
	   	 //non preemptive
	   	 //dont share credentials initially to server,only if any error then credentials will be shared
	   	 Response res=req.auth().basic("farzana", "123").get();
	   	 System.out.println(res.statusCode());
	}
	@Test
	public void PreEmptiveAuth() {
		RequestSpecification req=RestAssured.given();
	   	 req.baseUri("https://httpbin.org");
	   	 req.basePath("/basic-auth/farzana/123");
	   	Response res=req.auth().preemptive().basic("farzana", "123").get();
	   	System.out.println(res.statusCode());
	}
	
}

