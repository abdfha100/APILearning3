package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Util {
	
	public String postId;
	
	public RequestSpecification requestSpecification() throws Exception
	{
		RequestSpecification reqSpec = new RequestSpecBuilder().
				setBaseUri(getGlobalValue("baseUrl")).
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
	
	public String getGlobalValue(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("F:/EclipseIde_workSpace-1/APIFramework3/src/test/java/resources/global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	public String getJsonPath(Response response, String key)
	{
		String responseString = response.asString();
		//System.out.println(responsePostString);
		JsonPath jsp = new JsonPath(responseString);
		return jsp.get(key).toString();
	}
}
