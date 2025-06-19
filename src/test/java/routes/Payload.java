package routes;

import java.util.Random;

import com.github.javafaker.Faker;

import pojo.Product;

public class Payload {
	
	//faker libaries to generate fake data for testing & dev
	
		//Product
		
		private static final Faker faker = new Faker();
		private static final String categories[] = {"electronics", "furniture", "clothing", "books", "beauty"}; 
		private static final Random random = new Random();
		
		
		public static Product productPayload()
		{
			String name = faker.commerce().productName();
			double price = Double.parseDouble(faker.commerce().price());
			String description = faker.lorem().sentence();
			String imageUrl = "https://i.pravatar.cc/100";
			String category = categories[random.nextInt(categories.length)];
			
			
			//we need to assign this dummy random data to POJO	
			//product name & category there is no similarity, both are generated differently
			//new Product(name, price, description,imageUrl, category);
			//new Product(name, price, description,imageUrl, category);
			return new Product(name, price, description,imageUrl, category);
		

		}
}

