package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Util {
	
	public String postId;
	public static RequestSpecification reqSpec;
	public static ResponseSpecification respSpec;
	
	public RequestSpecification requestSpecification() throws Exception
	{
		if (reqSpec == null)
		{
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));			
			reqSpec = new RequestSpecBuilder().
					setBaseUri(getGlobalValue("baseUrl")).
					addFilter(RequestLoggingFilter.logRequestTo(log)).
					addFilter(ResponseLoggingFilter.logResponseTo(log)).
					addHeader("accept", "application/json").
					setContentType(ContentType.JSON).
					build();
			return reqSpec;
		}
		return reqSpec;
	}
	
	public ResponseSpecification responseSpecification()
	{
		  respSpec = new ResponseSpecBuilder().
				expectStatusCode(200).
				expectContentType(ContentType.JSON).
				build();
		return respSpec;
	}
	
	public String getGlobalValue(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/resources/global.properties");
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
