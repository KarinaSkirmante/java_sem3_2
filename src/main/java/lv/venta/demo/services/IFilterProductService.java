package lv.venta.demo.services;

import java.util.ArrayList;

import lv.venta.demo.model.Product;

public interface IFilterProductService {
	//1.1. funkcija - izfitlrēt produktus, kuru cena lielāka par 5 eur
	//1.2. funkcija - izfiltrēt produktus, kuru daudzums mazaks par 2
	//1.3. funkcija - uztaisīt visiem produktiem cenu par 20% lētāk	

	public abstract ArrayList<Product> 
	filterProductsByPriceLargenThan(float priceThreshold);
	
	public abstract ArrayList<Product>
	filterProductByQuantityLessThan(int quantityThreshold);
	
	public abstract ArrayList<Product> 
	getProductWithDiscount(int discountThreashold);
	
}
