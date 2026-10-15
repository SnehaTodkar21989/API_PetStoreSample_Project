package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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

public class PetStorePostTest extends BaseTest{
	
	String id;
	String name;
	
	@Test(description ="Create New Pet Test",priority=1)
	public void createNewPet()
	{
		//Created object of payload class to get the payload , PetReqPOJO is Pojo class which return type of method 
		//createPostRequestData
		
		PetReqPOJO mainPayload = PetStoreRequestData.createPostRequestData();
		
		Response resp = PetStoreAPIUtils.post(req_spec, APIEndpoints.post_url, mainPayload);
	                   
		               resp.then().spec(res_spec);
		               Assert.assertEquals(resp.statusCode(),200,"Response code did not match");
		              
		               //capturing id 
		               id = resp.jsonPath().getString("id");
		               
		               System.out.println("Id Captured from response "+id);
		               
		               //checking status 		               
		               Assert.assertEquals(resp.jsonPath().getString("status"),"available","Status did not match");
		               
		            // Extract the response payload as a string
		               String responseBody = resp.getBody().asString();
		           

		               // Combine payloads or write separately using a try-with-resources block
		               try (FileWriter writer = new FileWriter("payloads.txt")) {
		                   writer.write("----- REQUEST PAYLOAD -----\n");
		                  // writer.write(mainPayload);
		                   writer.write("\n\n----- RESPONSE PAYLOAD -----\n");
		                   writer.write(responseBody);
		               } catch (IOException e) {
		                   e.printStackTrace();
		               }
		           }
		     
	@Test(description ="Update Name of existing Pet",priority=2)
	public void updatexistingPet()
	{
		//Created object of payload class to get the payload , PetReqPOJO is Pojo class which return type of method 
		//createPostRequestData 
		//Passing the captured id in created request and updating the request
		
		PetReqPOJO mainPayload = PetStoreRequestData.updatePutRequestData(id);
		
		Response resp = PetStoreAPIUtils.put(req_spec, APIEndpoints.put_url, mainPayload);
	                   
		               resp.then().spec(res_spec);
		               Assert.assertEquals(resp.statusCode(),200,"Response code did not match");
		              
		               //capturing id 
		               id = resp.jsonPath().getString("id");
		               
		               System.out.println("Id Captured from response "+id);
		               
		             //capturing name
		               name = resp.jsonPath().getString("name");
		               System.out.println("Updated name Captured from response "+name);
		               
		               //checking status 		               
		               Assert.assertEquals(resp.jsonPath().getString("status"),"available","Status did not match");
		               
		           
		           }	
		
	}
	
	
	
	

