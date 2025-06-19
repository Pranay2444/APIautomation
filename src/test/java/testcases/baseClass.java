package testcases;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.testng.annotations.BeforeClass;

import endpoints.Routes;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import utils.ConfigReader;

public class baseClass {
	
	ConfigReader confread;
	
	@BeforeClass
	public void setup() throws FileNotFoundException 
	{
		RestAssured.baseURI= Routes.BASE_URL; //RA static variable
		
		confread = new ConfigReader();
		
		//Setup filters for logging 
		 
		FileOutputStream fos = new FileOutputStream("./logs/test_logging.txt");
		PrintStream log = new PrintStream(fos, true);
		RequestLoggingFilter requestLoggingFilter = new RequestLoggingFilter(log);
		ResponseLoggingFilter responseLoggingFilter = new ResponseLoggingFilter(log);
	
		RestAssured.filters(requestLoggingFilter, responseLoggingFilter);
		
	}
	//Helper method to check if a list is in Desc order 
		//Test to retreive products in ASC order
			
			
			boolean isSortedDesc(List <Integer> list) {
				
				for(int i=0; i < list.size()-1;i++ )
				{
					if(list.get(i) < list.get(i+1))
					{
						return false;
					}
				}
				return true;
				
			}
			 
			// Helper method to check if a list is in Asc order 
					 boolean isSortedAsc(List <Integer> list) {
							
							for(int i=0; i < list.size()-1;i++ )
							{
								if(list.get(i) > list.get(i+1))
								{
									return false;
								}
							}
							return true;
					 
					 }
}
