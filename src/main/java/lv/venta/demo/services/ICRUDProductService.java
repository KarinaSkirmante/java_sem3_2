package lv.venta.demo.services;

import java.util.ArrayList;

import lv.venta.demo.model.Product;

public interface ICRUDProductService {
	//CRUD - create - read - update - delete
	//create
	public abstract Product createProduct(Product temp);
	
	//read all
	public abstract ArrayList<Product> readAllProducts();
	//read by id
	public abstract Product readById(int id) throws Exception;
	
	//update
	public abstract void updateById(int id, Product temp) throws Exception;
	
	//delete
	public abstract void deleteById(int id) throws Exception;
	
	
}
