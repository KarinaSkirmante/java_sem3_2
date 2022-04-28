package lv.venta.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Table
@Entity
public class Product {

	//1.mainīgie
	@Column(name="Id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	//@NotNull
	//@NotEmpty
	@Column(name="Title")
	@Size(min = 3, max = 30)	
	@Pattern(regexp="[A-Z]{1}[a-z]+", message="Must be first capital letter and others small")
	private String title;
	
	
	@Column(name="Price")
	@Min(0)
	@Max(10000)
	private float price;
	
	@Column(name="Quantity")
	@Min(0)
	@Max(1000)
	private int quantity;
	
	
	//2.get un set
	
	public String getTitle() {
		return title;
	}
	public int getId() {
		return id;
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
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}
	
	
	
	
	//4.? to String
	
}
