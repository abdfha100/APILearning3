package petAPI;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Util1 {
	
	public String postId;
	
	public RequestSpecification requestSpecification()
	{
		RequestSpecification reqSpec = new RequestSpecBuilder().
				setBaseUri("https://petstore.swagger.io").
				addHeader("accept", "application/json").
				setContentType(ContentType.JSON).
				build();
		return reqSpec;
	}
	
	public ResponseSpecification responseSpecification()
	{
		ResponseSpecification respSpec = new ResponseSpecBuilder().
				expectStatusCode(200).
				expectContentType(ContentType.JSON).
				build();
		return respSpec;
	}
	
	public String getJsonPath(Response response, String key)
	{
		String responseString = response.asString();
		//System.out.println(responsePostString);
		
		JsonPath jsp = new JsonPath(responseString);
		return jsp.get(key).toString();
		
		/*postId = jsp.getString("id");
		System.out.println(postId);
		return postId;*/
	}
}
