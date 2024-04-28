package Rest_Test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HeaderValidation {
	
	@Test
	public void headerTest() {
		
		RequestSpecification req=RestAssured.given();
		
		req.baseUri("https://reqres.in");
		req.basePath("/api/users?page=2");
		Response res=req.get();
		
		System.out.println(res.getHeader("Server"));
		Headers h1=res.getHeaders();
		System.out.println(h1.getValue("Server"));
		for(Header hd:h1) {
			System.out.println(hd.getName()+" "+hd.getValue());
		}
	}

}
