package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestBuild;
import resources.Util;
import static org.junit.Assert.*;
import static io.restassured.RestAssured.*;

public class StepDefinition extends Util {
	
	RequestSpecification reqRespo;
	ResponseSpecification res;
	Response response;
	TestBuild data = new TestBuild();
	
	@Given("Add pet payload")
	public void add_pet_payload() throws Exception {
		
		reqRespo = given().spec(requestSpecification()).
		body(data.addPetPayload());
	}

	@When("User calls AddPetAPI with POST http request")
	public void user_calls_AddPetAPI_with_POST_http_request() {
		
		response= reqRespo.when().
				post("/v2/pet");
	   
	}

	@Then("The API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {
		
		reqRespo.then().spec(responseSpecification());
		String id = getJsonPath(response, "id");
		System.out.println(id);
	}
}
