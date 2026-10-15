package base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import config.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import jdk.internal.net.http.common.Log;

public class BaseTest {
	
public RequestSpecification req_spec;
public ResponseSpecification res_spec;

//Setting up common required request parameters 

@BeforeClass
public void setup() throws FileNotFoundException
{
	
//Getting required data from Config Class
ConfigReader config = new ConfigReader();
String baseURL=config.getKey("baseURL");

System.out.println("LOG:INFO- Setting Up RequestSpecification & ResponseSpecification for All API");



req_spec =new RequestSpecBuilder()
              .log(LogDetail.ALL)
              .setContentType(ContentType.JSON)
              .setBaseUri(baseURL)
              .build();

res_spec = new ResponseSpecBuilder()
           .log(LogDetail.ALL)
           .expectContentType(ContentType.JSON)
           .build();

}



	

}
