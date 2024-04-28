package AuthExample;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DigestAuthExample {
	
	@Test
	public void digestTest() {
		
		RequestSpecification req=RestAssured.given();
	   	 req.baseUri("https://httpbin.org");
	   	 req.basePath("/digest-auth/test/farzu/1234");
	   	Response res=req.auth().digest("farzu", "1234").get();
	   	 System.out.println(res.statusCode());
	   	 int stacode=res.statusCode();
	   	 Assert.assertEquals(stacode, 200);
	}
	@Test
public void digestTestMD5() {
		
		RequestSpecification req=RestAssured.given();
	   	 req.baseUri("https://httpbin.org");
	   	 req.basePath("/digest-auth/test/simplilearn/123/MD5");
	   	Response res=req.auth().digest("simplilearn", "123").get();
	   	 System.out.println(res.statusCode());
	   	 int stacode=res.statusCode();
	   	 Assert.assertEquals(stacode, 200);
	}
}
