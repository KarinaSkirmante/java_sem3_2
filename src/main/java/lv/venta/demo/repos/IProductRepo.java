package lv.venta.demo.repos;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.model.Product;

public interface IProductRepo extends CrudRepository<Product, Integer> {

	public abstract boolean existsByTitleAndPrice(String title, float price);

	public abstract Product findByTitleAndPrice(String title, float price);

}
