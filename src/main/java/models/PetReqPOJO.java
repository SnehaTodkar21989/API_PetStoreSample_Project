package models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetReqPOJO {
	
	private String id;
	public CategoryData category;
	private String name;
	public List<TagData> tags ;
	private String status;

@Data
@NoArgsConstructor
@AllArgsConstructor	
public static class CategoryData
{
	private String id;
	private String name;
		
	
}

@Data
@NoArgsConstructor
@AllArgsConstructor	
public static class TagData
{
	private String id;
	private String name;
}
	
	

}
