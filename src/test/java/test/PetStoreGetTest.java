package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import base.BaseTest;
import enums.APIEndpoints;
import factory.PetStoreRequestData;
import io.restassured.http.Method;
import io.restassured.response.Response;
import models.PetReqPOJO;
import models.PetReqPOJO.CategoryData;
import models.PetReqPOJO.TagData;
import utility.PetStoreAPIUtils;

public class PetStoreGetTest extends BaseTest{
	
		
	@Test(description ="Get The available Pet Data")
	public void getPetDetails()
	{
			
		//Map<String, Object> queryparamasmap = new HashMap<String, Object>();
		//queryparamasmap.put ("status", "available");
		
		Map<String, Object> queryparamasmap=Map.of("status", "available");
		
		Response resp = PetStoreAPIUtils.get(req_spec, queryparamasmap, APIEndpoints.get_url);
	                   
		               resp.then().spec(res_spec);
		               
		               Assert.assertEquals(resp.getStatusCode(),200, "Status Code did not match");
		               Assert.assertNotNull(resp.jsonPath().get("id"));
		               
		               //Checking category name contains Mestizo
		               String name = resp.jsonPath().getString("category.name");
		              // System.out.println(name);
		              Assert.assertTrue(name.contains("Dogs"));
		               
		               
		            // Extract the response payload as a string
		           /*    String responseBody = resp.getBody().asString();
		           

		               // Combine payloads or write separately using a try-with-resources block
		               try (FileWriter writer = new FileWriter("payloads.txt")) {
		                   writer.write("----- REQUEST PAYLOAD -----\n");
		                  // writer.write(mainPayload);
		                   writer.write("\n\n----- RESPONSE PAYLOAD -----\n");
		                   writer.write(responseBody);
		               } catch (IOException e) {
		                   e.printStackTrace();
		               }*/
		           }
		     
		
		
	}
	
	
	
	

