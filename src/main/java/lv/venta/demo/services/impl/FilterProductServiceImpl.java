package lv.venta.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.demo.model.Product;
import lv.venta.demo.services.ICRUDProductService;
import lv.venta.demo.services.IFilterProductService;

@Service
public class FilterProductServiceImpl implements IFilterProductService {
//1. pārtaisīt FilterProductServiceImpl uz repo
//2. github/gitlab jaunu repoo uztaisīt
//3. jaunu projektu
//4. jaunas klases no Sem 4
	@Autowired
	private ICRUDProductService prodCRUDService;
	
	
	@Override
	public ArrayList<Product> filterProductsByPriceLargenThan(float priceThreshold) {
		ArrayList<Product> filteredProducts = new ArrayList<Product>();
		
		for(Product prod: prodCRUDService.readAllProducts())
		{
			if(prod.getPrice()>priceThreshold)
			{
				filteredProducts.add(prod);
			}
		}
		
		return filteredProducts;
	}

	@Override
	public ArrayList<Product> filterProductByQuantityLessThan(int quantityThreshold) {
		ArrayList<Product> filteredProducts = new ArrayList<Product>();
		
		for(Product prod: prodCRUDService.readAllProducts())
		{
			if(prod.getQuantity()<quantityThreshold)
			{
				filteredProducts.add(prod);
			}
		}
		
		return filteredProducts;
	}

	//TODO
	@Override
	public ArrayList<Product> getProductWithDiscount(int discountThreashold) {
		// TODO Auto-generated method stub
		return null;
	}

}
