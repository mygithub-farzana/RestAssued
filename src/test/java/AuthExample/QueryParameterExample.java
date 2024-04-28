package AuthExample;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
public class QueryParameterExample {

		
	@Test
		public void testAPI() {
			RequestSpecification req=RestAssured.given();
			
			req.baseUri("https://reqres.in");
			req.basePath("/api/users");//end point
			req.queryParam("page",2);
			QueryableRequestSpecification qryrequest=SpecificationQuerier.query(req);
			//get base URI
			String retrieveBaseURI=qryrequest.getBaseUri();
			System.out.println(retrieveBaseURI);
			
			//get base path
			String retrieveBaseURL=qryrequest.getBasePath();
			System.out.println(retrieveBaseURL);
			
			Response res=req.get();
			System.out.println(res.getStatusCode());
			System.out.println(res.getTime());
			
			ResponseBody rb=res.getBody();
			System.out.println(rb.jsonPath());
	

	}

}
