package factory;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import models.PetReqPOJO;
import models.PetReqPOJO.CategoryData;
import models.PetReqPOJO.TagData;

public class PetStoreRequestData {
	
@BeforeClass
public static PetReqPOJO createPostRequestData()
{
	//Creating Category Data
	CategoryData category=new CategoryData();
	category.setId("1");
	category.setName("Horse");
	
	//Creating Tag Data
	TagData tag1 = new TagData();
	TagData tag2 = new TagData();
	
	tag1.setId("1");
	tag1.setName("Rider1");
	
	tag2.setId("2");
	tag2.setName("Rider2");
	
	List<TagData> tagPayload = new ArrayList<>();
	tagPayload.add(tag1);
	tagPayload.add(tag2);
	
	//Creating mainPayload
	PetReqPOJO mainPayload = new PetReqPOJO();
	mainPayload.setId("123");
	mainPayload.setCategory(category);
	mainPayload.setName("SASHA");
	mainPayload.setTags(tagPayload);
	mainPayload.setStatus("available");
	
	return mainPayload;


}

@BeforeClass
public static PetReqPOJO updatePutRequestData(String id)
{
	//Creating Category Data
	CategoryData category=new CategoryData();
	category.setId("1");
	category.setName("Horse");
	
	//Creating Tag Data
	TagData tag1 = new TagData();
	TagData tag2 = new TagData();
	
	tag1.setId("1");
	tag1.setName("Rider1");
	
	tag2.setId("2");
	tag2.setName("Rider2");
	
	List<TagData> tagPayload = new ArrayList<>();
	tagPayload.add(tag1);
	tagPayload.add(tag2);
	
	//Creating mainPayload
	PetReqPOJO mainPayload = new PetReqPOJO();
	mainPayload.setId(id);
	mainPayload.setCategory(category);
	mainPayload.setName("SASHA1");
	mainPayload.setTags(tagPayload);
	mainPayload.setStatus("available");
	
	return mainPayload;


}


}
