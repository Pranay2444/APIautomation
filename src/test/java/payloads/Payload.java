package payloads;

import java.util.Random;

import com.github.javafaker.Faker;

import pojo.Product;

public class Payload {
	private static final Faker faker = new Faker();
	private static final String categories [] = {"electronics","furniture","clothing","books", "beauty"};
	private static Random random = new Random();
	
	
	//Product --> create method for generating random data for payload
	
	public static Product productPayload() {
		String name = faker.commerce().productName();
		double price =  Double.parseDouble(faker.commerce().price());
		String description = faker.lorem().sentence();
		String imageUrl = "https://i.pravatar.cc/100";
		String category =  categories[random.nextInt(5)]; // for 5 categories - not from faker but random class 
		
		// now assigned this data to product POJO class 
		
		return new Product(name, price, description, imageUrl, category );
	}
	

}
