package petAPI;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import java.util.ArrayList;

import java.util.List; 

public class PetAPI extends Util1 {
	
	public String postId;
	TestBuild1 data = new TestBuild1();
	RequestSpecification resp;
	Response response;
	
	@Test
	public void tc01()
	{
		RequestSpecification resp = given().
			spec(requestSpecification()).
			body(data.getPePostPayload());
			
		Response response = resp.when().
			post("/v2/pet").
		then().
			spec(responseSpecification()).
			extract().response();
		
		postId = getJsonPath(response, "id");
		System.out.println("tc01: "+postId);
	}
	
	@Test
	public void tc02()
	{
		RequestSpecification resp = given().
			spec(requestSpecification());
		
		Response response =resp.when().
			get("/v2/pet/"+postId).
		then().
			spec(responseSpecification()).
			extract().response();
		
		String Id =getJsonPath(response, "id");
		System.out.println("tc02: "+Id);
		

		
		
		/*String responseGetString = respo.asString();
		//System.out.println(responseGetString);
		JsonPath jsp = new JsonPath(responseGetString);
		String getId = jsp.getString("id");
		System.out.println(getId);  */
	}
	
	@Test
	public void tc03()
	{
		
		RequestSpecification resp = given().
			spec(requestSpecification());
		
		Response response = resp.when().
			delete("/v2/pet/"+postId).
		then().
			spec(responseSpecification()).
			extract().response();
		
		String msg = getJsonPath(response, "message");
		System.out.println("tc03: " +msg);
		
		/*String responseDelString=  delresp.asString();
		//System.out.println(responseDelString);
		JsonPath jsp = new JsonPath(responseDelString);
		String msg = jsp.getString("message");
		System.out.println(msg); */		
	} 
}
