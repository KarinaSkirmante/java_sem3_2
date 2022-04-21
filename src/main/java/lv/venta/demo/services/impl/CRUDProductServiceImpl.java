package lv.venta.demo.services.impl;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import lv.venta.demo.model.Product;
import lv.venta.demo.services.ICRUDProductService;

@Service
public class CRUDProductServiceImpl implements ICRUDProductService {
	
	private ArrayList<Product> allProducts = new ArrayList<>(
			Arrays.asList(
					new Product("Maize", 2.13f, 3), 
					new Product("Ūdens", 0.56f, 100), 
					new Product("Telefons", 600.99f, 2) ));
	
	
	@Override
	public Product createProduct(Product temp) {
		for(Product prod: allProducts)
		{
			if(prod.getTitle().equals(temp.getTitle())
					&&prod.getPrice() == temp.getPrice())
			{
				int newQuantity = prod.getQuantity()+temp.getQuantity();
				prod.setQuantity(newQuantity);
				return prod;
			}
		}
		
		Product newProduct = new Product(temp.getTitle(), 
				temp.getPrice(), temp.getQuantity());
		allProducts.add(newProduct);
		return newProduct;
		
		
	}

	@Override
	public ArrayList<Product> readAllProducts() {
		// TODO Auto-generated method stub
		return allProducts;
	}

	@Override
	public Product readById(int id) throws Exception {
		for(Product prod: allProducts)
		{
			if(prod.getId() == id)
			{
				return prod;
			}
		}
		throw new Exception("Tāds id neeksistē");
		
	}

	@Override
	public void updateById(int id, Product temp) throws Exception {
		for(Product prod: allProducts)
		{
			if(prod.getId() == id)
			{
				if(!prod.getTitle().equals(temp.getTitle()))
					prod.setTitle(temp.getTitle());
				if(prod.getQuantity() != temp.getQuantity())
					prod.setQuantity(temp.getQuantity());
				if(prod.getPrice()!=temp.getPrice())
					prod.setPrice(temp.getPrice());
			}
		}
		throw new Exception("Tāds id neeksistē");
		
	}

	@Override
	public void deleteById(int id) throws Exception {
		boolean isFound = false;
		for(Product prod: allProducts)
		{
			if(prod.getId() == id)
			{
				allProducts.remove(prod);
				isFound = true;
				
			}
		}
		
		if(!isFound)
			throw new Exception("Tāds id neeksistē");
		
	}
//1. service interfeiss IFilterProductService
//2. service kā klase un realīzet visas funkcijas	
	
	
}
