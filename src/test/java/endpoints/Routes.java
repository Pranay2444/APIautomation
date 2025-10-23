package endpoints;

public class Routes {
	
	//all endpoints should be in single class including baseURL
	//public static final --> baseURL have to access by every class without creating object and throughout the projects this url remains the final
	// routes are nothing but the variables
	public static final String BASE_URL = "https://fakestoreapi.com/";
	
	//product-module
	
	public static final String GET_ALL_PRODUCTS="/products";
	public static final String GET_PRODUCT_BY_ID = "/products/{id}";
	public static final String GET_PRODUCTS_WITH_LIMIT = "/products?limit={limit}";
	public static final String GET_PRODCUTS_SORTED = "/products?sort={order}";
	public static final String GET__ALL_CATEGORIES ="/products/categories";
	public static final String GET_PRODUCTS_BY_CATEGORY = "/products/category/{category}";
	public static final String CREATE_PRODUCT = "/products";
	public static final String UPDATE_PRODUCT = "/products/{id}";
	public static final String DELETE_PRODUCT = "products/{id}";
	
	
	//cart-module
	
	public static final String GET_ALL_CARTS ="/carts";
	public static final String GET_CARTS_BY_ID ="/carts/{id}";
	public static final String GET_CARTS_WITH_LIMITS ="/carts?limit=x";
	public static final String GET_CARTS_SORTED ="/carts?sort=as|desc";
	public static final String GET_CARTS_WITH_DATE ="/carts?startDate=YYYY-MM-DD&endDate=YYYY-MM-DD";
	public static final String GET_CARTS_WITH_USER_ID ="/carts/user/{userId}";
	public static final String POST_CREATE_CARTS ="/carts";
	public static final String UPDATE_CARTS_BY_ID ="/carts/{id}";
	public static final String PARTIAL_CARTS_BY_ID ="/carts/{id}";
	public static final String DELETE_CARTS_BY_ID="/carts/{id}";


	//users creation & login
	
	public static final String POST_LOGIN ="/auth/login";
	public static final String GET_USER_BY_ID ="/users/{id}";
	public static final String GET_ALL_USERS ="/users";
	public static final String ADD_NEW_SER ="/users";
	public static final String UPDATE_USER ="/users/{id}";
	public static final String PARTIAL_UPDATE_USER ="/users/{id}";



}
