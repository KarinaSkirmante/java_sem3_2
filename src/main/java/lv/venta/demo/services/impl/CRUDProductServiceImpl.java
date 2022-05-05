package lv.venta.demo.services.impl;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.demo.model.Product;
import lv.venta.demo.repos.IProductRepo;
import lv.venta.demo.services.ICRUDProductService;

@Service
public class CRUDProductServiceImpl implements ICRUDProductService {
	@Autowired
	private IProductRepo prodRepo;
	
	@Override
	public Product createProduct(Product temp) {
		
		if(prodRepo.existsByTitleAndPrice(temp.getTitle(),temp.getPrice()))
		{
			//1. iegūsta produktu no DB
			Product prod = prodRepo.findByTitleAndPrice(temp.getTitle(),temp.getPrice());
			
			//2. nomainām daudzumu
			int newQuantity = prod.getQuantity()+temp.getQuantity();
			prod.setQuantity(newQuantity);
			//3.saglabajam DB
			prodRepo.save(prod);
			//4. atgriežam produktu
			return prod;
			
		}
		else
		{
			//1. izveidojam produktu
			Product newProduct = new Product(temp.getTitle(), 
					temp.getPrice(), temp.getQuantity());
			//2.saglbajam izveidoto produktu DB
			Product productFromDb = prodRepo.save(newProduct);
			//ievedoto produktu atgriežam
			return productFromDb;
		}
		
	}

	@Override
	public ArrayList<Product> readAllProducts() {
		// TODO Auto-generated method stub
		return  (ArrayList<Product>) prodRepo.findAll();
	}

	@Override
	public Product readById(int id) throws Exception {
		
			if(prodRepo.existsById(id))
				return prodRepo.findById(id).get();
			else
				throw new Exception("Tāds id neeksistē");
		
	}

	@Override
	public void updateById(int id, Product temp) throws Exception {
		if(prodRepo.existsById(id))
		{
			//1. iegūstam produktu, kuru vēlamies rediget, no DB
			Product prod = prodRepo.findById(id).get();
			
			//2. redigejam produktu
				if(!prod.getTitle().equals(temp.getTitle()))
					prod.setTitle(temp.getTitle());
				if(prod.getQuantity() != temp.getQuantity())
					prod.setQuantity(temp.getQuantity());
				if(prod.getPrice()!=temp.getPrice())
					prod.setPrice(temp.getPrice());
				
			//3. saglabajam redigeto produktu DB
				prodRepo.save(prod);
			
		}
		else
		{
			throw new Exception("Tāds id neeksistē");
		}
		
	}

	@Override
	public void deleteById(int id) throws Exception {
		
		
			if(prodRepo.existsById(id))
				prodRepo.deleteById(id);
			else
				new Exception("Tāds id neeksistē");
	}
//1. service interfeiss IFilterProductService
//2. service kā klase un realīzet visas funkcijas	
	
	
}
