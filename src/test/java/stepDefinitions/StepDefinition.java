package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestBuild;
import resources.Util;
import static org.junit.Assert.*;
import static io.restassured.RestAssured.*;

public class StepDefinition extends Util {
	
	RequestSpecification reqRespo;
	ResponseSpecification res;
	Response response;
	TestBuild data = new TestBuild();
	APIResources resourceAPI;
	public static String petId; 
	
	
	@Given("Add pet payload with {int} {string}")
	public void add_pet_payload_with(int id, String name) throws Exception {
		
		reqRespo = given().spec(requestSpecification()).
		body(data.addPetPayload(id, name));
	}
	
	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		
		resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		if(method.equalsIgnoreCase("POST"))
		{
			response=reqRespo.when().
			post(resourceAPI.getResource());
		}
		else if(method.equalsIgnoreCase("GET"))
		{
			response=reqRespo.when().
			get(resourceAPI.getResource()+ petId);
		}
		else if(method.equalsIgnoreCase("DELETE"))
		{
			response=reqRespo.when().
			delete(resourceAPI.getResource()+petId);
		}
	}

	@Then("The API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {
		
		reqRespo.then().spec(responseSpecification());
		assertEquals (response.getStatusCode(),200);
	}
	
	@Then("{string} in the response body is {string}")
	public void in_the_response_body_is(String keyValue, String ExpectedValue) {
		
		assertEquals(getJsonPath(response, keyValue), ExpectedValue);
		System.out.println((getJsonPath(response,keyValue)));	
	}
	
	@Then("verify petId created maps to {string} using {string}")
	public void verify_petId_created_maps_to_using(String expectedName, String resource) throws Exception {
	  
		//getting the petID from the resonse
		petId = getJsonPath(response, "id");
		
		//prepare ReqSpec
		reqRespo= given().spec(requestSpecification());
				//formParam("id", petId);
				//param("id",petId);
				
		
		user_calls_with_http_request(resource, "GET");
		
		String actualName = getJsonPath(response, "name");
		System.out.println(actualName);
		
		assertEquals(actualName,expectedName);
	}
	
	@Given("DeleltePetAPI paylod")
	public void deleltepetapi_paylod() throws Exception {
		
		reqRespo =given().
				spec(requestSpecification());
	}
}
