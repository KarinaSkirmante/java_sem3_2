package lv.venta.demo.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Product {

	//1.mainīgie
	private int id;
	
	//@NotNull
	//@NotEmpty
	@Size(min = 3, max = 30)	
	@Pattern(regexp="[A-Z]{1}[a-z]+", message="Must be first capital letter and others small")
	private String title;
	
	
	@Min(0)
	@Max(10000)
	private float price;
	
	@Min(0)
	@Max(1000)
	private int quantity;
	
	private static int counter=0;
	//2.get un set
	
	public String getTitle() {
		return title;
	}
	public int getId() {
		return id;
	}
	public void setId() {
		this.id = counter;
		counter++;
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
		setId();
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}
	
	
	
	
	//4.? to String
	
}
