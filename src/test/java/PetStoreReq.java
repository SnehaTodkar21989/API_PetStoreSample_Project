import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.notNullValue;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PetStoreReq {

	
public static void main(String[] args) 
{
	
//creating category Map	
LinkedHashMap <String, Object>	categorypayload = new LinkedHashMap<String, Object>();

categorypayload.put("id","0");
categorypayload.put("name","Horse");

//Creating tags map & then putting them in ArrayList

LinkedHashMap <String, Object>	tag1 = new LinkedHashMap<String, Object>();

tag1.put("id", "1");
tag1.put("name", "Rocky");

LinkedHashMap <String, Object>	tag2 = new LinkedHashMap<String, Object>();

tag1.put("id", "2");
tag1.put("name", "Tim");

List<Map<String, Object>> tagsPayload = new ArrayList<>();

tagsPayload.add(tag1);
tagsPayload.add(tag2);

LinkedHashMap <String, Object>	mainPayload = new LinkedHashMap<String, Object>();
mainPayload.put("id", "0");
mainPayload.put("category", categorypayload);
mainPayload.put("name", "Horse");
mainPayload.put("tags", tagsPayload);
mainPayload.put("status", "available");

given().
log().all().
header("Content-Type", "application/json").
body(mainPayload).
when().
post("https://petstore.swagger.io/v2/pet").
then().
log().all().
statusCode(200);

	
}
}
