package AuthExample;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OAuth2Example {
	public String accessToken;
	@Test
	public void getAccessToken() {
		String clientId="ASKsHhNAHLl54Is-_jJKRZgsjU06Pm1qVT_6cRTZsa_Esqrl4OOYhplcSKaXRZRqDvnnXpdHn__SXKqB"; //copy from paypal website
		String secretId="EGY3bA1bWJq3qtJklRIbNTqmHbSCqBcx1dIUdNqLg1syIvy8Gnzmtzw7JTB8X7Vk8S4hRPm7mV4E-0pM";
		RequestSpecification req=RestAssured.given();
		
		req.baseUri("https://api-m.sandbox.paypal.com");
		req.basePath("/v1/oauth2/token");//end point
		Response res=req.auth().preemptive().basic(clientId, secretId).param("grant_type", "client_credentials").post();
		System.out.println(res.statusLine());
		System.out.println(res.prettyPrint());
		accessToken=res.getBody().path("access_token");
		System.out.println(accessToken);
}
	@Test(dependsOnMethods="getAccessToken")
    public void oAuthTest() {
   	 
   	 Response res=(Response) RestAssured
   						 .given()
   							 .auth()
   								 .oauth2(accessToken)
   									 .queryParam("page", 3)
   									 .queryParam("page_size", 4)
   									 .queryParam("total_count_required", "true")
   									 .get("https://api-m.sandbox.paypal.com/v1/invoicing/invoices");
   	 
   	 
   	 System.out.println(res.statusLine());
   	 
    }    


}
