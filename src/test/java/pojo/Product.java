package pojo;

public class Product {
	
	// POJO for creating payloads for post request
	// request-response mapping
	// Encapsulation[POJO] - Through setters & getters, we can access the variables
	// according to the document- what variables are required- must be private
	
	private String title;
	private double price;
	private String description;
	private String image;
	private String category;
	
	//Constructor
	
	public Product(String title, double price, String description, String image, String category ) {
		
		this.title=title;
		this.price=price;
		this.description=description;
		this.image=image;
		this.category = category;
		
	}
	//getter and setter

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	 
	

}
