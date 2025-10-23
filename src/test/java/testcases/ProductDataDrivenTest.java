package testcases;

import org.testng.annotations.Test;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import org.testng.annotations.Test;

import endpoints.Routes;
import io.restassured.http.ContentType;
import pojo.Product;
import routes.Payload;
import org.testng.annotations.Test;
import pojo.Product;

public class ProductDataDrivenTest extends baseClass
	
{		
	 @Test (dataProvider="jsonDataProvider", dataProviderClass=utils.DataProviders.class)
		public void testAddNewProduct(Map <String, String> data) { // receiving the values like product id, details, in Map [key-value] pair
			
		 String title = data.get("title");
		 double price = Double.parseDouble(data.get("price"));
		 String category =  data.get("category");
		 String description = data.get("description");
		 String image =  data.get("image");

		 Product newProduct = new Product(title, price, description, image, category);
		 
		 int productId=given()
					.contentType(ContentType.JSON)
					.body(newProduct)
					
				.when()
					.post(Routes.CREATE_PRODUCT)
				.then()
					.log().body()
					.statusCode(201)
					.body("id", notNullValue())
					.body("title", equalTo(newProduct.getTitle()))
					.extract().jsonPath().getInt("id"); //Extracting Id from response body
				
				System.out.println("Product ID ======> "+ productId);
				
				//Delete product
				given()
					.pathParam("id",productId)
				.when()
					.delete(Routes.DELETE_PRODUCT)
				.then()
					.statusCode(200);
				
				System.out.println("Deleted Product ID======> "+ productId);
			
		}
		}

