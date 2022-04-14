package lv.venta.demo.model;

public class Product {

	//1.mainīgie
	private String title;
	private float price;
	private int quantity;
	
	//2.get un set
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
		
	
	//3.abi konstruktori
	public Product() {}
	public Product(String title, float price, int quantity) {
		super();
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}
	
	
	
	
	//4.? to String
	
}
