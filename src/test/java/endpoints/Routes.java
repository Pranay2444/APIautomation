package endpoints;

public class Routes {
	
	//all endpoints should be in single class including baseURL
	//public static final --> baseURL have to access by every class without creating object and throughout the projects this url remains the final
	
	public static final String BASE_URL = "https://fakestoreapi.com/";
	
	//product
	
	public static final String GET_ALL_PRODUCTS="/products";
	public static final String GET_PRODUCT_BY_ID = "/products/{id}";
	public static final String GET_PRODUCTS_WITH_LIMIT = "/products?limit={limit}";
	public static final String GET_PRODCUTS_SORTED = "/products?sort={order}";
	public static final String GET__ALL_CATEGORIES ="/products/categories";
	public static final String GET_PRODUCTS_BY_CATEGORY = "/products/category/{category}";
	public static final String CREATE_PRODUCT = "/produts";
	public static final String UPDATE_PRODUCT = "/products/{id}";
	public static final String DELETE_PRODUCT = "products/{id}";
	
	//users
	
	
	//Cart 
	
	
	//Login
	



}
