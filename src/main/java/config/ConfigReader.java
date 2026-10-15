package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

Properties pro;		
//Load the file 

//Constructor is used to constructor i.e load and read file properties
public ConfigReader()
{
	File src = new File("src/main/resources/config.properties");
	try {
		FileInputStream fis = new FileInputStream(src);
		pro = new Properties();
		pro.load(fis);
		
		
	} catch (FileNotFoundException e) 
	{
		
		System.out.println("Unable to find file Path "+e.getMessage());
	}
	catch (IOException e) {
		
		System.out.println("Unable to read file Properties "+e.getMessage());
	}

}

//Below method is used to get the key

public String getKey(String key)
{
	String value = pro.getProperty(key);
	return value;
	
}

}
