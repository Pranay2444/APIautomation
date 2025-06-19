package testcases;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import endpoints.Routes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.Product;
import routes.Payload;

import static org.hamcrest.MatcherAssert.assertThat;


public class ProductTest extends baseClass {
	
	
	//1. Test to retreive all products
	@Test
	
	public void testGetAllProducts() {
		
		given()
		
		
		.when()
		
			.get(Routes.GET_ALL_PRODUCTS)
			
			.then()
				.statusCode(200)
				.body("size()", greaterThan(0))
				.log().body();
			
	}
	
	//2. Test to retreive a single product by id
	
		@Test
		public void testGetSingleProduct() 
		
		{
		int productId = confread.getIntProperty("productId");
			
			given()
				.pathParam("id", productId)
			
			.when()
				.get(Routes. GET_PRODUCT_BY_ID )
			
			.then()
				.statusCode(200)
				.log().body();
			
			
		}
		
		//3. Test to retreive the limiting the results
		
		@Test
		
		public void testGetLimitingResults() {
			
			given()
			.pathParam("limit", 5)
			 
		.when()
			.get(Routes.GET_PRODUCTS_WITH_LIMIT )
		
		.then()
			.statusCode(200)
			.log().body()
			.body("size()", equalTo(5));
			
		}
		
		//4. Fetch the data in ASC/DES order --> Sorting
		//DESC by default --> recent product will show first
		//In desc order
		
		@Test
		public void testGetSortedProductsDsc() {
			
			Response response =given()
					.pathParam("order", "desc")
			
			.when()
				.get(Routes.GET_PRODCUTS_SORTED)
			
			.then()
				.statusCode(200)
				.extract().response();
			
		List <Integer> productId = response.jsonPath().getList("id", Integer.class);
			assertThat(isSortedDesc(productId), is(true));
		
		}
		
		//5. Get products in Asending order
		@Test
		public void testGetSortedProductsAsc() {
			
			Response response =given()
					.pathParam("order", "asc")
			
			.when()
				.get(Routes.GET_PRODCUTS_SORTED)
			
			.then()
				.statusCode(200)
				.extract().response();
			
		List <Integer> productId = response.jsonPath().getList("id", Integer.class);
			assertThat(isSortedDesc(productId), is(true));
		
		}
		
		//6. Capture all categories of products
		@Test
		public void testGetAllCategories() {
			given()
			
			.when()
			
				.get(Routes.GET__ALL_CATEGORIES)
			.then()
				.statusCode(200)
				.body("size()", greaterThan(0))
				.log().body();
			
		}
		
		//7. Retreive products by categeory
		@Test
		public void testGetProductByCategory() {
			given()
				.pathParam("category", "electronics")
			
			.when()
				.get(Routes.GET_PRODUCTS_BY_CATEGORY)
			
			.then()
				.statusCode(200)
				.body("size()", greaterThan(0))
				.body("category", everyItem(notNullValue()))
				.body("category", everyItem(equalTo("electronics")))
				.log().body();

			 
			
			
		}
		
		
		//8. Add new product
		@Test
		
		public void testAddNewProduct() 
		{
			Product newProduct = Payload.productPayload();
		
		int productId =	given()
				.contentType(ContentType.JSON)
				.body(newProduct)
			
			.when()
				.post(Routes.CREATE_PRODUCT)
			
			.then()
				.log().body()
				.statusCode(200)
				.body("id", notNullValue())
				.body("title", equalTo(newProduct.getTitle()))
				.extract().jsonPath().getInt("id"); //extracting id from response body
			
		System.out.println(productId );	
			
		}
	//9. Test to update the product
		
		@Test
		public void testUpdateProduct() 
		
		{
			int productId = confread.getIntProperty("productId");
		Product	updatePayload = Payload.productPayload();
			
			given()
			.contentType(ContentType.JSON)
			.body(updatePayload)
			.pathParam("id", productId)
			
			.when()
				.put(Routes.UPDATE_PRODUCT)
			
			.then()
				.statusCode(200)
				.log().body()
				.body("title", equalTo(updatePayload.getTitle()))
			
			;
		}
		
		//10. Test to delete a product
		
		@Test
		public void testDeleteProduct() {
			int productId = confread.getIntProperty("productId");
				
			
			given()
				.pathParam("id", productId)
			.when()
				.delete(Routes.DELETE_PRODUCT)
			.then()
				.statusCode(200)
			;
		}
		
		
			
}
