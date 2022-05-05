package lv.venta.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.demo.model.Product;
import lv.venta.demo.repos.IProductRepo;
import lv.venta.demo.services.ICRUDProductService;
import lv.venta.demo.services.IFilterProductService;

@Service
public class FilterProductServiceImpl implements IFilterProductService {
//1. pārtaisīt FilterProductServiceImpl uz repo
//2. github/gitlab jaunu repoo uztaisīt
//3. jaunu projektu
//4. jaunas klases no Sem 4
	@Autowired
	private IProductRepo prodRepo;
	
	
	@Override
	public ArrayList<Product> filterProductsByPriceLargenThan(float priceThreshold) {
		
		ArrayList<Product> filteredProducts = prodRepo.findByPriceGreaterThan(priceThreshold);
		return filteredProducts;
	}

	@Override
	public ArrayList<Product> filterProductByQuantityLessThan(int quantityThreshold) {
		
		ArrayList<Product> filteredProducts = prodRepo.findByQuantityLessThan(quantityThreshold);
		return filteredProducts;
	}

	//TODO
	@Override
	public ArrayList<Product> getProductWithDiscount(int discountThreashold) {
		// TODO Auto-generated method stub
		return null;
	}

}
