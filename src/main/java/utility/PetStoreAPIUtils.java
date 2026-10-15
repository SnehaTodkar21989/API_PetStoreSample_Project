package utility;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.Method;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

import org.testng.annotations.BeforeMethod;

import factory.PetStoreRequestData;
import io.restassured.specification.RequestSpecification;
import models.PetReqPOJO;

public class PetStoreAPIUtils {

	
	
	public static Response post(RequestSpecification spec,String path,Object payload)
	
	{
		
		Response response= given()
				          .spec(spec)
				          .when()
				          .body(payload)
                          .post(path);
                
          return response;             
				          
		
		
	}
	
public static Response get(RequestSpecification spec,Map<String,Object> queryparam,String path)
	
	{
		
		Response response= given()
				          .spec(spec)
				          .queryParams(queryparam)
				          .when()
				          .get(path);
                
          return response;             
				          
		
		
	}

public static Response put(RequestSpecification spec,String path,Object payload)

{
	
	Response response= given()
			          .spec(spec)
			          .when()
			          .body(payload)
                      .put(path);
            
      return response;             
			          
	
	
}



	
	
}
